package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.PageableRequestDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by xf on 2018/6/4.
 */
public class SearchRoleUserDTO extends PageableRequestDTO {

    @JSONField(name = "login_name")
    private String loginName;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "role_uid")
    private String roleUid;
    @JSONField(name = "memo")
    private String memo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
