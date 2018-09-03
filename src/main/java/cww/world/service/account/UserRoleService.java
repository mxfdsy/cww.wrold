package cww.world.service.account;


import cww.world.pojo.dto.role.UserRoleRequestDTO;


public interface UserRoleService {

    
    int deleteByUids(UserRoleRequestDTO request);

}
