package cww.world.service.common;

/**
 * Created by xf on 2018/5/30.
 */
public interface SysDBService {
    String getUuid();

    Long getSequenceNextVal(String payload);
}
