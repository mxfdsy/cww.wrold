package cww.world.service.role.impl;

import com.alibaba.fastjson.JSON;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.SequenceNameEnum;
import cww.world.common.exception.BaseException;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.controller.BaseController;
import cww.world.mapper.role.RoleMapper;
import cww.world.pojo.dto.GridPage;
import cww.world.pojo.dto.role.CreateRoleDTO;
import cww.world.pojo.dto.role.DeleteRoleRequestDTO;
import cww.world.pojo.dto.role.EditRoleRequestDTO;
import cww.world.pojo.dto.role.ListGroupRoleRequestDTO;
import cww.world.pojo.po.role.RolePO;
import cww.world.service.common.SysDBService;
import cww.world.service.menu.RolePermissionService;
import cww.world.service.role.RoleService;
import org.apache.catalina.Role;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 小武 on 2018/9/3.
 */
@Service
public class RoleServiceImpl extends BaseController implements RoleService {
    private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);


    @Autowired
    private SysDBService sysDBService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private RoleService roleService;


    public static final String ROLE = "role";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createRole(EditRoleRequestDTO request) {
        long sequenceVal = sysDBService.getSequenceNextVal(SequenceNameEnum.TNT_SYS_ROLR_KEY.getSequenceName());
        Integer count = roleMapper.countByRoleName(request.getRoleName());
        if (null != count && count > 0) {
            logger.error("角色名已经存在，{}",request.getRoleName());
            throw new BaseException(BaseCode.ROLE_NAME_IS_EXIST_ERROR);
        }
        String roleKey = ROLE + Long.toString(sequenceVal);
        CreateRoleDTO createRole = new CreateRoleDTO(null, roleKey, request.getRoleName(),
                request.getRoleDesc(), request.getIsChangeable(),request.getOperatorUid(),null,request.getArchive());
        roleMapper.insert(createRole);
        RolePO rolePO = roleMapper.getRoleInfoByRoleKey(roleKey);
        if (null == rolePO) {
            logger.error("角色创建失败");
            throw new BaseException(BaseCode.ROLE_CREATE_ERROR);
        }
        String roleUid = rolePO.getRoleUid();
        rolePermissionService.insertRolePermission(roleUid, request);
        return roleUid;
    }


    @Override
    public GridPage<RolePO> listRole(ListGroupRoleRequestDTO request) {
        Integer count = roleMapper.countRole(request);
        if (null == count || count == 0){
            return GridPage.emptyInstance();
        }
        //获取所有角色
        List<RolePO> roleList = roleMapper.listRole(request);
        return new GridPage(count, roleList);
    }


    @Override
    public RolePO getRoleInfoByRoleUid(String roleUid) {
        return roleMapper.getRoleInfoByRoleUid(roleUid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(DeleteRoleRequestDTO request) {
        //查询对应的角色信息
        RolePO role = roleMapper.queryRoleByUidOrKey(request.getRoleUid(), request.getRoleKey());
//        if(null == role){
//            logger.error("无法根据UID或者KEY查询到对应的角色，请求参数:{}", JSON.toJSONString(request));
//            throw new BaseException(BaseCode.NO_SUCH_ROLE_NAME_PERMISSION, "无法根据UID或者KEY查询到对应的角色");
//        }
        //校验是否有关联用户
//        if(isRoleRelateUser(request.getRoleUid())){
//            throw new BaseException(BaseCode.ROLE_ALREADY_RELATE_USER, "该角色有关联用户，无法删除");
//        }
        //校验该角色是否能被删除
//        if(ROLE_UNCHANGEABLE.equals(role.getIsChangeable())){
//            logger.error("该角色被设定为无法删除，请求参数:{}", JSON.toJSONString(request));
//            throw new BaseException(BaseCode.NO_SUCH_ROLE_NAME_PERMISSION, "该角色被设定为无法删除");
//        }

        //删除角色表中的相关记录
        roleMapper.deleteRoleByRoleUid(role.getRoleUid());

        //删除角色权限表中的相关记录
        rolePermissionService.deleteByRoleUid(role.getRoleUid());
    }

    @Override
    public RolePO searchRoleByUidOrKey(String roleUid, String roleKey) {
        return roleMapper.queryRoleByUidOrKey(roleUid, roleKey);
    }


}
