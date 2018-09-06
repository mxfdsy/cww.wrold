package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Select;
import cww.world.pojo.dto.PageableRequestDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Teo on 2018/6/21.
 */
public class ListProgramInfoRequestDTO extends PageableRequestDTO {
    @JSONField(name = "role_uid")
    private String roleUid;

    @JSONField(name = "program_name")
    private String programName;

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getRoleUid() {

        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
