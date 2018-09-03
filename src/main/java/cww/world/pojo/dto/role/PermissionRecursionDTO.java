package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class PermissionRecursionDTO {
    
    @JSONField(name = "permission_uid")
    private String permissionUid;
    
    @JSONField(name = "permission_key")
    private String permissionKey;

    @JSONField(name = "permission_name")
    private String permissionName;
    
    @JSONField(name = "permission_desc")
    private String permissionDesc;
    
    @JSONField(name = "child")
    private List<PermissionRecursionDTO> child;

    public String getPermissionUid() {
        return permissionUid;
    }

    public void setPermissionUid(String permissionUid) {
        this.permissionUid = permissionUid;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public List<PermissionRecursionDTO> getChild() {
        return child;
    }

    public void setChild(List<PermissionRecursionDTO> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PermissionRecursionDTO [permissionUid=");
        builder.append(permissionUid);
        builder.append(", permissionKey=");
        builder.append(permissionKey);
        builder.append(", permissionName=");
        builder.append(permissionName);
        builder.append(", permissionDesc=");
        builder.append(permissionDesc);
        builder.append(", child=");
        builder.append(child);
        builder.append("]");
        return builder.toString();
    }
}
