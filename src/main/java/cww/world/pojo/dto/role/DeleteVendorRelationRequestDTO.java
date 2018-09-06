package cww.world.pojo.dto.role;

import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by Teo on 2018/6/30.
 */
public class DeleteVendorRelationRequestDTO {
    @JSONField(name = "vendor_mall_user_uid")
    private String vendorMallUserUid;

    @JSONField(name = "guide_mall_user_uids")
    private List<String> guideMallUserUids;

    @JSONField(name = "mall_uid")
    private String mallUid;

    public String getVendorMallUserUid() {
        return vendorMallUserUid;
    }

    public void setVendorMallUserUid(String vendorMallUserUid) {
        this.vendorMallUserUid = vendorMallUserUid;
    }

    public List<String> getGuideMallUserUids() {
        return guideMallUserUids;
    }

    public void setGuideMallUserUids(List<String> guideMallUserUids) {
        this.guideMallUserUids = guideMallUserUids;
    }

    public String getMallUid() {
        return mallUid;
    }

    public void setMallUid(String mallUid) {
        this.mallUid = mallUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
