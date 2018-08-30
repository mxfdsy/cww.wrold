package cww.world.mapper.user;

import cww.world.pojo.dto.PageableRequestDTO;
import cww.world.pojo.po.user.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserPOMapper {
    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);

    List<UserPO> listUserInfo(PageableRequestDTO pageableRequestDTO);

    UserPO getUserInfoByLoginName(@Param("loginName") String loginName);

    UserPO getUserInfoByUid(@Param("userUid") String userUid);

    int insertUserInfo(UserPO userPO);

    int countUserPhone(String phone);

    int updateUserinfo(UserPO userPO);
}