package cww.world.controller.user;

import com.alibaba.fastjson.JSON;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.pojo.dto.GridPage;
import cww.world.pojo.dto.PageableRequestDTO;
import cww.world.pojo.dto.user.ListUserDTO;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 小武 on 2018/8/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list2")
    public String userList2(Model model) throws Exception {
        model.addAttribute("hello","Hello, Spring Boot!");
//        model.addAttribute("userList", userService.userList());
        return "/login/list2";
    }

    @ResponseBody
    @RequestMapping("/getUserList")
    public String getUserList(@RequestBody String payload){
        ListUserDTO listUserDTO = JSON.parseObject(payload, ListUserDTO.class);
        List<UserPO> userPOS = userService.userList(listUserDTO);
        return ResultBuilderUtils.buildSuccess(new GridPage<>(userPOS.size(),userPOS));
    }

    @RequestMapping(value = "/viewUser/{userUid:[\\d]+}.html")
    public String goToViewUserPage(@PathVariable String userUid, Model model){
        //TODO 检验用户是否存在
        model.addAttribute("userInfo", userService.getUserInfoByUserUid(userUid));
        return "user/view";
    }


}
