package cww.world.common.interceptor.annotation;

import java.lang.annotation.*;

/**
 * @author  小武
 * @Date 2018/7/3 11:38
 * @Description
 * 校验当前用户是否有权限访问
 * <pre>
 *  @HasPermission(permissionKeys = "erp_organization_manage,erp_workflow_management")
 * </pre>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasPermission {
    String permissionKeys()  default "";
}
