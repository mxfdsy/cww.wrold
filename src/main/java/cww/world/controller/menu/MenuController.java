package cww.world.controller.menu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.controller.BaseController;
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


    @RequestMapping(value = "/menu/insertModule", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertModule(@RequestBody String payload){
        logger.info("创建模块，入参：{}", payload);
        MenuDTO menuDTO = JSONObject.parseObject(payload, MenuDTO.class);
        if (StringUtils.isBlank(menuDTO.getName())) {
            return ResultBuilderUtils.buildError(BaseCode.INVALID_ARGUMENT, "缺少模块名称");
        }

//        menuDTO.setCreatedBy(SessionGetter.getLoginUserUid());

        return buildSuccessOrErrorResultByBaseCode(menuService.insertModule(menuDTO));
    }


    private String buildSuccessOrErrorResultByBaseCode(BaseCode baseCode) {
        if (BaseCode.SUCESS.equals(baseCode)) {
            return ResultBuilderUtils.buildSuccess(Constants.SUCCESS);
        } else {
            return ResultBuilderUtils.buildError(baseCode);
        }
    }
    
}
