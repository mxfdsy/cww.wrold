package cww.world.common.Enum.workflow;

/**
 * 工作流审核状态
 * @author xujun
 */

public enum AuditStatusEnum {

    /**
     * 审核通过
     */
    TYP_APPROVED,
    /**
     * 审核拒绝
     */
    TYP_REJECTED,
    /**
     * 审核撤销
     */
    TYP_CANCEL,
    /**
     * 审核流程作废（一般是在变更workflow时,状态是TYP_PENDING，流程作废处理，重新申请）
     */
    TYP_ABANDONED,
    /**
     * 审核进行中（流程的开始状态）
     */
    TYP_PENDING
}
