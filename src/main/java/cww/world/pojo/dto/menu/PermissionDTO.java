package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;


public class PermissionDTO {
    
    @JSONField(name = "id")
    private Integer id;

    @JSONField(name = "permission_uid")
    private String permissionUid;
    
    @JSONField(name = "permission_name")
    private String permissionName;
    
    @JSONField(name = "permission_key")
    private String permissionKey;
    
    @JSONField(name = "permission_desc")
    private String permissionDesc;
    
    @JSONField(name = "is_role_selected")
    private boolean isRoleSelected;

    public String getPermissionUid() {
        return permissionUid;
    }

    public void setPermissionUid(String permissionUid) {
        this.permissionUid = permissionUid;
    }

    public boolean isRoleSelected() {
        return isRoleSelected;
    }

    public void setRoleSelected(boolean roleSelected) {
        isRoleSelected = roleSelected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public boolean getIsRoleSelected() {
        return isRoleSelected;
    }

    public void setIsRoleSelected(boolean isRoleSelected) {
        this.isRoleSelected = isRoleSelected;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PermissionDTO [id=");
        builder.append(id);
        builder.append(", permissionName=");
        builder.append(permissionName);
        builder.append(", permissionKey=");
        builder.append(permissionKey);
        builder.append(", permissionDesc=");
        builder.append(permissionDesc);
        builder.append(", isRoleSelected=");
        builder.append(isRoleSelected);
        builder.append("]");
        return builder.toString();
    }
}
