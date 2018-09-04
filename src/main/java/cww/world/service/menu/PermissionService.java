package cww.world.service.menu;


import cww.world.common.constant.BaseCode;
import cww.world.pojo.dto.menu.ChangeParentMenuRequestDTO;
import cww.world.pojo.po.menu.PermissionPO;

import java.util.List;
import java.util.Set;

public interface PermissionService {

    List<PermissionPO> listPermissionByPermissionKeys(Set<String> permissionKeys);

    List<PermissionPO> listPermissionByParentMenuIds(List<Integer> moduleids);

    int insertPermission(PermissionPO permission);
//
//    boolean isPermissionExist(String permissionKey);
//
//    List<String> listPermissionKeysByMenuId(String menuId);
//
//    BaseCode deletePermissionAndRelatedByUid(String permissionUid, String updatedBy);
//
//    int batchDeltePermissionByUids(List<String> permissionUids);
//
//    List<PermissionPO> getPermissionByPermissionKeys(List<String> permissionKeys);
//
    PermissionPO getPermissionByPermissionKey(String permissionKey);
//
//    void updatePermissionParentMenuId(ChangeParentMenuRequestDTO changeParentMenuRequestDTO);
}
