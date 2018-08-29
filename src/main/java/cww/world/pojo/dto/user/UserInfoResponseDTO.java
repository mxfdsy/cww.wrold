package cww.world.pojo.dto.user;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.BasePO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Teo on 2018/6/19.
 */
public class UserInfoResponseDTO extends BasePO {

    @JSONField(name = "userUid")
    private String userUid;

    @JSONField(name = "userName")
    private String userName;

    @JSONField(name = "loginName")
    private String loginName;

    @JSONField(name = "phone")
    private String phone;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "gender")
    private String gender;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "wechatNo")
    private String wechatNo;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
