package com.common.pojo;

import com.common.pojo.entity.User;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/3.
 */

public class ProductContract extends BaseModel {
    private String enc_cno;
    private String cno;

    private String title;
    private String encTitle;

    private String encContent;
    private String content;

    private String abstractMD5;

    private Boolean employeeHasSign = false;
    private ProductContractEmployee employeePart;

    private Boolean individualHasSign = false;
    private ProductContractIndividual individualPart;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnc_cno() {
        return enc_cno;
    }

    public void setEnc_cno(String enc_cno) {
        this.enc_cno = enc_cno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getEncTitle() {
        return encTitle;
    }

    public void setEncTitle(String encTitle) {
        this.encTitle = encTitle;
    }

    public String getEncContent() {
        return encContent;
    }

    public void setEncContent(String encContent) {
        this.encContent = encContent;
    }

    public String getAbstractMD5() {
        return abstractMD5;
    }

    public void setAbstractMD5(String abstractMD5) {
        this.abstractMD5 = abstractMD5;
    }

    public ProductContractEmployee getEmployeePart() {
        return employeePart;
    }

    public void setEmployeePart(ProductContractEmployee employeePart) {
        this.employeePart = employeePart;
    }

    public ProductContractIndividual getIndividualPart() {
        return individualPart;
    }

    public void setIndividualPart(ProductContractIndividual individualPart) {
        this.individualPart = individualPart;
    }

    public Boolean getEmployeeHasSign() {
        return employeeHasSign;
    }

    public void setEmployeeHasSign(Boolean employeeHasSign) {
        this.employeeHasSign = employeeHasSign;
    }

    public Boolean getIndividualHasSign() {
        return individualHasSign;
    }

    public void setIndividualHasSign(Boolean individualHasSign) {
        this.individualHasSign = individualHasSign;
    }
}
