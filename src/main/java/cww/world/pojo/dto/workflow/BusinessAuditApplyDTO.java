package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.Enum.workflow.BusinessType;
import cww.world.common.Enum.workflow.WorkflowKeyEnum;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xujun
 */
public class BusinessAuditApplyDTO {
    @NotNull(message = "workflowKey不能为空")
    @JSONField(name = "workflow_key")
    private WorkflowKeyEnum workflowKey;
    @JSONField(name = "business_uid")
    private String businessUid;
    @JSONField(name = "business_name")
    private String businessName;
    @NotNull(message = "businessType不能为空")
    @JSONField(name = "business_type")
    private BusinessType businessType;
    @JSONField(name = "business_data")
    private String businessData;
    @JSONField(name = "apply_user_uid")
    private String applyUserUid;
    @JSONField(name = "mall_uid")
    private String mallUid;

    @JSONField(name = "next_auditor_list")
    private List<String> nextAuditorList;

    public WorkflowKeyEnum getWorkflowKey() {
        return workflowKey;
    }

    public void setWorkflowKey(WorkflowKeyEnum workflowKey) {
        this.workflowKey = workflowKey;
    }

    public String getBusinessUid() {
        return businessUid;
    }

    public void setBusinessUid(String businessUid) {
        this.businessUid = businessUid;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getBusinessData() {
        return businessData;
    }

    public void setBusinessData(String businessData) {
        this.businessData = businessData;
    }

    public String getApplyUserUid() {
        return applyUserUid;
    }

    public void setApplyUserUid(String applyUserUid) {
        this.applyUserUid = applyUserUid;
    }

    public String getMallUid() {
        return mallUid;
    }

    public void setMallUid(String mallUid) {
        this.mallUid = mallUid;
    }

    public List<String> getNextAuditorList() {
        return nextAuditorList;
    }

    public void setNextAuditorList(List<String> nextAuditorList) {
        this.nextAuditorList = nextAuditorList;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
