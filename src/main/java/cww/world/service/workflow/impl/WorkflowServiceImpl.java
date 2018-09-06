package cww.world.service.workflow.impl;

import cww.world.mapper.workflow.WorkflowMapper;
import cww.world.pojo.dto.GridPage;
import cww.world.pojo.dto.workflow.SearchWorkflowDTO;
import cww.world.pojo.dto.workflow.UpdateWorkflowDTO;
import cww.world.pojo.po.workflow.WorkflowPO;
import cww.world.pojo.po.workflow.WorkflowStepPO;
import cww.world.service.workflow.WorkflowService;
import cww.world.service.workflow.strategy.WorkflowStepService;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 工作流service实现
 *
 * @author greatwall
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    private WorkflowMapper workflowMapper;

    @Autowired
    private WorkflowStepService workflowStepService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addWorkflow(UpdateWorkflowDTO addWorkflowDTO) {
        workflowMapper.addWorkflow(addWorkflowDTO);
        List<WorkflowStepPO> workflowStepPOList = addWorkflowDTO.getWorkflowStepPOs();
        if (CollectionUtils.isEmpty(workflowStepPOList)) {
            return;
        }
        String workflowUid = addWorkflowDTO.getWorkflowUid();
        workflowStepPOList.forEach(workflowStepPO -> workflowStepPO.setWorkflowUid(workflowUid));
        workflowStepService.batchInsertWorkflowStep(workflowStepPOList);
    }

    @Override
    public GridPage<WorkflowPO> listWorkflowPageable(SearchWorkflowDTO searchWorkflowDTO) {
        int total = workflowMapper.countSearchWorkflows(searchWorkflowDTO);
        if (total < 1) {
            return new GridPage<>(0, Collections.emptyList());
        }
        List<WorkflowPO> workflowList = listWorkflow(searchWorkflowDTO);
        return new GridPage<>(total, workflowList);
    }

    public List<WorkflowPO> listWorkflow(SearchWorkflowDTO pageableRequestDTO) {
        List<WorkflowPO> workflowPOs = workflowMapper.listSearchWorkflows(pageableRequestDTO);
        if (CollectionUtils.isEmpty(workflowPOs)) {
            return Collections.emptyList();
        }
        workflowPOs.forEach(workflowPO -> {
            String workflowUid = workflowPO.getWorkflowUid();
            List<WorkflowStepPO> workflowStepPOs = workflowStepService.listWorkflowSteps(workflowUid);
            workflowPO.setWorkflowStepPOs(workflowStepPOs);
        });
        return workflowPOs;
    }

}
