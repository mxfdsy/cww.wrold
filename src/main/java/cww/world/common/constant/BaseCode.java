package cww.world.common.constant;
/**
 * @author 小武 on 2018/8/17.\
 *
 */
public enum BaseCode {
    /**
     * success
     */
    SUCESS(200, "Opeartion success"),

    UNKNOWN(-1, "Unknown error"),

    PERMISSION_IS_NOT_EXIST(13001,"权限信息不存在"),

    INTERNAL_ERROR(11002,"请求信息不存在"),

    DATE_ERROR(11003, "数据异常"),

    DB_INSERT_ERROR(19999, "数据库插入错误"),

    ROLE_NAME_IS_EXIST_ERROR(25003,"角色名已存在"),

    ROLE_CREATE_ERROR(25001, "角色创建失败"),

    ROLE_IS_NOT_EXIST_ERROR(25004,"角色不存在"),

    INVALID_ARGUMENT(11001, "请求参数错误");

    private int code;
    private String message;


    BaseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    //   不知道干嘛的代码
//    public static BaseCode valueOf(int code) {
//        BaseCode ec = values.get(code);
//        if (ec != null) {
//            return ec;
//        }
//        return UNKNOWN;
//    }
//
//    public static BaseCode valueOfCodeStr(String codeStr) {
//        try {
//            int code = Integer.valueOf(codeStr);
//            BaseCode ec = values.get(code);
//            if (ec != null) {
//                return ec;
//            }
//            return UNKNOWN;
//        } catch (Exception e) {
//            return UNKNOWN;
//        }
//    }
//
//
//    private static final Map<Integer, BaseCode> values = new HashMap<Integer, BaseCode>();
//
//    static {
//        for (BaseCode ec : BaseCode.values()) {
//            values.put(ec.code, ec);
//        }
//    }

}
