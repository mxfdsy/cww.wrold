package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.PageableRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ListGroupRoleRequestDTO extends PageableRequestDTO {

    @JSONField(name = "role_name")
    private String roleName;

    @JSONField(name = "is_changeable")
    private String isChangeable;

    public String getRoleName() {
        if(StringUtils.isBlank(roleName)){
            return roleName;
        }
        return roleName.trim();
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getIsChangeable() {
        return isChangeable;
    }

    public void setIsChangeable(String isChangeable) {
        this.isChangeable = isChangeable;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
