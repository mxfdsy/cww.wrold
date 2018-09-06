package cww.world.pojo.po.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import cww.world.common.validate.group.Update;
import cww.world.pojo.po.BasePO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * 每个工作流程对应的步骤PO
 *
 * @author greatwall
 */
public class WorkflowStepPO extends BasePO {

    @JSONField(name = "step_uid")
    private String stepUid;

    @JSONField(name = "workflow_uid")
    private String workflowUid;

    @NotNull(message = "step不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "step")
    private Integer step;

    @NotBlank(message = "step_desc不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "step_desc")
    private String stepDesc;

    @NotBlank(message = "approval_level不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "approval_level")
    private String approvalLevel;

    @NotBlank(message = "approval_group_type不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "approval_group_type")
    private String approvalGroupType;

    @NotBlank(message = "approval_group不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "approval_group")
    private String approvalGroup;

    @NotBlank(message = "approval_group_name不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "approval_group_name")
    private String approvalGroupName;

    public String getStepUid() {
        return stepUid;
    }

    public void setStepUid(String stepUid) {
        this.stepUid = stepUid;
    }

    public String getWorkflowUid() {
        return workflowUid;
    }

    public void setWorkflowUid(String workflowUid) {
        this.workflowUid = workflowUid;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getApprovalLevel() {
        return approvalLevel;
    }

    public void setApprovalLevel(String approvalLevel) {
        this.approvalLevel = approvalLevel;
    }

    public String getApprovalGroupType() {
        return approvalGroupType;
    }

    public void setApprovalGroupType(String approvalGroupType) {
        this.approvalGroupType = approvalGroupType;
    }

    public String getApprovalGroup() {
        return approvalGroup;
    }

    public void setApprovalGroup(String approvalGroup) {
        this.approvalGroup = approvalGroup;
    }

    public String getStepDesc() {
        return stepDesc;
    }

    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc;
    }

    public String getApprovalGroupName() {
        return approvalGroupName;
    }

    public void setApprovalGroupName(String approvalGroupName) {
        this.approvalGroupName = approvalGroupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkflowStepPO stepPO = (WorkflowStepPO) o;
        return Objects.equals(stepUid, stepPO.stepUid) &&
                Objects.equals(workflowUid, stepPO.workflowUid) &&
                Objects.equals(step, stepPO.step) &&
                Objects.equals(stepDesc, stepPO.stepDesc) &&
                Objects.equals(approvalLevel, stepPO.approvalLevel) &&
                Objects.equals(approvalGroupType, stepPO.approvalGroupType) &&
                Objects.equals(approvalGroup, stepPO.approvalGroup);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stepUid, workflowUid, step, stepDesc, approvalLevel, approvalGroupType, approvalGroup);
    }
}
