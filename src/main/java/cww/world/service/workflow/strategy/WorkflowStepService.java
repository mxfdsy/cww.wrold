package cww.world.service.workflow.strategy;

import cww.world.pojo.po.workflow.WorkflowStepPO;

import java.util.List;

public interface WorkflowStepService {
//
    List<WorkflowStepPO> listWorkflowSteps(String workflowUid);
//
//    WorkflowStepPO getWorkflowStepByUid(String workflowStepUid);
//
//    boolean addWorkflowStep(WorkflowStepPO workflowStepPO);
//
//    boolean updateWorkflowStep(WorkflowStepPO workflowStepPO);
//
//    boolean deleteWorkflowStep(WorkflowStepPO workflowStepPO);

    void batchInsertWorkflowStep(List<WorkflowStepPO> workflowStepPOs);

//    boolean deleteWorkflowSteps(String workflowUid);
}
