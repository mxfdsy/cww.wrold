package cww.world.pojo.dto.workflow;

public class NeedSyncAuditProgressDTO {
    private String progressUid;
    private String workflowStepUid;
    private String auditUid;
    private String mallUid;

    public String getProgressUid() {
        return progressUid;
    }

    public void setProgressUid(String progressUid) {
        this.progressUid = progressUid;
    }

    public String getMallUid() {
        return mallUid;
    }

    public void setMallUid(String mallUid) {
        this.mallUid = mallUid;
    }

    public String getAuditUid() {
        return auditUid;
    }

    public void setAuditUid(String auditUid) {
        this.auditUid = auditUid;
    }

    public String getWorkflowStepUid() {
        return workflowStepUid;
    }

    public void setWorkflowStepUid(String workflowStepUid) {
        this.workflowStepUid = workflowStepUid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NeedSyncAuditProgressDTO{");
        sb.append("progressUid='").append(progressUid).append('\'');
        sb.append(", workflowStepUid='").append(workflowStepUid).append('\'');
        sb.append(", auditUid='").append(auditUid).append('\'');
        sb.append(", mallUid='").append(mallUid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
