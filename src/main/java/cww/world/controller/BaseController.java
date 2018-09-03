package cww.world.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

public abstract class BaseController {

    protected static final String JSON_UTF8 = "application/json;charset=UTF-8";
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

//    @Value("${api.gateway.rootAddr}")
//    protected String outerApiGatewayUrlSuffix;
//
//    @Autowired
//    private SessionRepository<?> sessionRepository;
//
//    @Autowired
//    @Qualifier("user_operation_trace_send_channel")
//    private MessageChannel asyncUserOperationTraceSendChannel;
//
//    @Autowired
//    private PermissionService permissionService;
//
//    @Autowired
//    private RolePermissionService rolePermissionService;
//
//    protected List<SimpleMallDTO> listRoleMall(List<String> permissionKeys){
//        List<SimpleMallDTO> simpleMallDTOS = SessionGetter.getUserRoleMallList();
//        if (org.springframework.util.CollectionUtils.isEmpty(simpleMallDTOS)) {
//            throw new BaseException(BaseCode.INTERNAL_ERROR, "无任何数据权限");
//        }
//        List<PermissionPO> permissionPOs = permissionService.getPermissionByPermissionKeys(permissionKeys);
//        List<String> permissionUids = permissionPOs.stream().map(PermissionPO::getPermissionUid).collect(Collectors.toList());
//        List<String> roleUids = rolePermissionService.listRoleUidByPermissionUids(permissionUids);
//        if (CollectionUtils.isEmpty(roleUids)){
//            return Collections.emptyList();
//        }
//        List<SimpleMallDTO> resultSimpleMallDTO = simpleMallDTOS.stream().filter(ele -> roleUids.contains(ele.getRoleUid())).collect(Collectors.toList());
//        if (org.springframework.util.CollectionUtils.isEmpty(resultSimpleMallDTO)) {
//            throw new BaseException(BaseCode.INTERNAL_ERROR, "无任何数据权限");
//        }
//        return  resultSimpleMallDTO;
//    }
//
//    protected void clearSession(HttpServletRequest request){
//        String sessionId = request.getSession().getId();
//        request.getSession().invalidate();
//        sessionRepository.delete(sessionId);
//    }
//
//    protected void asyncInsertUserOperationTrace(String businessUid, String businessType, String description,String clazz,String result,String payload) {
//        UserOperationTracePO userOperationTracePO = new UserOperationTracePO(businessUid, businessType, description, clazz, result, payload);
//        userOperationTracePO.setOperationTraceUid((String) RedisUtil.get(String.valueOf(Thread.currentThread().getId())));
//        setOperatorUserInfo(userOperationTracePO);
//        userOperationTracePO.setArchive(1);
//        userOperationTracePO.setOperationTime(Calendar.getInstance().getTime());
//        logger.info("发送记录用户行为数据:{}", JSON.toJSONString(userOperationTracePO));
//        asyncUserOperationTraceSendChannel.send(MessageBuilder.withPayload(JSON.toJSONString(userOperationTracePO)).build());
//    }
//
//    private void setOperatorUserInfo(UserOperationTracePO userOperationTracePO) {
//        try {
//            LoginUserDTO user = SessionGetter.getUser();
//            if (null != user) {
//                userOperationTracePO.setOperatorUserUid(Long.valueOf(user.getUserUid()));
//                userOperationTracePO.setOperatorPhone(user.getPhone());
//                userOperationTracePO.setOperatorName(user.getName());
//            }
//        }catch (Exception e) {
//            userOperationTracePO.setOperatorName("No login user");
//            userOperationTracePO.setArchive(-1);
//            e.printStackTrace();
//        }
//    }
//
//    public JSONArray sortJsonArray(JSONArray array, String key) {
//        if (CollectionUtils.isEmpty(array)) {
//            return new JSONArray();
//        }
//        List<String> duplicateMallUids = new ArrayList<>();
//
//        List<JSONObject> lists = array.toJavaList(JSONObject.class);
//        List<JSONObject> result = new ArrayList<>();
//        lists.forEach(v -> {
//            if (!duplicateMallUids.contains(v.getString(key))) {
//                result.add(v);
//                duplicateMallUids.add(v.getString(key));
//            }
//        });
//
//        if (result.size() > 0) {
//            result.sort(Comparator.comparing(o -> o.getString(key)));
//        }
//        return JSONArray.parseArray(result.toString());
//    }
//
//    /**
//     *
//     * @param skipUrl 二级目录的跳转链接
//     * @return
//     */
//    public void getNavigationInfo(String skipUrl, Model model, Integer pageLayer){
//        MenuNavigationDTO navigationDTO = new MenuNavigationDTO();
//        Map<String, MenuVO> childrenMenuMap = SessionGetter.getChildrenMenuMap();
//        if (null == childrenMenuMap){
//            throw new BaseException(BaseCode.MENU_DO_NOT_EXIST, "用户没有菜单");
//        }
//
//        MenuVO childrenMenu = childrenMenuMap.get(skipUrl);
//        navigationDTO.setChildrenMenuName(childrenMenu.getName());
//        navigationDTO.setChildrenMenuUrl(childrenMenu.getSkipUrl());
//
//        Map<Integer, MenuVO> parentMenuMap = SessionGetter.getParentMenuMap();
//        if (null == parentMenuMap){
//            throw new BaseException(BaseCode.MENU_DO_NOT_EXIST, "用户没有菜单");
//        }
//
//        MenuVO parentMenu = parentMenuMap.get(childrenMenu.getParent());
//        navigationDTO.setParentMenuName(parentMenu.getName());
//        navigationDTO.setParentMenuUrl(parentMenu.getSkipUrl());
//        model.addAttribute("navigationInfo", navigationDTO);
//
//        if (null == pageLayer || pageLayer < 3){
//            return;
//        }
//
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
//        HttpSession session = request.getSession();
//        session.setAttribute("menuDTO", childrenMenu);
//    }
//
//    public Date addOneDaySubtractOneSecond(Date date) {
//        Date oneDay = DateUtils.addDays(date, 1);
//        return DateUtils.addSeconds(oneDay, -1);
//    }
}
