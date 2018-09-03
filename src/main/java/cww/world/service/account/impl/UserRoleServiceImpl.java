package cww.world.service.account.impl;

import cww.world.mapper.account.UserRoleMapper;
import cww.world.pojo.dto.role.UserRoleRequestDTO;
import cww.world.service.account.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 小武 on 2018/9/3.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapepr;


    @Override
    public int deleteByUids(UserRoleRequestDTO request) {
        return userRoleMapepr.deleteByUids(request);
    }

}
