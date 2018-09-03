package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class InsertPermissionDTO {
    @NotNull(message="缺少权限", groups={Insert.class})
    @Size(min=1, message="缺少权限", groups={Insert.class})
    @JSONField(name = "permission_key")
    private String permissionKey;
    
    @NotNull(message="缺少权限名称", groups={Insert.class})
    @Size(min=1, message="缺少权限名称", groups={Insert.class})
    @JSONField(name = "permission_name")
    private String permissionName;
    
    @NotNull(message="缺少权限描述", groups={Insert.class})
    @Size(min=1, message="缺少权限描述", groups={Insert.class})
    @JSONField(name = "permission_desc")
    private String permissionDesc;
    
    @NotNull(message="缺少页面名称", groups={Insert.class})
    @Size(min=1, message="缺少页面名称", groups={Insert.class})
    @JSONField(name = "permission_module")
    private String permissionModule;
    
    @NotNull(message="缺少页面id", groups={Insert.class})
    @Size(min=1, message="缺少页面id", groups={Insert.class})
    @JSONField(name = "menu_id")
    private String menuId;
    
    @NotNull(message="缺少模块id", groups={Insert.class})
    @Size(min=1, message="缺少模块id", groups={Insert.class})
    @JSONField(name = "parent_menu_id")
    private String parentMenuId;

    private String operatorUser;

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

    public String getPermissionModule() {
        return permissionModule;
    }

    public void setPermissionModule(String permissionModule) {
        this.permissionModule = permissionModule;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(String operatorUser) {
        this.operatorUser = operatorUser;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("InsertPermissionDTO [permissionKey=");
        builder.append(permissionKey);
        builder.append(", permissionName=");
        builder.append(permissionName);
        builder.append(", permissionDesc=");
        builder.append(permissionDesc);
        builder.append(", permissionModule=");
        builder.append(permissionModule);
        builder.append(", menuId=");
        builder.append(menuId);
        builder.append(", parentMenuId=");
        builder.append(parentMenuId);
        builder.append(", operatorUser=");
        builder.append(operatorUser);
        builder.append("]");
        return builder.toString();
    }
}
