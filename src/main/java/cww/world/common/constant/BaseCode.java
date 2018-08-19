package cww.world.common.constant;

import java.util.HashMap;
import java.util.Map;

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
