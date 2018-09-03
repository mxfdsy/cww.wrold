package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;


public class ChildMenuDTO {
    
    @JSONField(name = "menu_id")
    private Integer menuId;
    
    @JSONField(name = "menu_name")
    private String menuName;

    @JSONField(name = "skip_url")
    private String skipUrl;
    
    @JSONField(name = "permissions")
    private List<PermissionDTO> permissions;

    @JSONField(name = "sort")
    private Integer sort;

    @JSONField(name = "menu_type")
    private String menuType;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<PermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDTO> permissions) {
        this.permissions = permissions;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
