package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;

public class RoleUserCountDTO{
    
    @JSONField(name = "role_uid")
    private String roleUid;
    
    @JSONField(name = "user_count")
    private Integer userCount;


    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GroupRoleUserCountDTO [roleUid=");
        builder.append(roleUid);
        builder.append(", userCount=");
        builder.append(userCount);
        builder.append("]");
        return builder.toString();
    }
}
