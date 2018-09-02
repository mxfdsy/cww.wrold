package cww.world.pojo.po.trace;

/**
 * @author ll
 * @date 2018/6/19 19:07
 */
public class Generic<T> {
    private T key;

    public Generic() {
    }

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
