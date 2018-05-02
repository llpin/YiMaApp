package com.common.pojo.entity;

import com.common.pojo.entity.base.RsaModel;

/**
 * Created by linlipin on 18/4/27.
 */

public class EmployeeRsa extends RsaModel {
    private Long employeeId;
    private Employee employee;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
