package cww.world.mapper.trace;
import cww.world.pojo.po.trace.ModuleOperationTracePO;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author cww
 */
@Mapper
public interface ModuleOperationTraceMapper {
    int insertModuleOperationTrace(ModuleOperationTracePO brandOperationTracePO);
}
