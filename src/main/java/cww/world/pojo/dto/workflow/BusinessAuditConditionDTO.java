package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.PageableRequestDTO;

public class BusinessAuditConditionDTO extends PageableRequestDTO {
    @JSONField(name = "apply_user_uid")
    private String applyUserUid;
    @JSONField(name = "business_type")
    private String businessType;

    public String getApplyUserUid() {
        return applyUserUid;
    }

    public void setApplyUserUid(String applyUserUid) {
        this.applyUserUid = applyUserUid;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
