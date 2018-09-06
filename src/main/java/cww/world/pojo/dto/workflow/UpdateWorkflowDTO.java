package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import cww.world.common.validate.group.Update;
import cww.world.pojo.po.workflow.WorkflowStepPO;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

/**
 * 更新workflowDTO
 *
 * @author greatwall
 */
public class UpdateWorkflowDTO extends BaseDTO {
    @NotBlank(message = "workflow_uid不能为空", groups = {Update.class})
    @JSONField(name = "workflow_uid")
    private String workflowUid;

    @NotBlank(message = "workflow_key不能为空", groups = {Insert.class})
    @JSONField(name = "workflow_key")
    private String workflowKey;

    @NotBlank(message = "workflow_name不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "workflow_name")
    private String workflowName;

    @NotBlank(message = "workflow_desc不能为空", groups = {Insert.class, Update.class})
    @JSONField(name = "workflow_desc")
    private String workflowDesc;

    @JSONField(name = "workflow_step")
    @NotEmpty(message = "workflow_step不能为空", groups = {Insert.class, Update.class})
    @Valid
    private List<WorkflowStepPO> workflowStepPOs;

    public String getWorkflowUid() {
        return workflowUid;
    }

    public void setWorkflowUid(String workflowUid) {
        this.workflowUid = workflowUid;
    }

    public String getWorkflowKey() {
        return workflowKey;
    }

    public void setWorkflowKey(String workflowKey) {
        this.workflowKey = workflowKey;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getWorkflowDesc() {
        return workflowDesc;
    }

    public void setWorkflowDesc(String workflowDesc) {
        this.workflowDesc = workflowDesc;
    }

    public List<WorkflowStepPO> getWorkflowStepPOs() {
        return workflowStepPOs;
    }

    public void setWorkflowStepPOs(List<WorkflowStepPO> workflowStepPOs) {
        this.workflowStepPOs = workflowStepPOs;
    }
}
