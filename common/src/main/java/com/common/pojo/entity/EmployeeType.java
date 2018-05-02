package com.common.pojo.entity;

import com.common.base.enums.EmployeeLevelEnum;
import com.common.pojo.entity.base.TypeModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class EmployeeType extends TypeModel {
    private String code;
    private OrganizationType organizationType;
    private EmployeeLevelEnum employeeLevel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(OrganizationType organizationType) {
        this.organizationType = organizationType;
    }

    public EmployeeLevelEnum getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(EmployeeLevelEnum employeeLevel) {
        this.employeeLevel = employeeLevel;
    }
}
