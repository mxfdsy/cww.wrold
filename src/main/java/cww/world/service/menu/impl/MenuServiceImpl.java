package cww.world.service.menu.impl;

import cww.world.common.constant.BaseCode;
import cww.world.mapper.menu.MenuMapper;
import cww.world.pojo.dto.menu.MenuDTO;
import cww.world.pojo.po.menu.MenuPO;
import cww.world.service.menu.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    

    
    @Autowired
    private MenuMapper menuMapper;



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
}
