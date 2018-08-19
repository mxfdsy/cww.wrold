package cww.world.common.exception;

import com.alibaba.fastjson.JSON;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小武 on 2018/8/17.
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private final BaseCode error;

    public BaseException(BaseCode error) {
        this(error,error.getMessage(),null);
    }

    public BaseException(BaseCode ec, String message, Throwable cause) {
        super(message, cause);
        error = ec;
    }

    public BaseException(BaseCode error,String message) {
        this(error,message,null);
    }

    public BaseCode getError() {
        return error;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        Map<String, String> jsonObj = new HashMap<String, String>();
        jsonObj.put(Constants.CODE_FLAG, String.valueOf(error.getCode()));
        jsonObj.put(Constants.ERROR_MSG_FLAG, error.getMessage()+","+this.getMessage());

        return JSON.toJSONString(jsonObj);

    }
}
