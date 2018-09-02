package cww.world.service.trance.impl;



import cww.world.common.constant.BaseCode;
import cww.world.common.exception.BaseException;
import cww.world.pojo.po.trace.Generic;
import cww.world.pojo.po.trace.ModuleOperationTraceDetailPO;
import cww.world.service.trance.UserOperationTraceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserOperationTraceServiceImpl implements UserOperationTraceService {

    private final Logger logger = LoggerFactory.getLogger(UserOperationTraceServiceImpl.class);


    @Override
    public List<ModuleOperationTraceDetailPO> generateDetail(Generic newValue, Generic oldValue) {
        List<ModuleOperationTraceDetailPO> messageDTOS = new ArrayList<>();
        try {
            Field[] fields = newValue.getKey().getClass().getDeclaredFields();
            for (Field field : fields) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), newValue.getKey().getClass());
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(newValue.getKey());
                Object o2 = getMethod.invoke(oldValue.getKey());
                String s1 = o1 == null ? "" : o1.toString();
                String s2 = o2 == null ? "" : o2.toString();
                if (!s1.equals(s2)) {
                    ModuleOperationTraceDetailPO messageDTO = new ModuleOperationTraceDetailPO();
                    messageDTO.setItem(field.getName());
                    messageDTO.setNewValue(s1);
                    messageDTO.setOldValue(s2);
                    messageDTOS.add(messageDTO);
                }
            }
        } catch (Exception e) {
            throw new BaseException(BaseCode.INVALID_ARGUMENT, e.getMessage());
        }
        return messageDTOS;
    }



}
