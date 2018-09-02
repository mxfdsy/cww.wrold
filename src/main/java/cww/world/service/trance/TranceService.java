package cww.world.service.trance;

import cww.world.pojo.dto.messsage.ModuleOperationTraceMessageDTO;
import org.springframework.stereotype.Service;

/**
 * @author 小武 on 2018/9/1.
 */

public interface TranceService {
        default void  defaultTranceImpl(ModuleOperationTraceMessageDTO moduleOperationTraceMessageDTO){
            return;
        }

    void engerInfoParameter(ModuleOperationTraceMessageDTO moduleOperationTraceMessageDTO);
}
