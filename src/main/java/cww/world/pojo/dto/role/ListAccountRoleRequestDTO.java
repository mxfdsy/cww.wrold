package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;

public class ListAccountRoleRequestDTO {

    @JSONField(name = "role_name")
    private String roleName;
    
    @JSONField(name = "system_type")
    private String systemType;
    
    @JSONField(name = "system_type_prefix")
    private String systemTypePrefix;
    
    private ListAccountRoleRequestDTO(String roleName, String systemType,
            String systemTypePrefix) {
        super();
        this.roleName = roleName;
        this.systemType = systemType;
        this.systemTypePrefix = systemTypePrefix;
    }
    public ListAccountRoleRequestDTO() {
        super();
    }

    public static ListAccountRoleRequestDTO getInstance(String roleName, String systemType){
        return new ListAccountRoleRequestDTO(roleName, systemType, null);
    }
    
    public static ListAccountRoleRequestDTO getPrefixInstance(String roleName, String systemType){
        return new ListAccountRoleRequestDTO(roleName, null, systemType);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getSystemTypePrefix() {
        return systemTypePrefix;
    }

    public void setSystemTypePrefix(String systemTypePrefix) {
        this.systemTypePrefix = systemTypePrefix;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ListAccountRoleRequestDTO [roleName=");
        builder.append(roleName);
        builder.append(", systemType=");
        builder.append(systemType);
        builder.append(", systemTypePrefix=");
        builder.append(systemTypePrefix);
        builder.append("]");
        return builder.toString();
    }
}
