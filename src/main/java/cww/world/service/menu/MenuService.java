package cww.world.service.menu;

import cww.world.common.constant.BaseCode;
import cww.world.pojo.dto.menu.MenuDTO;


public interface MenuService {



    /**
     * 创建一级菜单
     * @param menu
     * @return
     */
    BaseCode insertModule(MenuDTO menu);

}
