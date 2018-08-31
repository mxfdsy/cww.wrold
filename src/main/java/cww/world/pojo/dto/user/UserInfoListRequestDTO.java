package cww.world.pojo.dto.user;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.user.UserPO;

import java.util.List;

/**
 * @author 小武 on 2018/8/31.
 */
public class UserInfoListRequestDTO {

    @JSONField(name = "userList")
    List<UserPO> userList;

    public List<UserPO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserPO> userList) {
        this.userList = userList;
    }
}
