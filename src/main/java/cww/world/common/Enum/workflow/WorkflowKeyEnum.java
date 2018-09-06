package cww.world.common.Enum.workflow;

/**
 * @author xujun
 */

public enum WorkflowKeyEnum {
    //    TEST_AUDIT("审核测试"),
    BRAND_AUDIT("品牌审核"),
    ASSISTANT_ENTRY_AUDIT("人员进场审核"),
    ASSISTANT_LEAVE_OFFICE_AUDIT("人员离场审核"),
    FORMAL_CONTRACT_SUSPEND_AUDIT("正式合同中止审核"),
    FORMAL_CONTRACT_ADD("正式合同初审"),
    FORMAL_CONTRACT_EFFECTIVE("正式合同复审"),
    INFORMAL_CONTRACT_APPLY_AUDIT("预租合同审核");

    private String desc;

    WorkflowKeyEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
