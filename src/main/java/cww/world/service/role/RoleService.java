package cww.world.service.role;



import cww.world.pojo.dto.GridPage;
import cww.world.pojo.dto.role.DeleteRoleRequestDTO;
import cww.world.pojo.dto.role.EditRoleRequestDTO;
import cww.world.pojo.dto.role.ListGroupRoleRequestDTO;
import cww.world.pojo.po.role.RolePO;

import java.util.List;


public interface RoleService {

    GridPage<RolePO> listRole(ListGroupRoleRequestDTO request);

    String createRole(EditRoleRequestDTO request);

    void deleteRole(DeleteRoleRequestDTO request);
//
    RolePO searchRoleByUidOrKey(String roleUid, String roleKey);
//
//    void updateRole(EditRoleRequestDTO request);
//
    RolePO getRoleInfoByRoleUid(String roleUid);
//
//    String syncCreateRole(EditRoleRequestDTO request);
//
//    void syncUpdateRole(EditRoleRequestDTO request);
//
//    RolePO getRoleInfoByRoleKey(String rolekey);
//
//  List<RolePO> getAllRoleInfo();
}
