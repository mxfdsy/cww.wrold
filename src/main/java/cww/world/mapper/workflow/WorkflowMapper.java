package cww.world.mapper.workflow;

import cww.world.pojo.dto.PageableRequestDTO;
import cww.world.pojo.dto.workflow.SearchWorkflowDTO;
import cww.world.pojo.dto.workflow.UpdateWorkflowDTO;
import cww.world.pojo.po.workflow.WorkflowPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkflowMapper {

    Integer countSearchWorkflows(SearchWorkflowDTO searchWorkflowDTO);

    List<WorkflowPO> listSearchWorkflows(PageableRequestDTO pageableRequestDTO);

    Integer addWorkflow(UpdateWorkflowDTO addWorkflowDTO);

    Integer updateWorkflow(UpdateWorkflowDTO updateWorkflowDTO);

    WorkflowPO getByWorkflowUid(@Param("workflowUid") String workflowUid);

    WorkflowPO getByWorkflowKey(@Param("workflowKey") String workflowKey);

    int deleteWorkflowByWorkflowUid(@Param("workflowUid") String workflowUid);
}
