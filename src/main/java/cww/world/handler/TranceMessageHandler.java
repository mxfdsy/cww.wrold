package cww.world.handler;

import cww.world.common.constant.BaseCode;
import cww.world.common.exception.BaseException;
import cww.world.common.validate.EntityValidator;
import cww.world.common.validate.ValidateResult;
import cww.world.common.validate.group.Insert;
import cww.world.pojo.dto.messsage.ModuleOperationTraceMessageDTO;
import cww.world.service.trance.TranceService;
import cww.world.service.trance.impl.DefaultTranceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 小武 on 2018/9/1.
 */
@Component("tranceMessageHandler")
public class TranceMessageHandler {
    private static Logger logger = LoggerFactory.getLogger(TranceMessageHandler.class);

    @Autowired
    private Map<String, TranceService> tranceServiceMap;

    @Autowired
    private DefaultTranceServiceImpl defaultTranceServiceimpl;


    private  void  handleMessage(ModuleOperationTraceMessageDTO moduleOperationTraceMessageDTO) {
        logger.info("开始校验数据记录的入参信息");
        ValidateResult validate = EntityValidator.validate(moduleOperationTraceMessageDTO, Insert.class);
        if (validate.hasError()) {
            throw new BaseException(BaseCode.DATE_ERROR, validate.getErrorMessages());
        }

        TranceService orDefault = tranceServiceMap.getOrDefault(
                moduleOperationTraceMessageDTO.getProgramName() + "TranceImpl", defaultTranceServiceimpl);
        orDefault.defaultTranceImpl(moduleOperationTraceMessageDTO);
    }
}
