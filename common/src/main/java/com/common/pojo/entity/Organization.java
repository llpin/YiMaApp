package com.common.pojo.entity;

import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/4/27.
 */

public class Organization extends BaseModel {
    private String name;
    private String description;
    private String email;
    private String telephone;
    private String mobilePhone;
    private String address;
    private String postAddress;

    private OrganizationType organizationType;
    private Long organizationTypeId;

    private Individual representative;
    User user;

    private EmployeeRsa centerLegalRsa;

    private OrganizationRsa centerRsa;

    String promise;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }

    public Long getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(Long organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }

    public Individual getRepresentative() {
        return representative;
    }

    public void setRepresentative(Individual representative) {
        this.representative = representative;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EmployeeRsa getCenterLegalRsa() {
        return centerLegalRsa;
    }

    public void setCenterLegalRsa(EmployeeRsa centerLegalRsa) {
        this.centerLegalRsa = centerLegalRsa;
    }

    public OrganizationRsa getCenterRsa() {
        return centerRsa;
    }

    public void setCenterRsa(OrganizationRsa centerRsa) {
        this.centerRsa = centerRsa;
    }

    public String getPromise() {
        return promise;
    }

    public void setPromise(String promise) {
        this.promise = promise;
    }
}
