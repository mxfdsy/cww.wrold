package cww.world.service.workflow.impl;

import cww.world.mapper.workflow.WorkflowStepMapper;
import cww.world.pojo.po.workflow.WorkflowStepPO;
import cww.world.service.workflow.strategy.WorkflowStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工作量步骤Service实现
 *
 * @author greatwall
 */
@Service
public class WorkflowStepServiceImpl implements WorkflowStepService {
    @Autowired
    private WorkflowStepMapper workflowStepMapper;


    @Override
    public void batchInsertWorkflowStep(List<WorkflowStepPO> workflowStepPOs) {
        workflowStepMapper.batchInsertWorkflowStep(workflowStepPOs);
    }

    @Override
    public List<WorkflowStepPO> listWorkflowSteps(String workflowUid) {
        return workflowStepMapper.listWorkflowSteps(workflowUid);
    }


}
