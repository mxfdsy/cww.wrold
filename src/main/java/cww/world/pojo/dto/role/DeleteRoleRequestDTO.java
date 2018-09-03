package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;

public class DeleteRoleRequestDTO{
    
    @JSONField(name = "role_uid")
    private String roleUid;
    
    @JSONField(name = "role_key")
    private String roleKey;

    public String getRoleUid() {
        return roleUid;
    }

    public String getRoleKey() {
        return roleKey;
    }


    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DeleteRoleRequestDTO [roleUid=");
        builder.append(roleUid);
        builder.append(", roleKey=");
        builder.append(roleKey);
        builder.append("]");
        return builder.toString();
    }

}
