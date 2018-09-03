package cww.world.mapper.common;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface BaseMapper {
    
    String getUuid();

    Long getSequenceNextVal(@Param("sequenceName") String sequenceName);

    Date getDBCurrentTime();

}
