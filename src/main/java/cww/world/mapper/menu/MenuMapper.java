package cww.world.mapper.menu;


import cww.world.pojo.po.menu.MenuPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    int insertMenu(MenuPO menu);

    void updateMenuSortAndCode(@Param("id") Integer id, @Param("sort") Integer sort, @Param("code") String code);


    List<MenuPO> listAllParentMenus();

    List<MenuPO> listMenuByParentIds(@Param("moduleids") List<Integer> moduleids);

    List<MenuPO> listMenuByIds(@Param("menuIds")List<Integer> menuIds);


}
