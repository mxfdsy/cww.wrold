package cww.world.service.user.impl;

import cww.world.common.constant.BaseCode;
import cww.world.common.exception.BaseException;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.mapper.user.UserPOMapper;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Override
    public String login(UserPO loginUserRequest, HttpServletRequest request) {
        UserPO loginUser= userPOMapper.countUesrInfoByLoginName(loginUserRequest.getLoginName());
        if (loginUser == null) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, "您还未注册哦，请先注册");
        }

        if (!loginUserRequest.getPassword().equals(loginUser.getPassword())) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, "密码输错了哦,请重新输入");
        }

        HttpSession session = request.getSession();
        session.setAttribute(loginUserRequest.getEmail(),loginUser);

        return ResultBuilderUtils.buildSuccess(loginUser);
    }
}
