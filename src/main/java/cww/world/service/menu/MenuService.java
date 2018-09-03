package cww.world.service.menu;

import cww.world.common.constant.BaseCode;
import cww.world.pojo.dto.menu.InsertChildrenMenuDTO;
import cww.world.pojo.dto.menu.ListMenuRequestDTO;
import cww.world.pojo.dto.menu.MenuDTO;
import cww.world.pojo.dto.menu.ModuleDTO;

import java.util.List;


public interface MenuService {

    /**
     * 创建一级菜单
     * @param menu
     * @return
     */
    BaseCode insertModule(MenuDTO menu);


    /**
     * 更新二级菜单
     * @return
     */
    BaseCode insertChildrenMenu(InsertChildrenMenuDTO request);


    /**
     * 获取菜单列表
     * @param requestDTO
     * @return
     */
    List<ModuleDTO> listModuleMenu(ListMenuRequestDTO requestDTO);

    List<MenuDTO> listAllParentMenus();

}
