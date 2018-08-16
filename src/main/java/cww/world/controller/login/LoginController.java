package cww.world.controller.login;

import com.alibaba.fastjson.JSONObject;
import cww.world.common.validate.EntityValidator;
import cww.world.common.validate.ValidateResult;
import cww.world.common.validate.group.Insert;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String check(@RequestBody String payload) {
        UserPO request = JSONObject.parseObject(payload, UserPO.class);
        ValidateResult validateResult = EntityValidator.validate(request, Insert.class);
        if (validateResult.hasError()) {
              validateResult.getErrorMessages();
        }
        return "";
    }
}
