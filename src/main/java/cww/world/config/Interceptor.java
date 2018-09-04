package cww.world.config;

import cww.world.common.constant.Constants;
import cww.world.pojo.po.user.UserPO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @author 小武 on 2018/8/22.
 */
@Component
public class Interceptor implements HandlerInterceptor {
    private static final List DEFAULT_URL = Arrays.asList("/login/login","/caches/test");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (isAjaxReq(request)) {
//            return true;
//        }
//
//        String URI = request.getRequestURI();
//        if (DEFAULT_URL.contains(URI)) {
//            return true;
//        }
//
//        HttpSession session = request.getSession();
//        UserPO user = (UserPO) session.getAttribute(Constants.USER_INFO);
//        if (user != null) {
//            return true;
//        }
//        //跳转到的登录页面
//        request.getRequestDispatcher("/login/login").forward(request, response);
//        return false;
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    private boolean isAjaxReq(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
