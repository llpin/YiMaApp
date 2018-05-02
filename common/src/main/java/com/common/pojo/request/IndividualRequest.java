package com.common.pojo.request;

import com.common.base.enums.IndividualTypeEnum;

import java.io.Serializable;

/**
 * Created by linlipin on 18/3/2.
 */

public class IndividualRequest implements Serializable {
    private static final long serialVersionUID=1001L;
    private String name;
    private UserRequest user;
    private String genderType;
    private String email;
    private String telephone;
    private String mobilePhone;
    private String address;
    private String postAddress;
    private String verifyCode;
//    身份证
    private String idNumber;
    private Long frontIDImageId;
    private Long backIDImageId;
    private Long individualTypeId;
    private IndividualTypeEnum individualTypeEnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Long getFrontIDImageId() {
        return frontIDImageId;
    }

    public void setFrontIDImageId(Long frontIDImageId) {
        this.frontIDImageId = frontIDImageId;
    }

    public Long getBackIDImageId() {
        return backIDImageId;
    }

    public void setBackIDImageId(Long backIDImageId) {
        this.backIDImageId = backIDImageId;
    }

    public Long getIndividualTypeId() {
        return individualTypeId;
    }

    public void setIndividualTypeId(Long individualTypeId) {
        this.individualTypeId = individualTypeId;
    }

    public IndividualTypeEnum getIndividualTypeEnum() {
        return individualTypeEnum;
    }

    public void setIndividualTypeEnum(IndividualTypeEnum individualTypeEnum) {
        this.individualTypeEnum = individualTypeEnum;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
