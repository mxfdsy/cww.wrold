package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.account.UserAccountPO;
import cww.world.pojo.po.workflow.BusinessAuditPO;
import cww.world.pojo.po.workflow.BusinessAuditProgressPO;

import java.util.List;


public class BusinessAuditHistoryDTO {
    private BusinessAuditPO audit;
    @JSONField(name = "apply_user")
    private UserAccountPO applyUser;
    @JSONField(name = "progress_list")
    private List<BusinessAuditProgressPO> progressList;

    public BusinessAuditHistoryDTO() {
    }

    public BusinessAuditHistoryDTO(BusinessAuditPO auditInfo, List<BusinessAuditProgressPO> progressList, UserAccountPO applyUser) {
        this.audit = auditInfo;
        this.progressList = progressList;
        this.applyUser = applyUser;
    }

    public BusinessAuditPO getAudit() {
        return audit;
    }

    public void setAudit(BusinessAuditPO audit) {
        this.audit = audit;
    }

    public List<BusinessAuditProgressPO> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<BusinessAuditProgressPO> progressList) {
        this.progressList = progressList;
    }

    public UserAccountPO getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(UserAccountPO applyUser) {
        this.applyUser = applyUser;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
