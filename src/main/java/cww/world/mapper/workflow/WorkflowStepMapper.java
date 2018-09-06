package cww.world.mapper.workflow;

import cww.world.pojo.po.workflow.WorkflowStepPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkflowStepMapper {

    List<WorkflowStepPO> listWorkflowSteps(String workflowUid);

    Integer insertWorkflowStep(WorkflowStepPO workflowStepPO);

    void batchInsertWorkflowStep(@Param("workflowStepPOs") List<WorkflowStepPO> workflowStepPOs);

    Integer updateWorkflowStep(WorkflowStepPO workflowStepPO);

    Integer deleteWorkflowSteps(@Param("workflowUid") String workflowUid);

    Integer deleteWorkflowStep(@Param("stepUid") String stepUid);

    WorkflowStepPO getWorkflowStepByUid(@Param("workflowStepUid") String workflowStepUid);
}
