package com.common.pojo;

import com.common.base.enums.AuditStateEnum;
import com.common.pojo.entity.Employee;
import com.common.pojo.entity.Organization;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/3.
 */

public class CodeOrderModel extends BaseModel {
    private String code;
    private ProductModel product;
    private Long productId;
    private Long count;
    //    工厂->购买方
    private Organization factory;
    private String factorySign;
    private Organization lawfirm;
    private String lawfirmSign;
    private AuditStateEnum stateEnum = AuditStateEnum.NORMAL;
    private String auditContent;
    private Employee centerEmployee;
    private Long centerEmployeeId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


    public String getFactorySign() {
        return factorySign;
    }

    public void setFactorySign(String factorySign) {
        this.factorySign = factorySign;
    }


    public String getLawfirmSign() {
        return lawfirmSign;
    }

    public void setLawfirmSign(String lawfirmSign) {
        this.lawfirmSign = lawfirmSign;
    }

    public AuditStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(AuditStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public Employee getCenterEmployee() {
        return centerEmployee;
    }

    public void setCenterEmployee(Employee centerEmployee) {
        this.centerEmployee = centerEmployee;
    }

    public Long getCenterEmployeeId() {
        return centerEmployeeId;
    }

    public void setCenterEmployeeId(Long centerEmployeeId) {
        this.centerEmployeeId = centerEmployeeId;
    }

    public Organization getFactory() {
        return factory;
    }

    public void setFactory(Organization factory) {
        this.factory = factory;
    }

    public Organization getLawfirm() {
        return lawfirm;
    }

    public void setLawfirm(Organization lawfirm) {
        this.lawfirm = lawfirm;
    }
}
