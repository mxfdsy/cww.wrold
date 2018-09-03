package cww.world.common.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cww.world.common.constant.BaseCode;
import cww.world.common.constant.Constants;
import cww.world.pojo.dto.BaseResponseDTO;

public class ResultBuilderUtils {
    public static  String  buildSuccess(String messsage){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constants.MESSAGE_FLG, messsage);
        return buildSuccess(jsonObject);
    }

    public static String buildSuccess(Object data) {
        BaseResponseDTO result = new BaseResponseDTO(data);
        return JSONObject.toJSONString(result);
    }


    private static String buildSuccess(JSONObject data) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO(data);
        return JSONObject.toJSONString(baseResponseDTO);
    }

    public static String buildError(String message) {
        BaseResponseDTO result = new BaseResponseDTO(message);
        return JSON.toJSONString(result);
    }

    public static String buildError(BaseCode errorCode) {
        BaseResponseDTO result = new BaseResponseDTO(errorCode.getCode(), errorCode.getMessage());
        return JSON.toJSONString(result);
    }

    public static String buildError(BaseCode errorCode, String errorMsg) {
        BaseResponseDTO result = new BaseResponseDTO(errorCode.getCode(), errorCode.getMessage(), errorMsg);
        return JSON.toJSONString(result);
    }

    public static String buildErrorWithData(BaseCode errorCode, Object data) {
        BaseResponseDTO result = new BaseResponseDTO(errorCode.getCode(), errorCode.getMessage(), errorCode.getMessage(), data);
        return JSON.toJSONString(result);
    }

}
