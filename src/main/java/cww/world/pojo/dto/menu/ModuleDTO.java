package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;


public class ModuleDTO {

    @JSONField(name = "menu_name")
    private String menuName;
    
    @JSONField(name = "menu_id")
    private Integer menuId;

    @JSONField(name = "menu_icon")
    private String menuIcon;

    @JSONField(name = "menu_icon_checked")
    private String menuIconChecked;
    
    @JSONField(name = "children")
    private List<ChildMenuDTO> children;

    @JSONField(name = "sort")
    private Integer sort;

    @JSONField(name = "menu_type")
    private String menuType;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public List<ChildMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ChildMenuDTO> children) {
        this.children = children;
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
