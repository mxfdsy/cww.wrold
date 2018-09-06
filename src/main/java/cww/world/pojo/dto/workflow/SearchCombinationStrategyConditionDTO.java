package cww.world.pojo.dto.workflow;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.pojo.dto.PageableRequestDTO;

public class SearchCombinationStrategyConditionDTO extends PageableRequestDTO {
    @JSONField(name = "combination_name")
    private String combinationName;

    public String getCombinationName() {
        return combinationName;
    }

    public void setCombinationName(String combinationName) {
        this.combinationName = combinationName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SearchCombinationStrategyConditionDTO{");
        sb.append("combinationName='").append(combinationName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
