package cww.world.pojo.po.user;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import cww.world.common.validate.group.Update;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class UserPO implements Serializable {
    @JSONField(name = "id")
    private String id;

    @JSONField(name = "userUid")
    private String userUid;

    @JSONField(name = "userName")
    private String userName;

    @NotNull(message = "登陆名不能为空",groups = Insert.class)
    @JSONField(name = "loginName")
    private String loginName;

    @NotNull(message = "密码不能为空",groups ={Insert.class,Update.class} )
    @JSONField(name = "password")
    private String password;

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

    @JSONField(name = "identity")
    private String identity;

    @JSONField(name = "memo")
    private String memo;

    @JSONField(name = "createdAt")
    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

    private int archive;

    private static final long serialVersionUID = 1L;


    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo == null ? null : wechatNo.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }
}