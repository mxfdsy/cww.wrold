package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.BaseDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by xf on 2018/6/4.
 */
public class RoleUserInfoDTO extends BaseDTO {

    @JSONField(name = "user_uid")
    private String userUid;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "phone")
    private String phone;
    @JSONField(name = "memo")
    private String memo;
    @JSONField(name = "organization")
    private String organization;
    @JSONField(name = "login_name")
    private String loginName;
    @JSONField(name = "status")
    private String status;
    @JSONField(name = "gender")
    private String gender;
    @JSONField(name = "organization_code")
    private String organizationCode;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
