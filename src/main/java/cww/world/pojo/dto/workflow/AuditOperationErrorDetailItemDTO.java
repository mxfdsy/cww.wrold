package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author xujun
 */
public class AuditOperationErrorDetailItemDTO {
    @JSONField(name = "progress_uid")
    private String progressUid;
    private String memo;
    @JSONField(name = "error_msg")
    private String errorMsg;
    @JSONField(name = "error_code")
    private Integer errorCode;

    public AuditOperationErrorDetailItemDTO() {
    }

    public AuditOperationErrorDetailItemDTO(AuditOperationItem progress, String localizedMessage) {
        this.progressUid = progress.getProgressUid();
        this.memo = progress.getMemo();
        this.errorMsg = localizedMessage;
        this.errorCode = 500;
    }

    public AuditOperationErrorDetailItemDTO(AuditOperationItem progress, Integer errorCode, String errorMsg) {
        this.progressUid = progress.getProgressUid();
        this.memo = progress.getMemo();
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public String getProgressUid() {
        return progressUid;
    }

    public void setProgressUid(String progressUid) {
        this.progressUid = progressUid;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AuditOperationErrorDetailItemDTO{");
        sb.append("progressUid='").append(progressUid).append('\'');
        sb.append(", errorMsg='").append(errorMsg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
