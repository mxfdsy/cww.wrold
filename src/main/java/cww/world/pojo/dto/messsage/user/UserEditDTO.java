package cww.world.pojo.dto.messsage.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import cww.world.common.validate.group.Insert;
import cww.world.common.validate.group.Update;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserEditDTO {

    @NotNull(message = "更新集团uid不能为空", groups = { Update.class })
    @Size(min = 1, message = "更新集团uid不能为空", groups = { Update.class })
    @JSONField(name = "company_uid")
	private String companyUid;

    @JSONField(name = "business_code")
	private String businessCode;
	
    @NotNull(message = "公司名称不能为空", groups = { Insert.class })
    @Size(min = 1, max = 30, message = "公司名称长度应大于1小于等于30", groups = { Insert.class })
    @JSONField(name = "company_name")
	private String companyName;
	
    @NotNull(message = "公司简称不能为空", groups = { Insert.class })
    @Size(min = 1, max = 30, message = "公司简称长度应大于1小于等于30", groups = { Insert.class })
    @JSONField(name = "company_short_name")
	private String companyShortName;
	
    @NotNull(message = "公司类型不能为空", groups = { Insert.class })
    @Size(min = 1, message = "公司类型不能为空", groups = { Insert.class })
    @JSONField(name = "company_type")
	private String companyType;
	
    @NotNull(message = "法人代表不能为空", groups = { Insert.class })
    @Size(min = 1, max = 5, message = "法人代表长度应大于1小于等于5", groups = { Insert.class })
    @JSONField(name = "corporate_representative")
	private String corporateRepresentative;
	
    @NotNull(message = "所属行业不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, max = 50, message = "所属行业长度应大于1小于等于20", groups = { Insert.class, Update.class })
    @JSONField(name = "industry")
	private String industry;
	
    @NotNull(message = "电话不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1,  max = 20, message = "电话长度应大于1小于20", groups = { Insert.class, Update.class })
    @JSONField(name = "phone")
	private String phone;

    @JSONField(name = "company_country_id")
    private String companyCountryId;

    @JSONField(name = "company_country")
    private String companyCountry;
	
    @NotNull(message = "省id不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, message = "省id不能为空", groups = { Insert.class, Update.class })
    @JSONField(name = "company_province_id")
    private String companyProvinceId;
    
    @NotNull(message = "省不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, message = "省不能为空", groups = { Insert.class, Update.class })
    @JSONField(name = "company_province")
    private String companyProvince;

    @NotNull(message = "市id不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, message = "市id不能为空", groups = { Insert.class, Update.class })
    @JSONField(name = "company_city_id")
    private String companyCityId;
	
    @NotNull(message = "市不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, message = "市不能为空", groups = { Insert.class, Update.class })
    @JSONField(name = "company_city")
    private String companyCity;
	
    @NotNull(message = "区id不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, message = "区id不能为空", groups = { Insert.class, Update.class })
    @JSONField(name = "company_district_id")
    private String companyDistrictId;
	
    @NotNull(message = "区不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, message = "区不能为空", groups = { Insert.class, Update.class })
    @JSONField(name = "company_district")
    private String companyDistrict;
	
    @NotNull(message = "详细地址不能为空", groups = { Insert.class, Update.class })
    @Size(min = 1, max = 50, message = "详细地址长度应为1~50", groups = { Insert.class, Update.class })
    @JSONField(name = "company_address")
    private String companyAddress;
    
    @JSONField(name = "company_detail_address")
    private String companyDetailAddress;

    private String fax;

    @JSONField(name = "deposit_bank")
	private String depositBank;
	
    @JSONField(name = "bank_account")
	private String bankAccount;
	
    @JSONField(name = "bank_account_name")
	private String bankAccountName;
	
    @JSONField(name = "duty_paragraph")
	private String dutyParagraph;
	
    @JSONField(name = "company_email")
	private String companyEmail;
    
    @JSONField(name = "operator_uid")
    private String operatorUid;

    @JSONField(name = "industry_uid")
    private String industryUid;

    @JSONField(name = "company_type_uid")
    private String companyTypeUid;

    public String getIndustryUid() {
        return industryUid;
    }

    public void setIndustryUid(String industryUid) {
        this.industryUid = industryUid;
    }

    public String getCompanyTypeUid() {
        return companyTypeUid;
    }

    public void setCompanyTypeUid(String companyTypeUid) {
        this.companyTypeUid = companyTypeUid;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyUid() {
        return companyUid;
    }

    public void setCompanyUid(String companyUid) {
        this.companyUid = companyUid;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCorporateRepresentative() {
        return corporateRepresentative;
    }

    public void setCorporateRepresentative(String corporateRepresentative) {
        this.corporateRepresentative = corporateRepresentative;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyCountryId() {
        return companyCountryId;
    }

    public void setCompanyCountryId(String companyCountryId) {
        this.companyCountryId = companyCountryId;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    public String getCompanyProvinceId() {
        return companyProvinceId;
    }

    public void setCompanyProvinceId(String companyProvinceId) {
        this.companyProvinceId = companyProvinceId;
    }

    public String getCompanyProvince() {
        return companyProvince;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
    }

    public String getCompanyCityId() {
        return companyCityId;
    }

    public void setCompanyCityId(String companyCityId) {
        this.companyCityId = companyCityId;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyDistrictId() {
        return companyDistrictId;
    }

    public void setCompanyDistrictId(String companyDistrictId) {
        this.companyDistrictId = companyDistrictId;
    }

    public String getCompanyDistrict() {
        return companyDistrict;
    }

    public void setCompanyDistrict(String companyDistrict) {
        this.companyDistrict = companyDistrict;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyDetailAddress() {
        return companyDetailAddress;
    }

    public void setCompanyDetailAddress(String companyDetailAddress) {
        this.companyDetailAddress = companyDetailAddress;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getDutyParagraph() {
        return dutyParagraph;
    }

    public void setDutyParagraph(String dutyParagraph) {
        this.dutyParagraph = dutyParagraph;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getOperatorUid() {
        return operatorUid;
    }

    public void setOperatorUid(String operatorUid) {
        this.operatorUid = operatorUid;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


    public String stringForComparison() {
        final StringBuffer sb = new StringBuffer();
        sb.append(",BUSINESS_CODE=").append(businessCode);
        sb.append(",COMPANY_NAME=").append(companyName);
        sb.append(",COMPANY_SHORT_NAME=").append(companyShortName);
        sb.append(",COMPANY_TYPE=").append(companyType);
        sb.append(",CORPORATE_REPRESENTATIVE=").append(corporateRepresentative);
        sb.append(",INDUSTRY=").append(industry);
        sb.append(",PHONE=").append(phone);
        sb.append(",COMPANY_DETAIL_ADDRESS=").append(companyDetailAddress);
        sb.append(",DEPOSIT_BANK=").append(depositBank);
        sb.append(",BANK_ACCOUNT=").append(bankAccount);
        sb.append(",BANK_ACCOUNT_NAME=").append(bankAccountName);
        sb.append(",DUTY_PARAGRAPH=").append(dutyParagraph);
        sb.append(",COMPANY_EMAIL=").append(companyEmail);
        sb.append(",FAX=").append(fax);
        return sb.toString();
    }
}
