package cww.world.service.menu;


import cww.world.pojo.dto.role.EditRoleRequestDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Teo on 2018/5/29.
 */
public interface RolePermissionService {
    List<String> listPermissionUidsByRoleId(String roleId);

    boolean insertRolePermission(String roleUid, EditRoleRequestDTO request);

    int deleteByRoleUid(String roleUid);

    Set<String> listUserRolePermissionKey(List<String> roleUids);
}
