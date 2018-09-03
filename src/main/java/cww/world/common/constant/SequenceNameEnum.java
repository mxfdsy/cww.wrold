package cww.world.common.constant;

/**
 * Created by xf on 2018/5/30.
 */
public enum SequenceNameEnum {

    /**
     * 角色key序列
     */
    TNT_SYS_ROLR_KEY("tnt_sys_role_key");

    private String sequenceName;

    /**
     * @param sequenceName
     */
    private SequenceNameEnum(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public String getSequenceName() {
        return sequenceName;
    }
}
