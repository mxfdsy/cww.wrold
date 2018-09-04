package cww.world.service.menu.impl;


import cww.world.mapper.menu.PermissionMapper;
import cww.world.pojo.po.menu.PermissionPO;
import cww.world.service.menu.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class PermissionServiceImpl implements PermissionService {
    private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<PermissionPO> listPermissionByParentMenuIds(List<Integer> moduleids) {
        return permissionMapper.listPermissionByParentMenuIds(moduleids);
    }

    @Override
    public int insertPermission(PermissionPO permission) {
        return permissionMapper.insertPermission(permission);
    }


    @Override
    public List<PermissionPO> listPermissionByPermissionKeys(Set<String> permissionKeys) {
        return permissionMapper.listPermissionByPermissionKeys(permissionKeys);
    }


    @Override
    public PermissionPO getPermissionByPermissionKey(String permissionKey) {
        return permissionMapper.getPermissionByPermissionKey(permissionKey);
    }

}
