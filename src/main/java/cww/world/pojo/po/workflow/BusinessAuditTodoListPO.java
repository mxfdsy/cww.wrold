package cww.world.pojo.po.workflow;

import cww.world.common.Enum.workflow.UserAuditStatusEnum;
import cww.world.pojo.po.BasePO;

public class BusinessAuditTodoListPO extends BasePO {
    private String todoUid;
    private String auditProgressUid;
    private String auditorUserUid;
    private String auditorUserName;
    private UserAuditStatusEnum status;
    private String source;

    public String getTodoUid() {
        return todoUid;
    }

    public void setTodoUid(String todoUid) {
        this.todoUid = todoUid;
    }

    public String getAuditProgressUid() {
        return auditProgressUid;
    }

    public void setAuditProgressUid(String auditProgressUid) {
        this.auditProgressUid = auditProgressUid;
    }

    public String getAuditorUserUid() {
        return auditorUserUid;
    }

    public void setAuditorUserUid(String auditorUserUid) {
        this.auditorUserUid = auditorUserUid;
    }

    public UserAuditStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserAuditStatusEnum status) {
        this.status = status;
    }

    public String getAuditorUserName() {
        return auditorUserName;
    }

    public void setAuditorUserName(String auditorUserName) {
        this.auditorUserName = auditorUserName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
