package cww.world.service.workflow;

import cww.world.pojo.dto.GridPage;
import cww.world.pojo.dto.workflow.SearchWorkflowDTO;
import cww.world.pojo.dto.workflow.UpdateWorkflowDTO;
import cww.world.pojo.po.workflow.WorkflowPO;

import java.util.List;

/**
 * 工作流service
 */
public interface WorkflowService {

    GridPage<WorkflowPO> listWorkflowPageable(SearchWorkflowDTO searchWorkflowDTO);

    void addWorkflow(UpdateWorkflowDTO addWorkflowDTO);

    /**
     * 变更工作流程
     * 注意：当 isNeedUpdateBusinessAudit(UpdateWorkflowDTO updateWorkflowDTO) 判断是true 时，
     * 会把当前进行中的工作流全部取消，并重新申请审核
     *
     * @param updateWorkflowDTO
     */
//    void updatedWorkflow(UpdateWorkflowDTO updateWorkflowDTO);

//    WorkflowPO getWorkflowByWorkflowKey(String workflowKey);

    /**
     * 当工作流没有被使用时删除审核工作流
     *
     * @param workflowUid
     */
//    void deleteWorkflow(String workflowUid);
}
