package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class InsertChildrenMenuDTO {
    @NotNull(message="缺少模块id", groups={Insert.class})
    @Size(min=1, message="缺少模块id", groups={Insert.class})
    @JSONField(name = "modul_id")
    private String modulId;
    
    @JSONField(name = "modul_name")
    private String modulName;
    
    @NotNull(message="缺少页面名称", groups={Insert.class})
    @Size(min=1, message="缺少页面名称", groups={Insert.class})
    @JSONField(name = "menu_name")
    private String menuName;
    
    @NotNull(message="缺少页面跳转链接", groups={Insert.class})
    @Size(min=1, message="缺少页面跳转链接", groups={Insert.class})
    @JSONField(name = "skip_url")
    private String skipUrl;
    
    @NotNull(message="缺少权限", groups={Insert.class})
    @Size(min=1, message="缺少权限", groups={Insert.class})
    @JSONField(name = "permission_key")
    private String permissionKey;
    
    @NotNull(message="缺少权限名称", groups={Insert.class})
    @Size(min=1, message="缺少权限名称", groups={Insert.class})
    @JSONField(name = "permission_name")
    private String permissionName;

    @JSONField(name = "operator_user")
    private String operatorUser;

    @JSONField(name = "sort")
    private Integer sort;

    public String getModulId() {
        return modulId;
    }

    public void setModulId(String modulId) {
        this.modulId = modulId;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
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

    public String getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(String operatorUser) {
        this.operatorUser = operatorUser;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
