package cww.world.controller.workflow;

import cww.world.common.Enum.workflow.WorkflowKeyEnum;
import cww.world.controller.BaseController;
import cww.world.pojo.dto.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xujun
 */
@Controller
@RequestMapping("workflow")
public class WorkflowController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(WorkflowController.class);

    @GetMapping("/layout/index.html")
    public String index(Model model) {
        return "workflow/index";
    }

    @GetMapping("/add.html")
    public String newWorkflow(Model model) {
        List<NameValuePair> workflowList = getWorkflowList();
        model.addAttribute("workflow_List", workflowList);
        return "workflow/add";
    }
    @GetMapping("/{workflowUid:[\\d]+}/view.html")
    public String viewPage(Model model, @PathVariable String workflowUid) {
//        WorkflowPO workflow = workflowService.getWorkflowByWorkflowUid(workflowUid);
//        model.addAttribute("workflow", workflow);
        return "workflow/view";
    }

    @GetMapping("/{workflowUid:[\\d]+}/edit.html")
    public String editPage(Model model, @PathVariable String workflowUid) {
//        WorkflowPO workflow = workflowService.getWorkflowByWorkflowUid(workflowUid);
//        List<NameValuePair> workflowList = getWorkflowList();
//        model.addAttribute("workflow_List", workflowList);
//        model.addAttribute("workflow", workflow);
        return "workflow/edit";
    }





    private List<NameValuePair> getWorkflowList() {
        List<NameValuePair> workflowList = new ArrayList<>(WorkflowKeyEnum.values().length);
        for (WorkflowKeyEnum workflow : WorkflowKeyEnum.values()) {
            NameValuePair param = new NameValuePair();
            param.setName(workflow.name());
            param.setValue(workflow.getDesc());
            workflowList.add(param);
        }
        return workflowList;
    }

}
