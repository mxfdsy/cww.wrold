package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.Enum.workflow.AuditOperationEnum;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xujun
 */
public class AuditOperationDTO {
    @NotBlank(message = "审核人不为空")
    @JSONField(name = "auditor_user_uid")
    private String auditorUserUid;
    @NotNull(message = "操作类型不能为空")
    @JSONField(name = "operation")
    private AuditOperationEnum operation;
    @Valid
    @NotEmpty(message = "待处理列表不能为空")
    @JSONField(name = "progress_list")
    private List<AuditOperationItem> progressList;

    @JSONField(name = "next_auditor_list")
    private List<String> nextAuditorList;

    private String reason;

    public String getAuditorUserUid() {
        return auditorUserUid;
    }

    public void setAuditorUserUid(String auditorUserUid) {
        this.auditorUserUid = auditorUserUid;
    }

    public AuditOperationEnum getOperation() {
        return operation;
    }

    public void setOperation(AuditOperationEnum operation) {
        this.operation = operation;
    }

    public List<AuditOperationItem> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<AuditOperationItem> progressList) {
        this.progressList = progressList;
    }

    public List<String> getNextAuditorList() {
        return nextAuditorList;
    }

    public void setNextAuditorList(List<String> nextAuditorList) {
        this.nextAuditorList = nextAuditorList;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AuditOperationDTO{");
        sb.append("auditorUserUid='").append(auditorUserUid).append('\'');
        sb.append(", operation=").append(operation);
        sb.append(", progressList=").append(progressList);
        sb.append(", nextAuditorList=").append(nextAuditorList);
        sb.append(", reason='").append(reason).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
