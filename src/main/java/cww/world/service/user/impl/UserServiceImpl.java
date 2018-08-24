package cww.world.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.exception.BaseException;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.mapper.user.UserPOMapper;
import cww.world.pojo.dto.PageableRequestDTO;
import cww.world.pojo.dto.user.ListUserDTO;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
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
    public List<UserPO> userList(ListUserDTO listUserDTO) {
       return userPOMapper.listUserInfo(listUserDTO);
    }

    @Override
    public String login(UserPO loginUserRequest, HttpServletRequest request) {
        UserPO loginUser= userPOMapper.getUserInfoByLoginName(loginUserRequest.getLoginName());
        if (loginUser == null) {
                throw new BaseException(BaseCode.INVALID_ARGUMENT, "您还未注册哦，请先注册");
            }

        if (!loginUserRequest.getPassword().equals(loginUser.getPassword())) {
                throw new BaseException(BaseCode.INVALID_ARGUMENT, "密码输错了哦,请重新输入");
            }

        HttpSession session = request.getSession();

        session.setAttribute(Constants.USER_INFO,loginUser);




        JSONObject res = new JSONObject();
        String lastRedirectUrl = (String) session.getAttribute(Constants.REDIRECT_URL);
        if (StringUtils.isNotBlank(lastRedirectUrl)) {
            res.put(Constants.LAST_REDIRECT_URL, lastRedirectUrl);
            session.setAttribute(Constants.REDIRECT_URL, null);
        }

        return ResultBuilderUtils.buildSuccess(loginUser);
    }
}
