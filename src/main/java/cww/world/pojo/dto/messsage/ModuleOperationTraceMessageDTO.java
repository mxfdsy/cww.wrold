package cww.world.pojo.dto.messsage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author wyz
 */
public class ModuleOperationTraceMessageDTO {
    @NotNull(message = "原数据不能为空",  groups = { Insert.class })
    @JSONField(name = "old_data")
    private String oldData;

    @NotNull(message = "关联uid不能为空",  groups = { Insert.class })
    @JSONField(name = "operation_trace_uid")
    private String operationTraceUid;

    @NotNull(message = "新数据不能为空",  groups = { Insert.class })
    @JSONField(name = "new_data")
    private String newData;

    @JSONField(name = "handler_service_name")
    private String handlerServiceName;

    @JSONField(name = "operation_type")
    private String operationType;

    @JSONField(name = "operation_user_uid")
    private String operatorUserUid;

    @JSONField(name = "mall_uid")
    private String mallUid;

    @JSONField(name = "program_name")
    private String programName;

    @JSONField(name = "operate_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date operateAt;

    public String getOperationTraceUid() {
        return operationTraceUid;
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

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    public String getHandlerServiceName() {
        return handlerServiceName;
    }

    public void setHandlerServiceName(String handlerServiceName) {
        this.handlerServiceName = handlerServiceName;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperatorUserUid() {
        return operatorUserUid;
    }

    public void setOperatorUserUid(String operatorUserUid) {
        this.operatorUserUid = operatorUserUid;
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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
