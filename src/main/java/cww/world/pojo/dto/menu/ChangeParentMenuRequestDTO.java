package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Update;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotNull;

/**
 * Created by Teo on 2018/8/1.
 */
public class ChangeParentMenuRequestDTO {
    @NotNull(message = "缺少目标父级菜单ID", groups = {Update.class})
    @JSONField(name = "target_parent_menu_id")
    private Integer targetParentMenuId;

    @NotNull(message = "缺少子级菜单ID", groups = {Update.class})
    @JSONField(name = "source_children_menu_id")
    private Integer sourceChildrenMenuId;

    @JSONField(name = "code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTargetParentMenuId() {
        return targetParentMenuId;
    }

    public void setTargetParentMenuId(Integer targetParentMenuId) {
        this.targetParentMenuId = targetParentMenuId;
    }

    public Integer getSourceChildrenMenuId() {
        return sourceChildrenMenuId;
    }

    public void setSourceChildrenMenuId(Integer sourceChildrenMenuId) {
        this.sourceChildrenMenuId = sourceChildrenMenuId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
