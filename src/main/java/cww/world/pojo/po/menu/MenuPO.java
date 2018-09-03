package cww.world.pojo.po.menu;

import cww.world.pojo.po.BasePO;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MenuPO extends BasePO {
    private Integer id;
    
    private String menuUid;
    
    private String name;
    
    private Integer parent;
    
    private Integer layer;
    
    private Integer sort;

    private String menuIcon;
    
    private String menuIconChecked;
    
    private String skipUrl;
    
    private String code;
    
    private String permissionKeys;

    private String menuType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuUid() {
        return menuUid;
    }

    public void setMenuUid(String menuUid) {
        this.menuUid = menuUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuIconChecked() {
        return menuIconChecked;
    }

    public void setMenuIconChecked(String menuIconChecked) {
        this.menuIconChecked = menuIconChecked;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPermissionKeys() {
        return permissionKeys;
    }

    public void setPermissionKeys(String permissionKeys) {
        this.permissionKeys = permissionKeys;
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
