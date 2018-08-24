package cww.world.pojo.dto.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.PageableRequestDTO;

/**
 * @author 小武 on 2018/8/24.
 */
public class ListUserDTO extends PageableRequestDTO {
    @JSONField(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  JSON.toJSONString(this);
    }
}
