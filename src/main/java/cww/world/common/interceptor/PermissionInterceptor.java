package cww.world.common.interceptor;



import cww.world.common.interceptor.annotation.HasPermission;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author  小武
 * @Date 2018/7/3 12:46
 * @Description
 *
 */
@Aspect
@Component
public class PermissionInterceptor {
    @Before( value = "execution(public * *(..)) && @annotation(hasPermission)")
    public void doBefore(HasPermission hasPermission) throws Throwable {
//        throw new BaseException(BaseCode.PERMISSION_IS_NOT_EXIST, "没有操作权限");
    }
}

