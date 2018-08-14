package cww.world.service.user.impl;

import cww.world.mapper.user.UserPOMapper;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小武 on 2018/8/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserPOMapper userPOMapper;

    @Override
    public List<UserPO> userList() {
       return userPOMapper.listUserInfo();
    }
}
