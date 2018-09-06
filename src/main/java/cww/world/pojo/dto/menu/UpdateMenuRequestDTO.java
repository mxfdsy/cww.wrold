package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.BaseDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Teo on 2018/6/19.
 */
public class UpdateMenuRequestDTO extends BaseDTO {
    @JSONField(name = "menu_id")
    @NotNull(message = "缺少菜单ID", groups = {Integer.class})
    private Integer menuId;

    @JSONField(name = "skip_url")
    private String skipUrl;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "sort")
    private Integer sort;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
