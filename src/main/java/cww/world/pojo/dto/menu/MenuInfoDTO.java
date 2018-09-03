package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class MenuInfoDTO {
	
	@JSONField(name = "bm_uid")
	private String bmUid;
	
	@JSONField(name = "id")
    private String id;
	
	@JSONField(name = "parent")
	private String parent;
	
	@JSONField(name = "sort")
	private int sort;

	@JSONField(name = "menu_icon")
	private String menuIcon;
	@JSONField(name = "menu_icon_checked")
	private String menuIconChecked;
	
	@JSONField(name = "name")
	private String name;
	
	@JSONField(name = "skip_url")
	private String skipUrl;
	
	@JSONField(name = "code")
	private String code;
	
	@JSONField(name = "layer")
	private int layer;
	
	@JSONField(name = "permission_keys")
	private String permissionKeys;

	@JSONField(name = "menu_uid")
	private String menuUid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBmUid() {
        return bmUid;
    }

    public void setBmUid(String bmUid) {
        this.bmUid = bmUid;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public String getPermissionKeys() {
        return permissionKeys;
    }

    public void setPermissionKeys(String permissionKeys) {
        this.permissionKeys = permissionKeys;
    }

    public String getMenuUid() {
        return menuUid;
    }

    public void setMenuUid(String menuUid) {
        this.menuUid = menuUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}