package cww.world.common.validate;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 小武 on 2018/8/16.
 */
public class ValidateResult {

    private static final String EMPTY_MESSAGE = "";
    private static final String DEFAULT_MSG_SEPERATOR = ",";
    private List<String> messages = new ArrayList<>();


    public void addErrorMessage(String msg) {
        this.messages.add(msg);
    }

    public boolean hasError() {
        return messages.size() > 0;
    }


    public String getErrorMessages() {
        if (!hasError()) {
            return EMPTY_MESSAGE;
        }
        return StringUtils.join(messages, DEFAULT_MSG_SEPERATOR);
    }
}
