package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import cww.world.common.validate.group.Update;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class EditRoleRequestDTO {
    
    @JSONField(name = "role_id")
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
    
    @JSONField(name = "permission_uids")
    @NotNull(message = "缺少权限", groups = {Insert.class, Update.class})
    @Size(min = 1,message = "缺少权限",groups = {Insert.class, Update.class})
    private List<String> permissionUids;

    @JSONField(name = "operator_uid")
    private String operatorUid;

    private int archive;

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
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
        if(StringUtils.isBlank(roleName)){
            return roleName;
        }
        return roleName.trim();
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

    public String getOperatorUid() {
        return operatorUid;
    }

    public void setOperatorUid(String operatorUid) {
        this.operatorUid = operatorUid;
    }

    public String getIsChangeable() {
        return isChangeable;
    }

    public void setIsChangeable(String isChangeable) {
        this.isChangeable = isChangeable;
    }

    public List<String> getPermissionUids() {
        return permissionUids;
    }

    public void setPermissionUids(List<String> permissionUids) {
        this.permissionUids = permissionUids;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
