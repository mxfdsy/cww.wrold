package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class RolePermissionInfoDTO {
    
    @JSONField(name = "permission_uid")
    private String permissionUid;
    
    @JSONField(name = "permission_key")
    private String permissionKey;

    @JSONField(name = "permission_name")
    private String permissionName;
    
    @JSONField(name = "permission_desc")
    private String permissionDesc;
    
    @JSONField(name = "permission_module")
    private String permissionModule;
    
    @JSONField(name = "role_uid")
    private String roleUid;

    @JSONField(name = "created_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    
    @JSONField(name = "created_by")
    private String createdBy;
    
    @JSONField(name = "updated_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    
    @JSONField(name = "updated_by")
    private String updatedBy;


    public String getPermissionKey() {
        return permissionKey;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public String getPermissionModule() {
        return permissionModule;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public void setPermissionModule(String permissionModule) {
        this.permissionModule = permissionModule;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


}
