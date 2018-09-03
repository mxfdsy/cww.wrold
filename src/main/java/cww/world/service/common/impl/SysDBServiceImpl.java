package cww.world.service.common.impl;


import cww.world.mapper.common.BaseMapper;
import cww.world.service.common.SysDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xf on 2018/5/30.
 */
@Service
public class SysDBServiceImpl implements SysDBService {
    @Autowired
    private BaseMapper baseMapper;

    @Override
    public String getUuid() {
        return baseMapper.getUuid();
    }

    @Override
    public Long getSequenceNextVal(String payload) {
        return baseMapper.getSequenceNextVal(payload);
    }

}
