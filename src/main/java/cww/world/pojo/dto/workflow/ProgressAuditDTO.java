package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.Enum.workflow.AuditStatusEnum;

import java.util.List;

public class ProgressAuditDTO {
    @JSONField(name = "audit_progress_uid")
    private String auditProgressUid;
    @JSONField(name = "audit_user_uid")
    private String auditUserUid;
    @JSONField(name = "audit_user_name")
    private String auditUserName;
    @JSONField(name = "audit_user_phone")
    private String auditUserPhone;
    @JSONField(name = "audit_status")
    private AuditStatusEnum auditStatus;
    @JSONField(name = "audit_reason")
    private String auditReason;
    @JSONField(name = "next_auditor_list")
    private List<String> nextAuditorList;

    public String getAuditProgressUid() {
        return auditProgressUid;
    }

    public void setAuditProgressUid(String auditProgressUid) {
        this.auditProgressUid = auditProgressUid;
    }

    public String getAuditUserUid() {
        return auditUserUid;
    }

    public void setAuditUserUid(String auditUserUid) {
        this.auditUserUid = auditUserUid;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    public String getAuditUserPhone() {
        return auditUserPhone;
    }

    public void setAuditUserPhone(String auditUserPhone) {
        this.auditUserPhone = auditUserPhone;
    }

    public AuditStatusEnum getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(AuditStatusEnum auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason;
    }

    public List<String> getNextAuditorList() {
        return nextAuditorList;
    }

    public void setNextAuditorList(List<String> nextAuditorList) {
        this.nextAuditorList = nextAuditorList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
