package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.BaseDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Teo on 2018/5/31.
 */
public class MenuDTO extends BaseDTO {
    @JSONField(name = "menu_id")
    private Integer id;

    @JSONField(name = "menu_uid")
    private String menuUid;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "parent")
    private Integer parent;

    @JSONField(name = "layer")
    private Integer layer;

    @JSONField(name = "sort")
    private Integer sort;

    @JSONField(name = "menu_icon")
    private String menuIcon;

    @JSONField(name = "menu_icon_checked")
    private String menuIconChecked;

    @JSONField(name = "skip_url")
    private String skipUrl;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "permission_keys")
    private String permissionKeys;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
