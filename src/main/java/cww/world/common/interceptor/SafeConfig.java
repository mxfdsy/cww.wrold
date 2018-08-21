package cww.world.common.interceptor;

import cww.world.common.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 小武 on 2018/8/21.
 */
@Component
public class SafeConfig extends HandlerInterceptorAdapter {
    private static String[] IGNORE_URI = {"/login.html", "/login/login","/login", "/error"};
    private static Logger log = LoggerFactory.getLogger(SafeConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();

        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            Object obj = request.getSession().getAttribute(Constants.USER_INFO);

            if (null == obj) {
                //未登录
                String servletPath = request.getServletPath();
                log.error("session失效，当前url：" + url+";module Paht:"+servletPath);
                if (request.getHeader("x-requested-with") != null &&
                        request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){

                    //在响应头设置session状态
                    response.setHeader("sessionstatus", "timeout");
                    response.setCharacterEncoding("text/html;charset=utf-8");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().print("error");
                } else {
                    response.sendRedirect(request.getContextPath()+"/login/login");
                }
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
