package cww.world.pojo.dto.role;


import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Delete;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wyz
 */
public class UserRoleRequestDTO {
    @NotNull(message="用户Uid不能为空")
    @Size(min=1, message="用户Uid不能为空")
    @JSONField(name="user_uids")
    private List<String> userUids;
    
    @NotNull(message="角色Uid不能为空", groups = {Delete.class})
    @Size(min=1, message="角色Uid不能为空", groups = {Delete.class})
    @JSONField(name="role_uid")
    private String roleUid;
    
    @NotNull(message="商场Uid不能为空")
    @Size(min=1, message="商场Uid不能为空")
    @JSONField(name="mall_uids")
    private List<String> mallUids;
    
    @JSONField(name="created_by")
    private String createdBy;
  
    @JSONField(name="updateed_by")
    private String updatedBy;
    
    
    public String getCreatedBy() {
        return createdBy;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getRoleUid() {
        return roleUid;
    }
    
    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }
    
    public List<String> getUserUids() {
        return userUids;
    }
    public List<String> getMallUids() {
        return mallUids;
    }
    public void setUserUids(List<String> userUids) {
        this.userUids = userUids;
    }
    public void setMallUids(List<String> mallUids) {
        this.mallUids = mallUids;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserRoleRequestDTO [userUids=");
        builder.append(userUids);
        builder.append(", roleUid=");
        builder.append(roleUid);
        builder.append(", mallUids=");
        builder.append(mallUids);
        builder.append(", createdBy=");
        builder.append(createdBy);
        builder.append(", updatedBy=");
        builder.append(updatedBy);
        builder.append("]");
        return builder.toString();
    }

    
}