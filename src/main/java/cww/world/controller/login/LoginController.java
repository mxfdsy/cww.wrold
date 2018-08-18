package cww.world.controller.login;

import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.exception.BaseException;
import cww.world.common.validate.EntityValidator;
import cww.world.common.validate.ValidateResult;
import cww.world.common.validate.group.Insert;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 小武 on 2018/8/16.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/check")
    @ResponseBody
    public String check(@RequestBody String payload, HttpServletRequest request) {
        UserPO loginUser = JSONObject.parseObject(payload, UserPO.class);
        ValidateResult validateResult = EntityValidator.validate(request, Insert.class);
        if (validateResult.hasError()) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT,validateResult.getErrorMessages());
        }
        return  userService.login(loginUser, request);
    }
}
