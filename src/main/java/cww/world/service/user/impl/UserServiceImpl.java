package cww.world.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.exception.BaseException;
import cww.world.common.util.ResultBuilderUtils;
import cww.world.mapper.user.UserPOMapper;
import cww.world.pojo.dto.PageableRequestDTO;
import cww.world.pojo.dto.user.ListUserDTO;
import cww.world.pojo.dto.user.UpdateUserStatusRequestDTO;
import cww.world.pojo.dto.user.UserInfoResponseDTO;
import cww.world.pojo.po.user.UserPO;
import cww.world.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小武 on 2018/8/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserPOMapper userPOMapper;

    @Override
    public List<UserPO> userList(ListUserDTO listUserDTO) {
        return userPOMapper.listUserInfo(listUserDTO);
    }

    @Override
    public String login(UserPO loginUserRequest, HttpServletRequest request) {
        UserPO loginUser = userPOMapper.getUserInfoByLoginName(loginUserRequest.getLoginName());
        if (loginUser == null) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, "您还未注册哦，请先注册");
        }

        if (!loginUserRequest.getPassword().equals(loginUser.getPassword())) {
                    throw new BaseException(BaseCode.INVALID_ARGUMENT, "密码输错了哦,请重新输入");
        }

        HttpSession session = request.getSession();

        session.setAttribute(Constants.USER_INFO, loginUser);



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
}
