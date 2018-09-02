package cww.world.pojo.po.trace;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.BasePO;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author wyz
 */
public class ModuleOperationTracePO extends BasePO {
    @JSONField(name = "trace_uid")
    private String traceUid;
    @JSONField(name = "operation_type")
    private String operationType;

    @JSONField(name = "major_uid")
    private String majorUid;

    @JSONField(name = "column1")
    private String column1;

    @JSONField(name = "column2")
    private String column2;

    @JSONField(name = "column3")
    private String column3;

    @JSONField(name = "operate_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date operateAt;

    @JSONField(name = "operator_organization")
    private String operatorOrganization;

    @JSONField(name = "operation_name")
    private String operatorName;

    @JSONField(name = "operation_phone")
    private String operatorPhone;

    @JSONField(name = "operation_user_uid")
    private String operatorUserUid;

    @JSONField(name = "mall_uid")
    private String mallUid;

    @JSONField(name = "program_name")
    private String programName;

    @JSONField(name = "trace_details")
    private List<ModuleOperationTraceDetailPO> traceDetails;

    @JSONField(name = "operation_trace_uid")
    private String operationTraceUid;

    public String getOperationTraceUid() {
        return StringUtils.isBlank(operationTraceUid) ? null : operationTraceUid;
    }

    public void setOperationTraceUid(String operationTraceUid) {
        this.operationTraceUid = operationTraceUid;
    }

    public Date getOperateAt() {
        return operateAt;
    }

    public void setOperateAt(Date operateAt) {
        this.operateAt = operateAt;
    }

    public String getTraceUid() {
        return traceUid;
    }

    public void setTraceUid(String traceUid) {
        this.traceUid = traceUid;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getMajorUid() {
        return majorUid;
    }

    public void setMajorUid(String majorUid) {
        this.majorUid = majorUid;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getOperatorOrganization() {
        return operatorOrganization;
    }

    public void setOperatorOrganization(String operatorOrganization) {
        this.operatorOrganization = operatorOrganization;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getOperatorUserUid() {
        return operatorUserUid;
    }

    public void setOperatorUserUid(String operatorUserUid) {
        this.operatorUserUid = operatorUserUid;
    }

    public List<ModuleOperationTraceDetailPO> getTraceDetails() {
        return traceDetails;
    }

    public void setTraceDetails(List<ModuleOperationTraceDetailPO> traceDetails) {
        this.traceDetails = traceDetails;
    }

    public String getMallUid() {
        return mallUid;
    }

    public void setMallUid(String mallUid) {
        this.mallUid = mallUid;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
