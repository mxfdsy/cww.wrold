package cww.world.pojo.po.workflow;

import cww.world.common.Enum.workflow.AuditStatusEnum;
import cww.world.pojo.po.BasePO;

/**
 * @author xujun
 */
public class BusinessAuditProgressPO extends BasePO {
    private String progressUid;
    private String auditUid;
    private String workflowStepUid;
    private Integer workflowStep;
    private String workflowStepDesc;
    private String auditorUserUid;
    private String auditorUserName;
    private String auditorUserPhone;
    private AuditStatusEnum auditStatus;

    public String getProgressUid() {
        return progressUid;
    }

    public void setProgressUid(String progressUid) {
        this.progressUid = progressUid;
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

    public Integer getWorkflowStep() {
        return workflowStep;
    }

    public void setWorkflowStep(Integer workflowStep) {
        this.workflowStep = workflowStep;
    }

    public String getAuditorUserUid() {
        return auditorUserUid;
    }

    public void setAuditorUserUid(String auditorUserUid) {
        this.auditorUserUid = auditorUserUid;
    }

    public String getAuditorUserName() {
        return auditorUserName;
    }

    public void setAuditorUserName(String auditorUserName) {
        this.auditorUserName = auditorUserName;
    }

    public String getAuditorUserPhone() {
        return auditorUserPhone;
    }

    public void setAuditorUserPhone(String auditorUserPhone) {
        this.auditorUserPhone = auditorUserPhone;
    }

    public AuditStatusEnum getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatusEnum auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getWorkflowStepDesc() {
        return workflowStepDesc;
    }

    public void setWorkflowStepDesc(String workflowStepDesc) {
        this.workflowStepDesc = workflowStepDesc;
    }
}
