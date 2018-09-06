//package cww.world.controller.workflow;
//
//import com.alibaba.fastjson.JSONObject;
//import com.lmfun.common.constant.enumeration.BaseCode;
//import com.lmfun.common.constant.enumeration.workflow.AuditOperationEnum;
//import com.lmfun.common.constant.enumeration.workflow.AuditStatusEnum;
//import com.lmfun.common.exception.BaseException;
//import com.lmfun.common.util.JSON;
//import com.lmfun.common.util.ResultBuilderUtils;
//import com.lmfun.common.util.SessionGetter;
//import com.lmfun.common.util.StringUtils;
//import com.lmfun.common.validate.EntityValidator;
//import com.lmfun.common.validate.ValidateResult;
//import com.lmfun.controller.BaseController;
//import com.lmfun.pojo.dto.GridPage;
//import com.lmfun.pojo.dto.workflow.*;
//import com.lmfun.pojo.po.account.UserAccountPO;
//import com.lmfun.pojo.po.workflow.MyApproveDTO;
//import com.lmfun.service.account.UserAccountService;
//import com.lmfun.service.workflow.BusinessAuditService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Controller
//@RequestMapping("workflow/audit")
//public class WorkflowAuditController extends BaseController {
//    private static final Logger logger = LoggerFactory.getLogger(WorkflowAuditController.class);
//    @Autowired
//    private BusinessAuditService businessAuditService;
//
//    @Autowired
//    private UserAccountService userAccountService;
//
//    @ResponseBody
//    @RequestMapping(value = "/progress", method = RequestMethod.POST, produces = JSON_UTF8)
//    public String auditOperation(@RequestBody String payload) {
//        String currentUserUid = SessionGetter.getLoginUserUid();
//        logger.warn("{}用户进行审核操作，payload = {}", currentUserUid, payload);
//        AuditOperationDTO auditOperationDTO = JSON.toBean(payload, AuditOperationDTO.class);
//        auditOperationDTO.setAuditorUserUid(currentUserUid);
//        ValidateResult validateResult = EntityValidator.validate(auditOperationDTO);
//        if (validateResult.hasError()) {
//            throw new BaseException(BaseCode.INVALID_ARGUMENT, validateResult.getErrorMessages());
//        }
//        UserAccountPO auditor = userAccountService.searchUserAccountByUserUid(auditOperationDTO.getAuditorUserUid());
//        List<AuditOperationItem> progressList = auditOperationDTO.getProgressList();
//        ArrayList<AuditOperationErrorDetailItemDTO> failList = new ArrayList<>(progressList.size());
//        for (AuditOperationItem progress : progressList) {
//            ProgressAuditDTO param = getProgressAuditDTO(auditOperationDTO, auditor, progress);
//            try {
//                businessAuditService.userAuditProgressHandle(param);
//            } catch (Exception e) {
//                logger.error("审核处理错误，param = {}", param, e);
//                if (e instanceof BaseException) {
//                    BaseException be = (BaseException) e;
//                    int errorCode = be.getError().getCode();
//                    String errorMsg = be.getLocalizedMessage();
//                    failList.add(new AuditOperationErrorDetailItemDTO(progress, errorCode, errorMsg));
//                } else {
//                    failList.add(new AuditOperationErrorDetailItemDTO(progress, e.getLocalizedMessage()));
//                }
//            }
//        }
//        AuditOperationResultDTO result = new AuditOperationResultDTO();
//        result.setFailDetails(failList);
//        result.setFail(failList.size());
//        result.setSuccess(progressList.size() - failList.size());
//        return ResultBuilderUtils.buildSuccess(result);
//    }
//
//    private ProgressAuditDTO getProgressAuditDTO(AuditOperationDTO auditOperationDTO, UserAccountPO auditor, AuditOperationItem progress) {
//        ProgressAuditDTO param = new ProgressAuditDTO();
//        param.setAuditProgressUid(progress.getProgressUid());
//        param.setAuditUserUid(auditor.getUserUid());
//        param.setAuditUserName(auditor.getName());
//        param.setAuditUserPhone(auditor.getPhone());
//        if (Objects.equals(auditOperationDTO.getOperation(), AuditOperationEnum.APPROVED)) {
//            param.setAuditStatus(AuditStatusEnum.TYP_APPROVED);
//        }
//        if (Objects.equals(auditOperationDTO.getOperation(), AuditOperationEnum.REJECTED)) {
//            param.setAuditStatus(AuditStatusEnum.TYP_REJECTED);
//        }
//        param.setNextAuditorList(auditOperationDTO.getNextAuditorList());
//        param.setAuditReason(auditOperationDTO.getReason());
//        return param;
//    }
//
//    /**
//     * 我发起的审批
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/applied", method = RequestMethod.POST, produces = JSON_UTF8)
//    public String myApplied(@RequestBody String payload) {
//        BusinessAuditConditionDTO condition = JSON.toBean(payload, BusinessAuditConditionDTO.class);
//        condition.setApplyUserUid(SessionGetter.getLoginUserUid());
//        GridPage<MyApproveDTO> result = businessAuditService.findMyAppliedListByCondition(condition);
//        return ResultBuilderUtils.buildSuccess(result);
//    }
//
//    /**
//     * 我的审批的
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/approve", method = RequestMethod.POST, produces = JSON_UTF8)
//    public String myApprove(@RequestBody String payload) {
//        BusinessAuditConditionDTO condition = JSON.toBean(payload, BusinessAuditConditionDTO.class);
//        condition.setApplyUserUid(SessionGetter.getLoginUserUid());
//        GridPage<MyApproveDTO> result = businessAuditService.findMyApproveListByCondition(condition);
//        return ResultBuilderUtils.buildSuccess(result);
//    }
//
//    /**
//     * 审批的历史记录
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/history", method = RequestMethod.POST, produces = JSON_UTF8)
//    public String auditHistory(@RequestBody String payload) {
//        String auditUid = JSONObject.parseObject(payload).getString("audit_uid");
//        if (StringUtils.isBlank(auditUid)) {
//            throw new BaseException(BaseCode.INVALID_ARGUMENT, "audit_uid不能为空");
//        }
//        BusinessAuditHistoryDTO history = businessAuditService.getBusinessAuditHistoryByAuditUid(auditUid);
//        return ResultBuilderUtils.buildSuccess(history);
//    }
//
//}
