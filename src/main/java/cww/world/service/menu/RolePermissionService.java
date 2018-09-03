package cww.world.service.menu;


import java.util.List;
import java.util.Set;

/**
 * Created by Teo on 2018/5/29.
 */
public interface RolePermissionService {
    List<String> listPermissionUidsByRoleId(String roleId);
}
