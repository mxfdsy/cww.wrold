package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GroupRoleDTO{

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

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getIsChangeable() {
        return isChangeable;
    }

    public void setIsChangeable(String isChangeable) {
        this.isChangeable = isChangeable;
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

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
