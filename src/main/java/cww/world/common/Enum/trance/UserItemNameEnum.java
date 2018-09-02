package cww.world.common.Enum.trance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ll
 * @date 2018/6/15 17:02
 */
public enum UserItemNameEnum {
    companyName("companyName","公司名称"),
    companyShortName("companyShortName","公司简称"),
    companyType("companyType","公司类型"),
    corporateRepresentative("corporateRepresentative","法人代表"),
    industry("industry","所属行业"),
    phone("phone","电话"),
    depositBank("depositBank","开户银行"),
    bankAccount("bankAccount","银行账号"),
    bankAccountName("bankAccountName","账号名称"),
    fax("fax","传真"),
    dutyParagraph("dutyParagraph","税号"),
    companyEmail("companyEmail","公司邮箱"),
    companyDetailAddress("companyDetailAddress","公司地址"),
    unknow("unknow","未知字段");

    private String key;
    private String itemName;

    UserItemNameEnum(String key, String itemName) {
        this.key = key;
        this.itemName = itemName;
    }

    public static UserItemNameEnum valueOfKeyStr(String keyStr) {
        try {
            UserItemNameEnum ec = values.get(keyStr);
            if (ec != null) {
                return ec;
            }
            return unknow;
        } catch (Exception e) {
            return unknow;
        }
    }

    private static final Map<String, UserItemNameEnum> values = new HashMap<String, UserItemNameEnum>();

    static {
        for (UserItemNameEnum ec : UserItemNameEnum.values()) {
            values.put(ec.key, ec);
        }
    }

    public String getKey() {
        return key;
    }

    public String getItemName() {
        return itemName;
    }

}
