package cww.world.pojo.po.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.BasePO;

import java.util.List;

/**
 * 工作流程PO
 *
 * @author greatwall
 */
public class WorkflowPO extends BasePO {
    @JSONField(name = "workflow_uid")
    private String workflowUid;

    @JSONField(name = "workflow_key")
    private String workflowKey;

    @JSONField(name = "workflow_name")
    private String workflowName;

    @JSONField(name = "workflow_desc")
    private String workflowDesc;

    @JSONField(name = "workflow_step")
    private List<WorkflowStepPO> workflowStepPOs;

    public List<WorkflowStepPO> getWorkflowStepPOs() {
        return workflowStepPOs;
    }

    public void setWorkflowStepPOs(List<WorkflowStepPO> workflowStepPOs) {
        this.workflowStepPOs = workflowStepPOs;
    }

    public String getWorkflowUid() {
        return workflowUid;
    }

    public void setWorkflowUid(String workflowUid) {
        this.workflowUid = workflowUid;
    }

    public String getWorkflowKey() {
        return workflowKey;
    }

    public void setWorkflowKey(String workflowKey) {
        this.workflowKey = workflowKey;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getWorkflowDesc() {
        return workflowDesc;
    }

    public void setWorkflowDesc(String workflowDesc) {
        this.workflowDesc = workflowDesc;
    }
}
