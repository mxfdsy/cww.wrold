package cww.world.service.trance.impl;

import com.alibaba.fastjson.JSONObject;
import cww.world.pojo.dto.messsage.ModuleOperationTraceMessageDTO;
import cww.world.pojo.dto.messsage.user.UserEditDTO;
import cww.world.service.trance.TranceService;
import org.springframework.stereotype.Service;

/**
 * @author 小武 on 2018/9/1.
 */
@Service("userTranceServiceImpl")
public class UserTranceServiceImpl implements TranceService {

    @Override
    public void engerInfoParameter(ModuleOperationTraceMessageDTO moduleOperationTraceMessageDTO) {


        //判断如果是insert 操作就直接插入        moduleOperationTraceMessageDTO.getOperationType()

        //判断是否删除操作 如果是就直接删除        moduleOperationTraceMessageDTO.getOperationType()


        //编辑
        UserEditDTO newEditDTO = JSONObject.parseObject(moduleOperationTraceMessageDTO.getNewData(), UserEditDTO.class);
        UserEditDTO oldEditDTO = JSONObject.parseObject(moduleOperationTraceMessageDTO.getOldData(), UserEditDTO.class);






    }
}
