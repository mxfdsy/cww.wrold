package cww.world.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class BaseDTO {

    @JSONField(name = "created_at", format = "yyyy-MM-dd HH:mm:ss")
    public Date createdAt;
    @JSONField(name = "created_by")
    public String createdBy;
    @JSONField(name = "updated_at", format = "yyyy-MM-dd HH:mm:ss")
    public Date updatedAt;
    @JSONField(name = "updated_by")
    public String updatedBy;
    @JSONField(name = "page_no")
    public int pageNo;
    @JSONField(name = "page_size")
    public int pageSize;

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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}