package cww.world.pojo.po.trace;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.po.BasePO;

/**
 * @author wyz
 */
public class ModuleOperationTraceDetailPO extends BasePO {
    @JSONField(name = "trace_detail_uid")
    private String traceDetailUid;
    @JSONField(name = "trace_uid")
    private String traceUid;
    @JSONField(name = "item")
    private String item;
    @JSONField(name = "item_memo")
    private String itemMemo;
    @JSONField(name = "old_value")
    private String oldValue;
    @JSONField(name = "new_value")
    private String newValue;

    public ModuleOperationTraceDetailPO() {
    }

    public ModuleOperationTraceDetailPO(String traceUid) {
        this.traceUid = traceUid;
    }

    public String getTraceDetailUid() {
        return traceDetailUid;
    }

    public void setTraceDetailUid(String traceDetailUid) {
        this.traceDetailUid = traceDetailUid;
    }

    public String getTraceUid() {
        return traceUid;
    }

    public void setTraceUid(String traceUid) {
        this.traceUid = traceUid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemMemo() {
        return itemMemo;
    }

    public void setItemMemo(String itemMemo) {
        this.itemMemo = itemMemo;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
