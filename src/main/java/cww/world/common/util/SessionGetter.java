package cww.world.common.util;


import cww.world.common.constant.Constants;
import cww.world.pojo.dto.user.LoginUserDTO;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class SessionGetter {

   
    /**
     * 登录用户的
     *
     * @return
     */
    public static String getLoginUserUid() {
        return (String) getObjectValue(Constants.USER_UID);
    }

    /**
     * 登录用户的mallUserUid
     * @return
     */

    public static Object getObjectValue(String key) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(ra)) {
            return Constants.SYSTEM_UID;
        }
        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
        return request.getSession().getAttribute(key);
    }



}