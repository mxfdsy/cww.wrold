package cww.world.common.Enum.workflow;

/**
 * 审核流程中的业务类型
 *
 * @author xujun
 */

public enum BusinessType {
    /**
     * 品牌
     */
    TYP_BRAND("品牌入库申请"),
    /**
     * 人员进场
     */
    TYP_ASSISTANT_ENTRY("人员进场申请"),
    /**
     * 人员离场
     */
    TYP_ASSISTANT_LEAVE_OFFICE("人员离场申请"),
    /**
     * 正式合同中止
     */
    TYP_FORMAL_CONTRACT_SUSPEND("正式合同中止"),
    /**
     * 正式合同初审
     */
    TYP_FORMAL_CONTRACT_ADD("正式合同初审"),
    /**
     * 正式合同复审
     */
    TYP_FORMAL_CONTRACT_EFFECTIVE("正式合同复审"),
    /**
     * 预租合同审核
     */
    TYP_INFORMAL_CONTRACT_EFFECTIVE("预租合同审核");

    /**
     * 描述
     */
    private String desc;

    public String getDesc() {
        return desc;
    }

    BusinessType(String desc) {
        this.desc = desc;
    }
}
