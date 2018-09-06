package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

public class AuditOperationItem {
    @NotBlank(message = "progressUid不能为空")
    @JSONField(name = "progress_uid")
    private String progressUid;
    /**
     * 处理失败时，原样返回
     */
    private String memo;

    public String getProgressUid() {
        return progressUid;
    }

    public void setProgressUid(String progressUid) {
        this.progressUid = progressUid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
