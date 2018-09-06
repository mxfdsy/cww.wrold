package cww.world.pojo.po.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import cww.world.pojo.po.BasePO;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.util.List;

public class WorkflowCombinationStrategyPO extends BasePO {
    @JSONField(name = "combination_uid")
    private String combinationUid;
    @NotBlank(message = "组合名称不能为空", groups = Insert.class)
    @JSONField(name = "combination_name")
    private String combinationName;

    @Valid
    @NotEmpty(message = "组合详情不能为空", groups = Insert.class)
    @JSONField(name = "combination_item_list")
    private List<WorkflowCombinationStrategyItemPO> combinationItemList;

    public String getCombinationUid() {
        return combinationUid;
    }

    public void setCombinationUid(String combinationUid) {
        this.combinationUid = combinationUid;
    }

    public String getCombinationName() {
        return combinationName;
    }

    public void setCombinationName(String combinationName) {
        this.combinationName = combinationName;
    }

    public List<WorkflowCombinationStrategyItemPO> getCombinationItemList() {
        return combinationItemList;
    }

    public void setCombinationItemList(List<WorkflowCombinationStrategyItemPO> combinationItemList) {
        this.combinationItemList = combinationItemList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WorkflowCombinationStrategyPO{");
        sb.append("combinationUid='").append(combinationUid).append('\'');
        sb.append(", combinationName='").append(combinationName).append('\'');
        sb.append(", combinationItemList=").append(combinationItemList);
        sb.append('}');
        return sb.toString();
    }
}
