package com.common.pojo;

import com.common.pojo.entity.Employee;
import com.common.pojo.entity.base.BaseModel;

import java.util.Date;

/**
 * Created by linlipin on 18/3/9.
 */

public class ProductContractEmployee extends BaseModel {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
