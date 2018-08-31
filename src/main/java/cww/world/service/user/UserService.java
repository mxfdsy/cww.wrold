package cww.world.service.user;

import cww.world.pojo.dto.user.ListUserDTO;
import cww.world.pojo.dto.user.UpdateUserStatusRequestDTO;
import cww.world.pojo.dto.user.UserInfoResponseDTO;
import cww.world.pojo.po.user.UserPO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 小武 on 2018/8/14.
 */
public interface UserService {
    List<UserPO> userList(ListUserDTO listUserDTO);

    String login(UserPO loginUser, HttpServletRequest request);

    UserInfoResponseDTO getUserInfoByUserUid(String userUid);

    String createUser(UserPO userPO);

    void updateUserinfo(UserPO userPO);

    int updateUserStatus(UpdateUserStatusRequestDTO requestDTO);

    void batchInsertUserInfo(List<UserPO> userPOS);
}
