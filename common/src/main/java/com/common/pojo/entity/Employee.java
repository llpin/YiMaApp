package com.common.pojo.entity;

import com.common.base.enums.GenderTypeEnum;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class Employee extends BaseModel {
    private String code;
    private String name;
    private GenderTypeEnum genderType;
    private String email;
    private String telephone;
    private String mobilePhone;
    private String innerId;
    private EmployeeType employeeType;
    private Long EmployeeTypeId;
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

    public String getInnerId() {
        return innerId;
    }

    public void setInnerId(String innerId) {
        this.innerId = innerId;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Long getEmployeeTypeId() {
        return EmployeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        EmployeeTypeId = employeeTypeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
