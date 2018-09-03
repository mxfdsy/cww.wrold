package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.BaseDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Teo on 2018/8/22.
 */
public class UpdateUserRoleRelationDTO extends BaseDTO {

    @JSONField(name = "user_uid")
    private String userUid;

    @JSONField(name = "old_role_uid")
    private String oldRoleUid;

    @JSONField(name = "target_role_uid")
    private String targetRoleUid;

    @JSONField(name = "mall_uid")
    private String mallUid;

    public String getMallUid() {
        return mallUid;
    }

    public void setMallUid(String mallUid) {
        this.mallUid = mallUid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getOldRoleUid() {
        return oldRoleUid;
    }

    public void setOldRoleUid(String oldRoleUid) {
        this.oldRoleUid = oldRoleUid;
    }

    public String getTargetRoleUid() {
        return targetRoleUid;
    }

    public void setTargetRoleUid(String targetRoleUid) {
        this.targetRoleUid = targetRoleUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
