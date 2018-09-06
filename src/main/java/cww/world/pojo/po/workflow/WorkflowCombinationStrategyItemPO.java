package cww.world.pojo.po.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.Enum.workflow.ApprovalGroupTypeEnum;
import cww.world.common.validate.group.Insert;
import cww.world.pojo.po.BasePO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class WorkflowCombinationStrategyItemPO extends BasePO {
    @JSONField(name = "combination_item_uid")
    private String combinationItemUid;
    @JSONField(name = "combination_uid")
    private String combinationUid;
    @NotNull(message = "审核组类型不能为空", groups = Insert.class)
    @JSONField(name = "approval_group_type")
    private ApprovalGroupTypeEnum approvalGroupType;
    @NotBlank(message = "审核组不能为空", groups = Insert.class)
    @JSONField(name = "approval_group")
    private String approvalGroup;
    @JSONField(name = "approval_group_name")
    private String approvalGroupName;
    @JSONField(name = "approval_group_mall")
    private String approvalGroupMall;

    public String getCombinationItemUid() {
        return combinationItemUid;
    }

    public void setCombinationItemUid(String combinationItemUid) {
        this.combinationItemUid = combinationItemUid;
    }

    public String getCombinationUid() {
        return combinationUid;
    }

    public void setCombinationUid(String combinationUid) {
        this.combinationUid = combinationUid;
    }

    public ApprovalGroupTypeEnum getApprovalGroupType() {
        return approvalGroupType;
    }

    public void setApprovalGroupType(ApprovalGroupTypeEnum approvalGroupType) {
        this.approvalGroupType = approvalGroupType;
    }

    public String getApprovalGroup() {
        return approvalGroup;
    }

    public void setApprovalGroup(String approvalGroup) {
        this.approvalGroup = approvalGroup;
    }

    public String getApprovalGroupName() {
        return approvalGroupName;
    }

    public void setApprovalGroupName(String approvalGroupName) {
        this.approvalGroupName = approvalGroupName;
    }

    public String getApprovalGroupMall() {
        return approvalGroupMall;
    }

    public void setApprovalGroupMall(String approvalGroupMall) {
        this.approvalGroupMall = approvalGroupMall;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WorkflowCombinationStrategyItemPO{");
        sb.append("combinationItemUid='").append(combinationItemUid).append('\'');
        sb.append(", combinationUid='").append(combinationUid).append('\'');
        sb.append(", approvalGroupType='").append(approvalGroupType).append('\'');
        sb.append(", approvalGroup='").append(approvalGroup).append('\'');
        sb.append(", approvalGroupName='").append(approvalGroupName).append('\'');
        sb.append(", approvalGroupMall='").append(approvalGroupMall).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
