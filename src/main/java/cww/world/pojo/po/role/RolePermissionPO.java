package cww.world.pojo.po.role;


import cww.world.pojo.po.BasePO;

/**
 * Created by xf on 2018/5/30.
 */
public class RolePermissionPO extends BasePO {

    private String roleUid;

    private String permissionUid;

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid;
    }

    public String getPermissionUid() {
        return permissionUid;
    }

    public void setPermissionUid(String permissionUid) {
        this.permissionUid = permissionUid;
    }

    public RolePermissionPO() {
        super();
    }

    public RolePermissionPO(String roleUid, String permissionUid, String createdBy, String updatedBy) {
        this.roleUid = roleUid;
        this.permissionUid = permissionUid;
        super.setCreatedBy(createdBy);
        super.setUpdatedBy(updatedBy);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RolePermissionPO{");
        sb.append("roleUid='").append(roleUid).append('\'');
        sb.append(", permissionUid='").append(permissionUid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
