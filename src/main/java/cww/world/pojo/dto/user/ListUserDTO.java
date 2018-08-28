package cww.world.pojo.dto.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.PageableRequestDTO;

/**
 * @author 小武 on 2018/8/24.
 */
public class ListUserDTO extends PageableRequestDTO {
    @JSONField(name = "userName")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return  JSON.toJSONString(this);
    }
}
