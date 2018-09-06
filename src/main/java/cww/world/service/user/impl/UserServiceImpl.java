package cww.world.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.exception.BaseException;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.mapper.user.UserPOMapper;
import cww.world.pojo.dto.PageableRequestDTO;
import cww.world.pojo.dto.user.*;
import cww.world.pojo.po.account.UserAccountPO;
import cww.world.pojo.po.user.UserPO;
import cww.world.pojo.vo.MenuVO;
import cww.world.service.account.UserRoleService;
import cww.world.service.menu.MenuService;
import cww.world.service.menu.RolePermissionService;
import cww.world.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 小武 on 2018/8/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserPOMapper userPOMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private MenuService menuService;


    @Override
    public List<UserPO> userList(ListUserDTO listUserDTO) {
        return userPOMapper.listUserInfo(listUserDTO);
    }

    @Override
    public String login(UserPO loginUserRequest, HttpServletRequest request) {


        LoginUserDTO loginUser = getLoginUserInfo(loginUserRequest.getLoginName(), loginUserRequest);

        List<MenuVO> menu = menuService.listMenuByPermissionKeys(loginUser.getPermissionInfo());
        if (CollectionUtils.isEmpty(menu)) {
            throw new BaseException(BaseCode.MENU_DO_NOT_EXIST, "用户没有菜单");
        }

        Map<String, MenuVO> childrenMenuMap = menu.stream().filter(ele -> ele.getLayer() == 2).collect(Collectors.toMap(MenuVO::getSkipUrl, Function.identity()));

        Map<Integer, MenuVO> parentMenuMap = menu.stream().filter(ele -> ele.getLayer() == 1).collect(Collectors.toMap(MenuVO::getId, Function.identity()));

//        List<SimpleMallDTO> userMallList = businessProgramService.listSimpleMallByUserUid(loginUser.getUserUid());
//        if (!CollectionUtils.isEmpty(userMallList)) {
//            userMallList.sort(Comparator.comparing(SimpleMallDTO::getMallUid));
//        }
        HttpSession session = request.getSession();

        session.setAttribute(Constants.MENU, menu);
        session.setAttribute(Constants.CHILDREN_MENU_MAP, childrenMenuMap);
        session.setAttribute(Constants.PARENT_MENU_MAP, parentMenuMap);
        session.setAttribute(Constants.USER_INFO, loginUser);
        session.setAttribute(Constants.USER_UID, loginUser.getUserUid());



        JSONObject res = new JSONObject();
        String lastRedirectUrl = (String) session.getAttribute(Constants.REDIRECT_URL);
        if (StringUtils.isNotBlank(lastRedirectUrl)) {
            res.put(Constants.LAST_REDIRECT_URL, lastRedirectUrl);
            session.setAttribute(Constants.REDIRECT_URL, null);
        }

        return ResultBuilderUtils.buildSuccess(loginUser);
    }

    @Override
    public UserInfoResponseDTO getUserInfoByUserUid(String userUid) {
        UserPO responsePO = userPOMapper.getUserInfoByUid(userUid);
        if (null == responsePO) {
            throw new BaseException(BaseCode.INTERNAL_ERROR, "用户不存在");
        }
        UserInfoResponseDTO responseDTO = new UserInfoResponseDTO();
        BeanUtils.copyProperties(responsePO, responseDTO);
        return responseDTO;
    }

    @Override
    public String createUser(UserPO userPO) {
        int count = userPOMapper.countUserPhone(userPO.getPhone());
        if (count != 0) {
            throw new BaseException(BaseCode.DATE_ERROR, "该手机已经存在,请核实");
        }
        int effRows = userPOMapper.insertUserInfo(userPO);
        if (effRows <= 0) {
            throw new BaseException(BaseCode.DATE_ERROR);
        }
        return userPO.getId();
    }

    @Override
    public int updateUserStatus(UpdateUserStatusRequestDTO requestDTO) {
        List<String> requestUids = requestDTO.getUserUids();
        List<String> existingUids = getExistingUid();

        ArrayList<String> normalUids = gengerUpdateInfo(requestDTO, requestUids, existingUids);

        userPOMapper.updateUserStatus(requestDTO);
        return normalUids.size();
    }

    @Override
    public void batchInsertUserInfo(List<UserPO> userPOS) {
        userPOMapper.batchInsertUserInfo(userPOS);
    }

    private List<String> getExistingUid() {
        List<UserPO> existingUserInfos = userPOMapper.getAllUserInfo();
        return existingUserInfos.stream().map(UserPO::getUserUid).collect(Collectors.toList());
    }



    @Override
    public void updateUserinfo(UserPO userPO) {
        userPOMapper.updateUserinfo(userPO);
    }


    private ArrayList<String> gengerUpdateInfo(UpdateUserStatusRequestDTO requestDTO, List<String> requestUids, List<String> existingUids) {
        ArrayList<String> normalUids = new ArrayList<>();
        ArrayList<String> exceptionUids = new ArrayList<>();
        requestUids.forEach(item -> {
                    if (existingUids.contains(item)) {
                        normalUids.add(item);
                    } else {
                        exceptionUids.add(item);
                    }
                }
        );
        //正常继续
        if (CollectionUtils.isEmpty(normalUids)) {
            throw new BaseException(BaseCode.DATE_ERROR);
        }
        requestDTO.setUserUids(normalUids);

        //TODO 对于异常的数据发送消息记录
        return normalUids;
    }


    private LoginUserDTO getLoginUserInfo(String loginNam,UserPO loginUser) {
        UserPO userAccountInfo = userPOMapper.getUserInfoByLoginName(loginNam);

        if (userAccountInfo == null) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, "您还未注册哦，请先注册");
        }

        if (!userAccountInfo.getPassword().equals(loginUser.getPassword())) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, "密码输错了哦,请重新输入");
        }

        List<LoginRoleDTO> userRoleInfo = userRoleService.listUserRoleInfo(userAccountInfo.getUserUid());

        LoginUserDTO userInfo = new LoginUserDTO();
        userInfo.setUserUid(userAccountInfo.getUserUid());
        userInfo.setName(userAccountInfo.getUserName());
        userInfo.setLoginName(userAccountInfo.getLoginName());
        userInfo.setPhone(userAccountInfo.getPhone());
        userInfo.setIdentity(userAccountInfo.getIdentity());

        userInfo.setRoleInfo(userRoleInfo);
        userInfo.setPermissionInfo(
                rolePermissionService.listUserRolePermissionKey(
                        userRoleInfo.stream().map(LoginRoleDTO::getRoleUid).collect(Collectors.toList())));
//
//        String mallUserUid = mallErpUserRelationService.getMallUserUidByERPUserUid(userInfo.getUserUid());
//
//        if (StringUtils.isBlank(mallUserUid)) {
//            return userInfo;
//        }
//
//        userInfo.setMallUserUid(mallUserUid);
//
//        VendorInfoDTO vendorInfoDTO = vendorService.getVendorInfoByUserUid(mallUserUid);
//
//        if (null != vendorInfoDTO) {
//            userInfo.setMallVendorUid(vendorInfoDTO.getVendorUid());
//        }
//
//        ErpVendorPO erpVendorInfoDTO = erpVendorService.getErpVendorInfoByUserUid(userAccountInfo.getUserUid());
//
//        if (null != erpVendorInfoDTO) {
//            userInfo.setErpVendorUid(erpVendorInfoDTO.getErpVendorUid());
//        }
        return userInfo;
    }
}
