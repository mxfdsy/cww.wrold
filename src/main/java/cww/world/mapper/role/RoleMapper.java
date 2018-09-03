package cww.world.mapper.role;


import cww.world.pojo.dto.role.CreateRoleDTO;
import cww.world.pojo.dto.role.ListGroupRoleRequestDTO;
import cww.world.pojo.po.role.RolePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    List<RolePO> listRole(ListGroupRoleRequestDTO listRequest);

    List<RolePO> listAllRole();

    Integer countRole(ListGroupRoleRequestDTO listRequest);

    RolePO getRoleInfoByRoleKey(@Param("roleKey") String roleKey);

    int insert(CreateRoleDTO createRole);

    int syncInsert(CreateRoleDTO createRole);

    RolePO queryRoleByUidOrKey(@Param("roleUid") String roleUid, @Param("roleKey") String roleKey);

    int deleteRoleByRoleUid(@Param("roleUid") String roleUid);

    RolePO getRoleInfoByRoleUid(@Param("roleUid") String roleUid);

    int updateRole(CreateRoleDTO createRole);

    Integer countByRoleName(@Param("roleName") String roleName);

    Integer countRoleByNameWithoutSelf(@Param("roleName") String roleName, @Param("roleUid") String roleUid);

    int SyncUpdateRole(CreateRoleDTO createRole);

    void updateGwCode(@Param("roleName") String roleName, @Param("roleKey") String roleKey);

    RolePO getRoleInfoByRoleName(@Param("roleName") String roleName);

    RolePO syncGetRoleInfoByRoleKey(@Param("roleKey") String roleKey);
}
