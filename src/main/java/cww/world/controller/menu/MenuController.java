package cww.world.controller.menu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.common.validate.EntityValidator;
import cww.world.common.validate.ValidateResult;
import cww.world.common.validate.group.Insert;
import cww.world.controller.BaseController;
import cww.world.pojo.dto.menu.InsertChildrenMenuDTO;
import cww.world.pojo.dto.menu.ListMenuRequestDTO;
import cww.world.pojo.dto.menu.MenuDTO;
import cww.world.service.menu.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * Created by Teo on 2018/5/30.
 */
@Controller
public class MenuController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    private static final String JSON_KEY_MENU_ID = "menu_id";
    private static final String JSON_KEY_PERMISSION_UID = "permission_uid";
    private static final String JSON_KEY_MENU_IDS = "menu_ids";
    private static final String JSON_KEY_MODULE_IDS = "module_ids";

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/menu/create", method = RequestMethod.GET)
    public String createMenu(HttpServletRequest request, Model model) {
        List<MenuDTO> menuDTOS = menuService.listAllParentMenus();
        model.addAttribute("parentMenus", menuDTOS);
        return "menu/menuCreate";
    }


    @RequestMapping(value = "/menu/insertModule", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertModule(@RequestBody String payload){
        logger.info("创建模块，入参：{}", payload);
        MenuDTO menuDTO = JSONObject.parseObject(payload, MenuDTO.class);
        if (StringUtils.isBlank(menuDTO.getName())) {
            return ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT, "缺少模块名称");
        }
        return buildSuccessOrErrorResultByBaseCode(menuService.insertModule(menuDTO));
    }


    @ResponseBody
    @RequestMapping(value = "/menu/insertChildrenMenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String insertChildrenMenu(@RequestBody String payload){
        logger.info("创建子级菜单，入参：{}", payload);
        InsertChildrenMenuDTO request = JSONObject.parseObject(payload, InsertChildrenMenuDTO.class);
        ValidateResult validateResult = EntityValidator.validate(request, Insert.class);
        if (validateResult.hasError()) {
            return ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT, validateResult.getErrorMessages());
        }

        //校驗權限是否合法
        //校验模块是否存在
        //校验是否已经存在
        return buildSuccessOrErrorResultByBaseCode(menuService.insertChildrenMenu(request));
    }

    @RequestMapping(value = "/menu/listMenu", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String listMenu(@RequestBody  String payload){
        logger.info("获取菜单配置页菜单列表，入参:{}", payload);
        ListMenuRequestDTO requestDTO = JSONObject.parseObject(payload, ListMenuRequestDTO.class);
        return ResultBuilderUtils.buildSuccess(menuService.listModuleMenu(requestDTO));
    }


    private String buildSuccessOrErrorResultByBaseCode(BaseCode baseCode) {
        if (BaseCode.SUCESS.equals(baseCode)) {
            return ResultBuilderUtils.buildSuccess(Constants.SUCCESS);
        } else {
            return ResultBuilderUtils.buildError(baseCode);
        }
    }
    
}
