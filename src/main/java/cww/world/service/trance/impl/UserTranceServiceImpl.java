package cww.world.service.trance.impl;

import com.alibaba.fastjson.JSONObject;
import cww.world.common.Enum.trance.UserItemNameEnum;
import cww.world.mapper.trace.ModuleOperationTraceDetailMapper;
import cww.world.mapper.trace.ModuleOperationTraceMapper;
import cww.world.pojo.dto.messsage.ModuleOperationTraceMessageDTO;
import cww.world.pojo.dto.messsage.user.UserEditDTO;
import cww.world.pojo.po.trace.Generic;
import cww.world.pojo.po.trace.ModuleOperationTraceDetailPO;
import cww.world.pojo.po.trace.ModuleOperationTracePO;
import cww.world.service.trance.TranceService;
import cww.world.service.trance.UserOperationTraceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author 小武 on 2018/9/1.
 */
@Service("userTranceImpl")
public class UserTranceServiceImpl implements TranceService {

    private static final Logger logger = LoggerFactory.getLogger(UserTranceServiceImpl.class);

    @Autowired
    private UserOperationTraceService traceService;

    @Autowired
    private ModuleOperationTraceMapper moduleOperationTraceMapper;

    @Autowired
    private ModuleOperationTraceDetailMapper moduleOperationTraceDetailMapper;

    @Override
    public void engerInfoParameter(ModuleOperationTraceMessageDTO moduleOperationTraceMessageDTO) {
        UserEditDTO newDataDTO = JSONObject.parseObject(moduleOperationTraceMessageDTO.getNewData(), UserEditDTO.class);
        UserEditDTO oldDataDTO = JSONObject.parseObject(moduleOperationTraceMessageDTO.getOldData(), UserEditDTO.class);

        ModuleOperationTracePO moduleOperationTracePO = buildOperationTrace(newDataDTO, moduleOperationTraceMessageDTO);

        //判断如果是insert 操作就直接插入        moduleOperationTraceMessageDTO.getOperationType()

        //判断是否删除操作 如果是就直接删除        moduleOperationTraceMessageDTO.getOperationType()



        //编辑


        //先获取前后编辑的字段不一样的值-利用反射获取字段-从而比较不同的出字段
        List<ModuleOperationTraceDetailPO> messageList = traceService.generateDetail(
                new Generic(newDataDTO), new Generic(oldDataDTO));

        //过滤不必要的字段(在集合中删除使用迭代器删除)-设置一个枚举类（key,value的形式） 放入我要比较的字段-new 一个map<string , Enum>,把enum字段的值放入map中-写一个静态的方法只要放入Key 就可以直接的知道是不是需要此字段的值
        Iterator iterator = messageList.iterator();
        while (iterator.hasNext()) {
            UserItemNameEnum userItemNameEnum = UserItemNameEnum.valueOfKeyStr(((ModuleOperationTraceDetailPO) iterator.next()).getItem());
            if (userItemNameEnum.equals(UserItemNameEnum.unknow)) {
                iterator.remove();
            }
        }

        // 若无修改字段 则不进行操作
        if (messageList == null || messageList.size() == 0) {
            return;
        }

        //插入记录主表
        int insertCount = moduleOperationTraceMapper.insertModuleOperationTrace(moduleOperationTracePO);
        logger.info("插入操作记录主表成功，影响行数为{}", insertCount);

        //开始设置变更的详情表中的具体信息
        messageList.stream().forEach(message -> {
            buildItemMemo(message);
            message.setItem(UserItemNameEnum.valueOf(message.getItem()).getItemName());
            message.setTraceUid(moduleOperationTracePO.getTraceUid());
        });

        //插入详情表
        int detailCount = moduleOperationTraceDetailMapper.batchInsertModuleOperationTraceDeatils(messageList);
        logger.info("插入操作记录详情表成功，影响行数为{}",detailCount);

    }


    private ModuleOperationTracePO buildOperationTrace(UserEditDTO newDataDTO, ModuleOperationTraceMessageDTO moduleOperationTraceMessage) {
        ModuleOperationTracePO moduleOperationTracePO = new ModuleOperationTracePO();
        moduleOperationTracePO.setMajorUid(newDataDTO.getCompanyUid());
        moduleOperationTracePO.setColumn1(newDataDTO.getCompanyName());
        moduleOperationTracePO.setOperationType(moduleOperationTraceMessage.getOperationType());
        //查询操作人信息
//        UserInfoResponseDTO userInfoResponseDTO = userAccountService.getUserInfoByUserUid(moduleOperationTraceMessage.getOperatorUserUid());
//        if (Objects.isNull(userInfoResponseDTO)) {
//            logger.error("不存在的审核人，userUid = {}", moduleOperationTraceMessage.getOperatorUserUid());
//            throw new BaseException(BaseCode.NO_SUCH_USER_ACCOUNT, "数据库中无该用户信息");
//        }
        //设置操作时间
//        moduleOperationTracePO.setOperateAt(moduleOperationTraceMessage.getOperateAt());
//        moduleOperationTracePO.setOperatorUserUid(userInfoResponseDTO.getUserUid());
//        moduleOperationTracePO.setOperatorOrganization(userInfoResponseDTO.getResultOrganizationName());
//        moduleOperationTracePO.setOperatorPhone(userInfoResponseDTO.getPhone());
//        moduleOperationTracePO.setOperatorName(userInfoResponseDTO.getName());
//        moduleOperationTracePO.setCreatedBy(userInfoResponseDTO.getUserUid());
        //设置与全局表关联的uid
        moduleOperationTracePO.setOperationTraceUid(moduleOperationTraceMessage.getOperationTraceUid());
        return moduleOperationTracePO;
    }


    protected void buildItemMemo(ModuleOperationTraceDetailPO message){
        if (StringUtils.isEmpty(message.getOldValue())) {
            message.setItemMemo("添加" + message.getNewValue());
        } else if (StringUtils.isEmpty(message.getNewValue())) {
            message.setItemMemo("删除" + message.getOldValue());
        } else {
            message.setItemMemo("由" + message.getOldValue() + "变更为" + message.getNewValue());
        }
    }
}
