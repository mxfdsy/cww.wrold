package cww.world.service.user;

import cww.world.pojo.po.user.UserPO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 小武 on 2018/8/14.
 */
public interface UserService {
    List<UserPO> userList();

    String login(UserPO loginUser, HttpServletRequest request);
}
