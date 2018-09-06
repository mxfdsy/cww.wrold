package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author xujun
 */
public class AuditOperationResultDTO {
    private Integer success;
    private Integer fail;
    @JSONField(name = "fail_details")
    private List<AuditOperationErrorDetailItemDTO> failDetails;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

    public List<AuditOperationErrorDetailItemDTO> getFailDetails() {
        return failDetails;
    }

    public void setFailDetails(List<AuditOperationErrorDetailItemDTO> failDetails) {
        this.failDetails = failDetails;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AuditOperationResultDTO{");
        sb.append("success=").append(success);
        sb.append(", fail=").append(fail);
        sb.append(", failDetails=").append(failDetails);
        sb.append('}');
        return sb.toString();
    }
}
