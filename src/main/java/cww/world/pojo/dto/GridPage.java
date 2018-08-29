package cww.world.pojo.dto;

import java.util.Collections;
import java.util.List;

/**
 * @author xujun
 */
public class GridPage<T> {
    private Integer total;
    private List<T> content;

    public GridPage() {
    }

    public static GridPage emptyInstance() {
        return new GridPage(0, Collections.emptyList());
    }

    public GridPage(Integer total, List<T> content) {
        this.total = total;
        this.content = content;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
