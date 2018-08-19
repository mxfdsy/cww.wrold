package cww.world.common.util;


import com.alibaba.fastjson.JSONObject;
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
}
