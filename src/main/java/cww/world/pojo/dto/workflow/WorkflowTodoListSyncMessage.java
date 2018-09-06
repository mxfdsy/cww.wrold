package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.JSON;
import cww.world.common.Enum.workflow.ApprovalGroupTypeEnum;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class WorkflowTodoListSyncMessage {
    @NotNull(message = "groupType不能为空")
    private ApprovalGroupTypeEnum approvalGroupType;
    @NotBlank(message = "approvalGroup不能为空")
    private String approvalGroup;

    public WorkflowTodoListSyncMessage() {
    }

    public WorkflowTodoListSyncMessage(ApprovalGroupTypeEnum approvalGroupType, String approvalGroup) {
        this.approvalGroupType = approvalGroupType;
        this.approvalGroup = approvalGroup;
    }

    @NotNull
    public ApprovalGroupTypeEnum getApprovalGroupType() {
        return approvalGroupType;
    }

    public void setApprovalGroupType(@NotNull ApprovalGroupTypeEnum approvalGroupType) {
        this.approvalGroupType = approvalGroupType;
    }

    public String getApprovalGroup() {
        return approvalGroup;
    }

    public void setApprovalGroup(String approvalGroup) {
        this.approvalGroup = approvalGroup;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
