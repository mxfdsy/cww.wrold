package cww.world.common.exception;

import com.alibaba.fastjson.JSONObject;

import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Optional;

/**
 * 全局异常处理
 *
 * @author xujun
 */
@Component
public class ControllerExceptionHandler implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ResponseBody body = ((HandlerMethod) handler).getMethodAnnotation(ResponseBody.class);
        if (Objects.isNull(body)) {
            String viewName = "error/5xx";
            if (ex instanceof BaseException
                    && Objects.equals(((BaseException) ex).getError(), BaseCode.PERMISSION_IS_NOT_EXIST)) {
                viewName = "error/noPermission";
            }
            ModelAndView mv = new ModelAndView();
            mv.addObject("error", buildErrorParam(ex));
            mv.setViewName(viewName);
            return mv;
        } else {
            response.setContentType("application/json;charset=UTF-8");
            try (PrintWriter writer = response.getWriter();) {
                writer.write(JSONObject.toJSONString(buildErrorParam(ex)));
                writer.flush();
                return new ModelAndView();
            } catch (Exception e) {
                logger.error("错误异常转换", e);
            }
        }
        return null;
    }

    private JSONObject buildErrorParam(Exception ex) {
        BaseException base;
        logger.error("ERP 发生未知异常", ex);
        if (ex instanceof BaseException) {
            base = (BaseException) ex;
        } else {
            base = new BaseException(BaseCode.UNKNOWN);
        }
        JSONObject error = new JSONObject();
        error.put(Constants.CODE_FLAG, base.getError().getCode());
        String errorMsg = Optional.ofNullable(base.getLocalizedMessage()).orElse(base.getError().getMessage());
        error.put(Constants.MESSAGE_FLG, errorMsg);
        error.put(Constants.ERROR_MSG_FLAG, errorMsg);
        return error;
    }

}
