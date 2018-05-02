package com.common.pojo.entity;

import com.common.base.enums.GenderTypeEnum;
import com.common.base.enums.IndividualTypeEnum;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class Individual extends BaseModel {

    private String name;
    private GenderTypeEnum genderType;
    private String email;
    private String telephone;
    private String mobilePhone;
    private String verifyCode;
    private String address;
    private String postAddress;
    private String idNumber;
    private IDImage frontIDImage;
    private Long frontIDImageId;
    private IDImage backIDImage;
    private Long backIDImageId;
    private IndividualType individualType;
    private IndividualTypeEnum individualTypeEnum;
    private OrganizationRsa center;
    User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderTypeEnum getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderTypeEnum genderType) {
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

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
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

    public IDImage getFrontIDImage() {
        return frontIDImage;
    }

    public void setFrontIDImage(IDImage frontIDImage) {
        this.frontIDImage = frontIDImage;
    }

    public Long getFrontIDImageId() {
        return frontIDImageId;
    }

    public void setFrontIDImageId(Long frontIDImageId) {
        this.frontIDImageId = frontIDImageId;
    }

    public IDImage getBackIDImage() {
        return backIDImage;
    }

    public void setBackIDImage(IDImage backIDImage) {
        this.backIDImage = backIDImage;
    }

    public Long getBackIDImageId() {
        return backIDImageId;
    }

    public void setBackIDImageId(Long backIDImageId) {
        this.backIDImageId = backIDImageId;
    }

    public IndividualType getIndividualType() {
        return individualType;
    }

    public void setIndividualType(IndividualType individualType) {
        this.individualType = individualType;
    }

    public IndividualTypeEnum getIndividualTypeEnum() {
        return individualTypeEnum;
    }

    public void setIndividualTypeEnum(IndividualTypeEnum individualTypeEnum) {
        this.individualTypeEnum = individualTypeEnum;
    }

    public OrganizationRsa getCenter() {
        return center;
    }

    public void setCenter(OrganizationRsa center) {
        this.center = center;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
