package cww.world.service.menu.impl;


import cww.world.mapper.menu.RolePermissionMapper;
import cww.world.pojo.dto.role.EditRoleRequestDTO;
import cww.world.pojo.po.role.RolePermissionPO;
import cww.world.service.menu.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


/**
 * Created by Teo on 2018/5/29.
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    private static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);


    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<String> listPermissionUidsByRoleId(String roleUid) {
        return rolePermissionMapper.listPermissionUidsByRoleId(roleUid);
    }


    @Override
    public boolean insertRolePermission(String roleUid, EditRoleRequestDTO request) {
        List<RolePermissionPO> permissionPOList = buildPermissionPOList(request,roleUid);
        if (CollectionUtils.isEmpty(permissionPOList)) {
            return true;
        }
        return insertRolePermission(permissionPOList);
    }

    private List<RolePermissionPO> buildPermissionPOList( EditRoleRequestDTO request, String roleUid) {
        List<String> permissionUids = request.getPermissionUids();
        if (CollectionUtils.isEmpty(permissionUids)) {
            return Collections.emptyList();
        }
        List<RolePermissionPO> permissionPOList = new ArrayList<>(permissionUids.size());
        for (String permissionId : permissionUids) {
            RolePermissionPO rolePermissionPO = new RolePermissionPO(roleUid, permissionId, request.getOperatorUid(), request.getOperatorUid());
            permissionPOList.add(rolePermissionPO);
        }
        return permissionPOList;
    }

    private boolean insertRolePermission(List<RolePermissionPO> permissionPOList) {
        return rolePermissionMapper.batchInsert(permissionPOList) > 0;
    }

    @Override
    public int deleteByRoleUid(String roleUid) {
        return rolePermissionMapper.deleteByRoleUid(roleUid);
    }

    @Override
    public Set<String> listUserRolePermissionKey(List<String> roleUids) {
        if(CollectionUtils.isEmpty(roleUids)){
            return Collections.emptySet();
        }
        return rolePermissionMapper.listUserRolePermissionKey(roleUids);
    }
}
