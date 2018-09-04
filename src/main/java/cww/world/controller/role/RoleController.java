package cww.world.controller.role;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.exception.BaseException;
import cww.world.common.interceptor.annotation.HasPermission;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.common.validate.EntityValidator;
import cww.world.common.validate.ValidateResult;
import cww.world.common.validate.group.Delete;
import cww.world.common.validate.group.Insert;
import cww.world.controller.BaseController;
import cww.world.pojo.dto.menu.ListMenuRequestDTO;
import cww.world.pojo.dto.role.DeleteRoleRequestDTO;
import cww.world.pojo.dto.role.EditRoleRequestDTO;
import cww.world.pojo.dto.role.ListGroupRoleRequestDTO;
import cww.world.pojo.dto.role.UserRoleRequestDTO;
import cww.world.pojo.po.role.RolePO;
import cww.world.service.menu.MenuService;
import cww.world.service.role.RoleService;
import cww.world.service.account.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 小武 on 2018/9/3.
 */
@Controller
@RequestMapping("/role")
public class RoleController  extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String createMenu(HttpServletRequest request, Model model) {
//        List<MenuDTO> menuDTOS = menuService.listAllParentMenus();
//        model.addAttribute("parentMenus", menuDTOS);
        return "role/list";
    }

    @RequestMapping(value = "/create.html", method = RequestMethod.GET)
    public String addRole(Model model) {
        return "role/create";
    }

    @RequestMapping(value = "/layout/management", method = RequestMethod.GET)
    public String managementRolePermission(HttpServletRequest request) {
        return "role/list";
    }

    @RequestMapping(value = "/edit/{roleUid:[\\d]+}.html", method =  RequestMethod.GET)
    public String editRole(@PathVariable String roleUid, Model model) {
        generateRoleModel(roleUid, model);
        return  "role/edit";
    }

    @RequestMapping(value = "/view/{roleUid:[\\d]+}.html", method =  RequestMethod.GET)
    public String viewRole(@PathVariable String roleUid, Model model) {
        generateRoleModel(roleUid, model);
        return  "role/view";
    }

    @RequestMapping(value = "/copy/{roleUid:[\\d]+}.html", method =  RequestMethod.GET)
    public String copyRole(@PathVariable String roleUid, Model model) {
        generateRoleModel(roleUid, model);
        return  "role/copy";
    }


    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = JSON_UTF8)
    public String createRole(@RequestBody String payload) {
        logger.info("创建角色，入参：{}", payload);
        if (StringUtils.isBlank(payload)) {
            logger.error("创建角色请求参数为空");
            return ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT,"请求参数不能为空");
        }
        EditRoleRequestDTO createRole = JSONObject.parseObject(payload,EditRoleRequestDTO.class);
        ValidateResult validateResult = EntityValidator.validate(createRole, Insert.class);
        if (validateResult.hasError()) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, validateResult.getErrorMessages());
        }
        String roleUid = roleService.createRole(createRole);
        String result = ResultBuilderUtils.buildSuccess("角色创建成功");
        //发送操作记录
//        asyncInsertUserOperationTrace(roleUid, "TYP_ROLE", "创建角色", "EditRoleRequestDTO", result, payload);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST, produces = JSON_UTF8)
    @HasPermission
    public String getList(@RequestBody String payload) {
        if (StringUtils.isEmpty(payload)) {
            logger.error("查询角色列表请求参数为空");
            ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT, "请求参数不能为空");
        }
        // 解析参数
        ListGroupRoleRequestDTO request = JSON.parseObject(payload, ListGroupRoleRequestDTO.class);


        String result = ResultBuilderUtils.buildSuccess(roleService.listRole(request));
//        asyncInsertUserOperationTrace("", "TYP_ROLE", "查询角色列表", "ListGroupRoleRequestDTO", result, payload);
        return result;
    }


    @RequestMapping(value = "/deleteUserRole", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUserRole(@RequestBody String payload){
        logger.info("开始删除用户角色，入参为{}", payload);
        if (StringUtils.isEmpty(payload)) {
            logger.error("删除用户角色请求参数为空");
            return ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT, "删除用户角色请求参数为空");
        }
        UserRoleRequestDTO userRoleRequest
                = JSONObject.parseObject(payload,UserRoleRequestDTO.class);
        ValidateResult validateResult = EntityValidator.validate(userRoleRequest, Delete.class);
        if(validateResult.hasError()){
            logger.info("删除用户角色，请求参数错误 :{}", validateResult.getErrorMessages());
            return ResultBuilderUtils.buildError(validateResult.getErrorMessages());
        }
        userRoleService.deleteByUids(userRoleRequest);
        String result = ResultBuilderUtils.buildSuccess(Constants.SUCCESS);
//        asyncInsertUserOperationTrace(userRoleRequest.getRoleUid(), "TYP_ROLE", "删除用户角色", "UserRoleRequestDTO", result, payload);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method =  RequestMethod.POST, produces = JSON_UTF8)
    public String deleteRole(@RequestBody String payload) {
        logger.info("删除角色入参为{}",payload);
        if (StringUtils.isEmpty(payload)) {
            logger.error("删除角色请求参数为空");
            return ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT, "删除角色请求参数为空");
        }
        DeleteRoleRequestDTO request = JSONObject.parseObject((payload), DeleteRoleRequestDTO.class);
        if (StringUtils.isEmpty(request.getRoleUid()) && StringUtils.isEmpty(request.getRoleKey())) {
            logger.error("删除角色缺少角色UID或KEY，请求参数:{}", payload);
            return ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT, "请求参数缺少角色UID或KEY");
        }
        roleService.deleteRole(request);
        String result = ResultBuilderUtils.buildSuccess("success");
//        asyncInsertUserOperationTrace(request.getRoleUid(), "TYP_ROLE", "删除角色", "DeleteRoleRequestDTO", result, payload);
        return result;
    }


    private void generateRoleModel(@PathVariable String roleUid, Model model) {
        RolePO rolePO = roleService.getRoleInfoByRoleUid(roleUid);
        if (null == rolePO) {
            throw new BaseException(BaseCode.ROLE_IS_NOT_EXIST_ERROR);
        }
        ListMenuRequestDTO requestDTO = new ListMenuRequestDTO();
        requestDTO.setRoleUid(roleUid);
        model.addAttribute("roleInfo", rolePO);
        model.addAttribute("menuPermission", menuService.listModuleMenu(requestDTO));
    }

}
