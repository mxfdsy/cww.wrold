package cww.world.pojo.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class BasePO {

    @JSONField(name = "created_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JSONField(name = "created_by")
    private String createdBy;

    @JSONField(name = "updated_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @JSONField(name = "updated_by")
    private String updatedBy;

    private Integer archive;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer isArchive() {
        return archive;
    }

    public void setArchive(Integer archive) {
        this.archive = archive;
    }

}
