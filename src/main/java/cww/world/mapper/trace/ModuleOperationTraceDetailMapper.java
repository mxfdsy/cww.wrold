package cww.world.mapper.trace;

import cww.world.pojo.po.trace.ModuleOperationTraceDetailPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wyz
 */
@Mapper
public interface ModuleOperationTraceDetailMapper {
    int batchInsertModuleOperationTraceDeatils(List<ModuleOperationTraceDetailPO> ModuleOperationTraceDetailPO);
}
