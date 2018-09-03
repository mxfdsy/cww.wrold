package cww.world.pojo.po.account;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.BasePO;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserRolePO extends BasePO {
    @JSONField(name = "user_uid")
    private String userUid;
    
	@JSONField(name = "role_uid")
	private String roleUid;
	
	@JSONField(name = "role_key")
	private String roleKey;
	
	@JSONField(name = "mall_uid")
	private String mallUid;

	@JSONField(name = "old_mall_uid")
	private String oldMallUid;

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getMallUid() {
        return mallUid;
    }

    public void setMallUid(String mallUid) {
        this.mallUid = mallUid;
    }

    public String getOldMallUid() {
        return oldMallUid;
    }

    public void setOldMallUid(String oldMallUid) {
        this.oldMallUid = oldMallUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
