package cww.world.controller.workflow;

import com.alibaba.fastjson.JSONObject;
import cww.world.common.Enum.workflow.WorkflowKeyEnum;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.exception.BaseException;
import cww.world.common.util.FastJsonUtils;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.common.util.SessionGetter;
import cww.world.common.validate.EntityValidator;
import cww.world.common.validate.ValidateResult;
import cww.world.common.validate.group.Insert;
import cww.world.controller.BaseController;
import cww.world.pojo.dto.GridPage;
import cww.world.pojo.dto.NameValuePair;
import cww.world.pojo.dto.workflow.SearchWorkflowDTO;
import cww.world.pojo.dto.workflow.UpdateWorkflowDTO;
import cww.world.pojo.po.workflow.WorkflowPO;
import cww.world.service.workflow.WorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private WorkflowService workflowService;

    @GetMapping("/layout/index.html")//@RequestMapping(value=”/layout/index.html”,method= RequestMethod.GET)
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

    @PostMapping(value = "/add", produces = JSON_UTF8)
    @ResponseBody
    public String addWorkflow(@RequestBody String payload) {
        logger.warn("addWorkflow  :: {}", payload);
        UpdateWorkflowDTO addWorkflow = JSONObject.parseObject(payload,UpdateWorkflowDTO.class);
        ValidateResult checkResult = EntityValidator.validate(addWorkflow, Insert.class);
        if (checkResult.hasError()) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, checkResult.getErrorMessages());
        }
        addWorkflow.setCreatedBy(SessionGetter.getLoginUserUid());
        workflowService.addWorkflow(addWorkflow);
        return ResultBuilderUtils.buildSuccess(Constants.SUCCESS);
    }

    @PostMapping(value = "/list", produces = JSON_UTF8)
    @ResponseBody
    public String listWorkflow(@RequestBody String payload) {
        logger.warn("listWorkflow  :: {}", payload);
        SearchWorkflowDTO searchWorkflowDTO = FastJsonUtils.toBean(payload, SearchWorkflowDTO.class);
        GridPage<WorkflowPO> result = workflowService.listWorkflowPageable(searchWorkflowDTO);
        return ResultBuilderUtils.buildSuccess(result);
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
