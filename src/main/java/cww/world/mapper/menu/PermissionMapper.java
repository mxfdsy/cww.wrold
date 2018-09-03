package cww.world.mapper.menu;


import cww.world.pojo.dto.menu.ChangeParentMenuRequestDTO;
import cww.world.pojo.po.menu.PermissionPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface PermissionMapper {

    List<PermissionPO> listPermissionByPermissionKeys(@Param("permissionKeys") Set<String> permissionKeys);

    List<PermissionPO> listPermissionByParentMenuIds(@Param("moduleids")List<Integer> moduleids);

    int insertPermission(PermissionPO permission);

    Integer countByPermissionKey(@Param("permissionKey") String permissionKey);

    List<String> listPermissionKeysByMenuId(@Param("menuId") String menuId);

    List<PermissionPO> listPermissionByPermissionUids(@Param("permissionUids") List<String> permissionUids);

    int batchDeletePermissionByUids(@Param("permissionUids") List<String> permissionUids);

    List<PermissionPO> getPermissionByPermissionKeys(@Param("permissionKeys") List<String> permissionKeys);

    PermissionPO getPermissionByPermissionKey(@Param("permissionKey") String permissionKey);

    int updatePermissionParentMenuId(ChangeParentMenuRequestDTO changeParentMenuRequestDTO);
}
