package cww.world.pojo.dto.user;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import cww.world.common.validate.group.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author 小武 on 2018/8/31.
 */
public class UpdateUserStatusRequestDTO {

   @NotBlank
   @JSONField(name = "status")
    private String status;

    @JSONField(name = "user_uids")
    @NotNull(message = "缺少用户Uid", groups = {Update.class})
    @Size(min = 1, message = "缺少用户Uid")
    private List<String> userUids;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getUserUids() {
        return userUids;
    }

    public void setUserUids(List<String> userUids) {
        this.userUids = userUids;
    }
}
