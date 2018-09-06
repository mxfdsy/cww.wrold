package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.account.UserAccountPO;

import java.util.List;

public class BusinessAuditInfoDTO {
    @JSONField(name = "auditor_list")
    private List<UserAccountPO> auditorList;
    @JSONField(name = "workflow_step_uid")
    private String workflowStepUid;
    @JSONField(name = "workflow_step")
    private Integer workflowStep;
    @JSONField(name = "workflow_step_desc")
    private String workflowStepDesc;
    @JSONField(name = "current_progress_uid")
    private String currentProgressUid;


    public List<UserAccountPO> getAuditorList() {
        return auditorList;
    }

    public void setAuditorList(List<UserAccountPO> auditorList) {
        this.auditorList = auditorList;
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

    public String getWorkflowStepDesc() {
        return workflowStepDesc;
    }

    public void setWorkflowStepDesc(String workflowStepDesc) {
        this.workflowStepDesc = workflowStepDesc;
    }

    public String getCurrentProgressUid() {
        return currentProgressUid;
    }

    public void setCurrentProgressUid(String currentProgressUid) {
        this.currentProgressUid = currentProgressUid;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}


