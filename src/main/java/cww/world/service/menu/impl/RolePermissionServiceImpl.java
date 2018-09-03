package cww.world.service.menu.impl;


import cww.world.mapper.menu.RolePermissionMapper;
import cww.world.service.menu.RolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

}
