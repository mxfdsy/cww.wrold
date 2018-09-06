package cww.world.pojo.po.workflow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.Enum.workflow.AuditStatusEnum;

import java.util.Date;

public class MyApproveDTO {
    @JSONField(name = "workflow_uid")
    private String workflowUid;
    @JSONField(name = "audit_uid")
    private String auditUid;
    @JSONField(name = "audit_status")
    private AuditStatusEnum auditStatus;
    @JSONField(name = "progress_uid")
    private String progressUid;
    @JSONField(name = "business_type")
    private String businessType;
    @JSONField(name = "business_uid")
    private String businessUid;
    @JSONField(name = "apply_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date applyAt;
    @JSONField(name = "auditor_list_name")
    private String auditorListName;
    @JSONField(name = "business_name")
    private String businessName;

    public String getWorkflowUid() {
        return workflowUid;
    }

    public void setWorkflowUid(String workflowUid) {
        this.workflowUid = workflowUid;
    }

    public String getProgressUid() {
        return progressUid;
    }

    public void setProgressUid(String progressUid) {
        this.progressUid = progressUid;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessUid() {
        return businessUid;
    }

    public void setBusinessUid(String businessUid) {
        this.businessUid = businessUid;
    }

    public Date getApplyAt() {
        return applyAt;
    }

    public void setApplyAt(Date applyAt) {
        this.applyAt = applyAt;
    }

    public String getAuditorListName() {
        return auditorListName;
    }

    public void setAuditorListName(String auditorListName) {
        this.auditorListName = auditorListName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAuditUid() {
        return auditUid;
    }

    public void setAuditUid(String auditUid) {
        this.auditUid = auditUid;
    }

    public AuditStatusEnum getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatusEnum auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
