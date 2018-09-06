package cww.world.pojo.po.workflow;

import com.alibaba.fastjson.JSON;

public class BusinessAuditProgressNotifyMessageDTO {
    BusinessAuditProgressPO progress;
    BusinessAuditPO businessAudit;

    public BusinessAuditProgressNotifyMessageDTO() {
    }

    public BusinessAuditProgressNotifyMessageDTO(BusinessAuditProgressPO progress, BusinessAuditPO businessAudit) {
        this.progress = progress;
        this.businessAudit = businessAudit;
    }

    public BusinessAuditProgressPO getProgress() {
        return progress;
    }

    public void setProgress(BusinessAuditProgressPO progress) {
        this.progress = progress;
    }

    public BusinessAuditPO getBusinessAudit() {
        return businessAudit;
    }

    public void setBusinessAudit(BusinessAuditPO businessAudit) {
        this.businessAudit = businessAudit;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
