package cww.world.pojo.po.workflow;


import cww.world.common.Enum.workflow.AuditStatusEnum;
import cww.world.common.Enum.workflow.BusinessType;
import cww.world.pojo.po.BasePO;

import java.util.List;

/**
 * @author xujun
 */
public class BusinessAuditPO extends BasePO {
    private String auditUid;
    private String workflowUid;
    private BusinessType businessType;
    private String businessUid;
    private String businessName;
    private String businessData;
    private String mallUid;
    private AuditStatusEnum auditStatus;

    private List<BusinessAuditProgressPO> progress;

    public String getAuditUid() {
        return auditUid;
    }

    public void setAuditUid(String auditUid) {
        this.auditUid = auditUid;
    }

    public String getWorkflowUid() {
        return workflowUid;
    }

    public void setWorkflowUid(String workflowUid) {
        this.workflowUid = workflowUid;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getBusinessUid() {
        return businessUid;
    }

    public void setBusinessUid(String businessUid) {
        this.businessUid = businessUid;
    }

    public String getBusinessData() {
        return businessData;
    }

    public void setBusinessData(String businessData) {
        this.businessData = businessData;
    }

    public AuditStatusEnum getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatusEnum auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getMallUid() {
        return mallUid;
    }

    public void setMallUid(String mallUid) {
        this.mallUid = mallUid;
    }

    public List<BusinessAuditProgressPO> getProgress() {
        return progress;
    }

    public void setProgress(List<BusinessAuditProgressPO> progress) {
        this.progress = progress;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
