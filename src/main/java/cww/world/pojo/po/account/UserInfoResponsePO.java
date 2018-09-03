package cww.world.pojo.po.account;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.BasePO;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by Teo on 2018/6/19.
 */
public class UserInfoResponsePO extends BasePO {

    @JSONField(name = "user_uid")
    private String userUid;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "login_name")
    private String loginName;

    @JSONField(name = "phone")
    private String phone;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "gender")
    private String gender;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "wechat_no")
    private String wechatNo;

//    @JSONField(name = "roles")
//    private List<UserRoleRelationDTO> roles;

    @JSONField(name = "result_organization_name")
    private String resultOrganizationName;
//
//    @JSONField(name = "organization")
//    private UserOrganizationRelationDTO organization;

    @JSONField(name = "role_names")
    private String roleNames;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



    public String getResultOrganizationName() {
        return resultOrganizationName;
    }

    public void setResultOrganizationName(String resultOrganizationName) {
        this.resultOrganizationName = resultOrganizationName;
    }


    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
