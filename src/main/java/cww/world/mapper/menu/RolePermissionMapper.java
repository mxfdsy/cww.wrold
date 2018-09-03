package cww.world.mapper.menu;


import cww.world.pojo.po.role.RolePermissionPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RolePermissionMapper {

    Set<String> listUserRolePermissionKey(@Param("roleUids") List<String> roleUids);

    List<String> listPermissionUidsByRoleId(@Param("roleUid") String roleUid);

//    List<RolePermissionInfoDTO> listRolePermissionByRoleId(@Param("roleUid") String roleUid);

    int deleteByRoleUid(@Param("roleUid") String roleUid);

    int batchInsert(List<RolePermissionPO> permissionPOList);

    int deleteRolePermissionByRoleUid(@Param("roleUid") String roleUid);

    int batchDeleteRolePermissionByPermissionUids(@Param("permissionUids") List<String> permissionUids);

    List<String> listRoleUidByPermissionUids(@Param("permissionUids") List<String> permissionUids);
}
