package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Teo on 2018/8/16.
 */
public class MenuNavigationDTO {
    @JSONField(name = "parent_menu_name")
    private String parentMenuName;

    @JSONField(name = "parent_menu_url")
    private String parentMenuUrl;

    @JSONField(name = "children_menu_name")
    private String childrenMenuName;

    @JSONField(name = "children_menu_url")
    private String childrenMenuUrl;

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

    public String getChildrenMenuName() {
        return childrenMenuName;
    }

    public void setChildrenMenuName(String childrenMenuName) {
        this.childrenMenuName = childrenMenuName;
    }

    public String getParentMenuUrl() {
        return parentMenuUrl;
    }

    public void setParentMenuUrl(String parentMenuUrl) {
        this.parentMenuUrl = parentMenuUrl;
    }

    public String getChildrenMenuUrl() {
        return childrenMenuUrl;
    }

    public void setChildrenMenuUrl(String childrenMenuUrl) {
        this.childrenMenuUrl = childrenMenuUrl;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
