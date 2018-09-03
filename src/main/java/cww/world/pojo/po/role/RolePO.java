package cww.world.pojo.po.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.BasePO;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RolePO extends BasePO {
    
    private Integer id; 
    
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

    @JSONField(name = "gw_code")
    private String gwCode;

    public String getGwCode() {
        return gwCode;
    }

    public void setGwCode(String gwCode) {
        this.gwCode = gwCode;
    }

    public Integer getId() {
        return id;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
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

    public String getIsChangeable() {
        return isChangeable;
    }

    public void setIsChangeable(String isChangeable) {
        this.isChangeable = isChangeable;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
