package cww.world.pojo.dto.menu;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Teo on 2018/6/14.
 */
public class ListMenuRequestDTO {
    @JSONField(name = "role_uid")
    private String roleUid;

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
