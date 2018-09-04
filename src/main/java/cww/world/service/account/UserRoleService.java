package cww.world.service.account;


import cww.world.pojo.dto.role.UserRoleRequestDTO;
import cww.world.pojo.dto.user.LoginRoleDTO;

import java.util.List;


public interface UserRoleService {
    
    int deleteByUids(UserRoleRequestDTO request);

    List<LoginRoleDTO> listUserRoleInfo(String userUid);


}
