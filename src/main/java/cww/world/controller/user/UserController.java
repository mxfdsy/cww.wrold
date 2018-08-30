package cww.world.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.Constants;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.pojo.dto.GridPage;
import cww.world.pojo.dto.PageableRequestDTO;
import cww.world.pojo.dto.user.ListUserDTO;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 小武 on 2018/8/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/layout/index.html",method = RequestMethod.GET)
    public String userList() {
        return "user/list2";
    }

    @RequestMapping(value = "/createUser.html")
    public String createUser(Model model){
        return "user/create";
    }


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

    @ResponseBody
    @RequestMapping("/createUser")
    public String createUser(@RequestBody String payload) {
        UserPO userPO = JSON.parseObject(payload, UserPO.class);
        return ResultBuilderUtils.buildSuccess(userService.createUser(userPO));
    }

    @RequestMapping(value = "/updateUser/{userUid:[\\d]+}.html")
    public String goToUpdateUserPage(@PathVariable String userUid, Model model){
        model.addAttribute("userInfo", userService.getUserInfoByUserUid(userUid));
        return "user/edit";
    }
    @ResponseBody
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(@RequestBody String payload) {
        UserPO userPO = JSON.parseObject(payload, UserPO.class);
        userService.updateUserinfo(userPO);
        return ResultBuilderUtils.buildSuccess(Constants.SUCCESS);
    }


}
