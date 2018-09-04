package cww.world.service.menu.impl;

import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.common.exception.BaseException;
import cww.world.mapper.menu.MenuMapper;
import cww.world.pojo.dto.menu.*;
import cww.world.pojo.dto.role.EditRoleRequestDTO;
import cww.world.pojo.po.menu.MenuPO;
import cww.world.pojo.po.menu.PermissionPO;
import cww.world.pojo.po.role.RolePO;
import cww.world.pojo.vo.MenuVO;
import cww.world.service.menu.MenuService;
import cww.world.service.menu.PermissionService;
import cww.world.service.menu.RolePermissionService;
import cww.world.service.role.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private PermissionService permissionService;


    @Autowired
    private RolePermissionService rolePermissionService;


    @Autowired
    private RoleService roleService;




    @Override
    @Transactional
    public BaseCode insertModule(MenuDTO menuDTO) {
        //校验一级菜单名称是否存在

        MenuPO menuPO = new MenuPO();
        BeanUtils.copyProperties(menuDTO, menuPO);

        int effectRows = menuMapper.insertMenu(menuPO);
        if(effectRows <= 0){
            return BaseCode.DB_INSERT_ERROR;
        }
        menuMapper.updateMenuSortAndCode(menuPO.getId(), menuPO.getId(), Integer.toString(menuPO.getId()));

        return BaseCode.SUCESS;
    }


    @Override
    @Transactional
    public BaseCode insertChildrenMenu(InsertChildrenMenuDTO request) {
        //设置菜单信息
        MenuPO menu = new MenuPO();
        menu.setName(request.getMenuName());
        menu.setSkipUrl(request.getSkipUrl());
        menu.setLayer(2);
        menu.setParent(Integer.parseInt(request.getModulId()));
        menu.setPermissionKeys(request.getPermissionKey());
        menu.setCreatedBy(request.getOperatorUser());
        menu.setSort(request.getSort());
        //设置菜单对应的权限信息
        PermissionPO permission = new PermissionPO();
        permission.setPermissionKey(request.getPermissionKey());
        permission.setPermissionName(request.getPermissionName());
        permission.setPermissionDesc(request.getPermissionName());
        permission.setPermissionModule(request.getMenuName());
        permission.setParentMenuId(Integer.parseInt(request.getModulId()));
        permission.setCreatedBy(request.getOperatorUser());

        try{
            insertMenuAndPermission(menu, permission);
        }catch(BaseException e){
            logger.error("插入菜单权限失败，错误信息：{}", e.getMessage());
            return e.getError();
        }catch(Exception e){
            logger.error("插入菜单权限失败，错误信息：{}", e.getMessage());
            return BaseCode.DB_INSERT_ERROR;
        }
        //给系统管理员加上相应权限
        addPermissionToRole(Constants.SYSTEM_ADMIN_KEY, permission.getPermissionKey());
        return BaseCode.SUCESS;
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertMenuAndPermission(MenuPO menu, PermissionPO permission) {
        int effectRows = menuMapper.insertMenu(menu);
        if(effectRows <= 0){
            throw new BaseException(BaseCode.DB_INSERT_ERROR, "菜单创建失败");
        }

        if (null == menu.getSort()){
            menu.setSort(menu.getId());
        }

        menuMapper.updateMenuSortAndCode(menu.getId(), menu.getSort(), String.format("%d,%d", menu.getParent(), menu.getId()));

        permission.setMenuId(menu.getId());
        int effectPermissionRows = permissionService.insertPermission(permission);
        if(effectPermissionRows <= 0){
            throw new BaseException(BaseCode.DB_INSERT_ERROR, "菜单创建失败");
        }
    }

    @Override
    public List<ModuleDTO> listModuleMenu(ListMenuRequestDTO requestDTO) {
        //拿出所有的一级菜单
        List<MenuPO> parentMenus = menuMapper.listAllParentMenus();
        if(CollectionUtils.isEmpty(parentMenus)){
            return Collections.emptyList();
        }

        List<Integer> parentMenuIds = parentMenus.stream().map(module -> module.getId()).collect(Collectors.toList());

        Map<Integer, List<MenuPO>> parentMenuIdChidrenMenuMap = mapModuleToMenus(parentMenuIds);
        Map<Integer, List<PermissionPO>> menuIdPermissionMap = mapMenuToPermissions(parentMenuIds);
        List<String> rolePermissionUids = new ArrayList<>();
        if(StringUtils.isNotBlank(requestDTO.getRoleUid())){
            rolePermissionUids = rolePermissionService.listPermissionUidsByRoleId(requestDTO.getRoleUid());
        }

        List<ModuleDTO> moduleDTOs = new ArrayList<>();
        for(MenuPO module : parentMenus){
            ModuleDTO modelDTO = new ModuleDTO();
            modelDTO.setMenuId(module.getId());
            modelDTO.setMenuName(module.getName());
            modelDTO.setMenuIcon(module.getMenuIcon());
            modelDTO.setMenuIconChecked(module.getMenuIconChecked());
            modelDTO.setSort(module.getSort());
            modelDTO.setMenuType(module.getMenuType());

            modelDTO.setChildren(
                    listChildrenMenu(
                            parentMenuIdChidrenMenuMap.get(module.getId()),
                            menuIdPermissionMap,
                            rolePermissionUids));
            moduleDTOs.add(modelDTO);
        }
        return moduleDTOs;
    }

    private Map<Integer, List<MenuPO>> mapModuleToMenus(List<Integer> parentIds) {
        List<MenuPO> childrenMenus = menuMapper.listMenuByParentIds(parentIds);
        Map<Integer, List<MenuPO>> moduleToMenus = childrenMenus.stream().collect(Collectors.groupingBy(MenuPO::getParent));
        return moduleToMenus;
    }


    private Map<Integer, List<PermissionPO>> mapMenuToPermissions(List<Integer> parentMenuIds) {
        List<PermissionPO> modulesPermissions = permissionService.listPermissionByParentMenuIds(parentMenuIds);
        Map<Integer, List<PermissionPO>> menuToPermissions = modulesPermissions.stream().collect(Collectors.groupingBy(PermissionPO::getMenuId));
        return menuToPermissions;
    }

    private List<ChildMenuDTO> listChildrenMenu(
            List<MenuPO> childrenMenu,
            Map<Integer, List<PermissionPO>> menuIdPermissionMap,
            List<String> rolePermissionUids){
        if(CollectionUtils.isEmpty(childrenMenu)){
            return Collections.emptyList();
        }

        List<ChildMenuDTO> children = new ArrayList<>();
        for(MenuPO menu: childrenMenu){
            ChildMenuDTO child = new ChildMenuDTO();
            child.setMenuId(menu.getId());
            child.setMenuName(menu.getName());
            child.setSkipUrl(menu.getSkipUrl());
            child.setSort(menu.getSort());
            child.setMenuType(menu.getMenuType());

            child.setPermissions(
                    listMenuPermission(
                            menuIdPermissionMap.get(menu.getId()),
                            rolePermissionUids));
            children.add(child);
        }
        return children;
    }

    private List<PermissionDTO> listMenuPermission(List<PermissionPO> menuPermission, List<String> rolePermissionUids){
        if(CollectionUtils.isEmpty(menuPermission)){
            return Collections.emptyList();
        }

        List<PermissionDTO> permissions = new ArrayList<>();
        for(PermissionPO permission : menuPermission){
            if(null == permission || StringUtils.isBlank(permission.getPermissionKey())){
                continue;
            }
            PermissionDTO permissionDTO = copyPermissionPOToDTO(permission);
            permissionDTO.setIsRoleSelected(rolePermissionUids.contains(permission.getPermissionUid()));

            permissions.add(permissionDTO);
        }
        return permissions;
    }

    private PermissionDTO copyPermissionPOToDTO(PermissionPO permission){
        PermissionDTO permissionDTO = new PermissionDTO();
        BeanUtils.copyProperties(permission, permissionDTO);
        return permissionDTO;
    }

    @Override
    public List<MenuDTO> listAllParentMenus() {
        List<MenuPO> menuPOS = menuMapper.listAllParentMenus();
        if (CollectionUtils.isEmpty(menuPOS)){
            return Collections.emptyList();
        }
        List<MenuDTO> menuDTOS = new ArrayList<>();
        for (MenuPO menuPO : menuPOS){
            MenuDTO menuDTO = new MenuDTO();
            BeanUtils.copyProperties(menuPO, menuDTO);
            menuDTOS.add(menuDTO);
        }
        return menuDTOS;
    }


    @Override
    public List<MenuVO> listMenuByPermissionKeys(Set<String> permissionKeys) {
        List<PermissionPO> permissions = permissionService.listPermissionByPermissionKeys(permissionKeys);
        if(CollectionUtils.isEmpty(permissions)){
            return Collections.emptyList();
        }

        List<Integer> moduleIds = permissions
                .stream()
                .map(permission -> permission.getParentMenuId())
                .distinct()
                .collect(Collectors.toList());
        List<Integer> menuIds = permissions
                .stream()
                .map(permission -> permission.getMenuId())
                .distinct()
                .collect(Collectors.toList());
        moduleIds.addAll(menuIds);

        List<MenuPO> moduleAndMenus = menuMapper.listMenuByIds(moduleIds);
        if(CollectionUtils.isEmpty(moduleAndMenus)){
            return Collections.emptyList();
        }

        List<MenuVO> resultMenu = new ArrayList<>();
        for(MenuPO moduleOrMenu : moduleAndMenus){
            MenuVO menu = new MenuVO();
            BeanUtils.copyProperties(moduleOrMenu, menu);
            resultMenu.add(menu);
        }
        return resultMenu;
    }


    @Override
    public void addPermissionToRole(String roleKey, String permissionKey) {
        RolePO rolePO = roleService.searchRoleByUidOrKey(null, roleKey);
        EditRoleRequestDTO editRoleRequestDTO = new EditRoleRequestDTO();
        PermissionPO permissionPO = permissionService.getPermissionByPermissionKey(permissionKey);
        editRoleRequestDTO.setPermissionUids(Arrays.asList(permissionPO.getPermissionUid()));
        rolePermissionService.insertRolePermission(rolePO.getRoleUid(), editRoleRequestDTO);
    }


}
