package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreateRoleDTO{
    
    @JSONField(name = "id")
    private String roleId;

    @JSONField(name = "role_uid")
    private String roleUid;
    
    @JSONField(name = "role_key")
    private String roleKey;
    
    @JSONField(name = "role_name")
    private String roleName;
    
    @JSONField(name = "role_desc")
    private String roleDesc;

    @JSONField(name = "is_changeable")
    private String isChangeable;

    @JSONField(name = "created_by")
    private String createdBy;

    @JSONField(name = "updated_by")
    private String updatedBy;

    private int archive;

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getIsChangeable() {
        return isChangeable;
    }

    public void setIsChangeable(String isChangeable) {
        this.isChangeable = isChangeable;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    public CreateRoleDTO() {
    }

    public CreateRoleDTO(String roleUid, String roleKey, String roleName, String roleDesc, String isChangeable, String createdBy, String updatedBy, Integer archive) {
        this.roleUid = roleUid;
        this.roleKey = roleKey;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.isChangeable = isChangeable;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.archive = archive;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
