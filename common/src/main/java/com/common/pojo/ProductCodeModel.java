package com.common.pojo;

import com.common.base.enums.ProductCodeStateEnum;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/3.
 */

public class ProductCodeModel extends BaseModel {
    private String code;
    private String lawfirmPKCode;
    private String factoryVKSign;
    private CodeOrderModel order;
    private ProductContract productContract;
    private ProductCodeStateEnum stateEnum;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLawfirmPKCode() {
        return lawfirmPKCode;
    }

    public void setLawfirmPKCode(String lawfirmPKCode) {
        this.lawfirmPKCode = lawfirmPKCode;
    }

    public String getFactoryVKSign() {
        return factoryVKSign;
    }

    public void setFactoryVKSign(String factoryVKSign) {
        this.factoryVKSign = factoryVKSign;
    }

    public CodeOrderModel getOrder() {
        return order;
    }

    public void setOrder(CodeOrderModel order) {
        this.order = order;
    }

    public ProductContract getProductContract() {
        return productContract;
    }

    public void setProductContract(ProductContract productContract) {
        this.productContract = productContract;
    }

    public ProductCodeStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(ProductCodeStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }
}
