package cww.world.mapper.account;


import cww.world.pojo.dto.role.*;
import cww.world.pojo.po.account.UserRolePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<UserRolePO> listUserRole(@Param("userUid") String userUid);

    List<RoleUserCountDTO> listRoleUserCount(@Param("roleUids") List<String> roleUids);

    int deleteUserRoleByRoleUid(String roleUid);

    int deleteByUids(@Param("userRoleDTO") UserRoleRequestDTO request);

    int batchInsert(@Param("userRoleDTO") UserRoleRequestDTO request);

//    UserRolePO searchUserRole(UserRolePO userRole);

//    Integer countUserRole(UserRolePO userRole);

    List<RoleUserInfoDTO> searchRoleUserList(SearchRoleUserDTO searchRoleUserRequest);

    Integer countRoleUserList(SearchRoleUserDTO searchRoleUserRequest);

//    int batchInsertUserRoleRelation(@Param("userUid") String userUid, @Param("userRoles") List<UserRoleRelationDTO> userRoles);

    List<GroupRoleDTO> listRoleInfoByUserUid(@Param("userUid") String userUid);

    int deleteUserRoleByUserUid(@Param("userUid") String userUid);

    Integer countBusinessCompanyByRoleUid(ListProgramInfoRequestDTO requestDTO);

//    List<BusinessCompanyPO> listMallInfoByRoleUid(ListProgramInfoRequestDTO requestDTO);

//    int deleteUserRoleByUserUidAndRoleUid(UserRolePO userRole);

//    int updateMallUidByUserRole(UserRolePO userRole);

    Integer countOtherMallRoleByUserUid(@Param("userUid") String userUid, @Param("roleKey") String roleKey);

    int updateUserRoleRelation(UpdateUserRoleRelationDTO relationDTO);
}
