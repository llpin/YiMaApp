package com.common.pojo;

import com.common.pojo.entity.Employee;
import com.common.pojo.entity.Individual;
import com.common.pojo.entity.Organization;
import com.common.pojo.entity.User;

import java.io.Serializable;

/**
 * Created by linlipin on 18/3/1.
 */

public class UserVo implements Serializable{

    private User user;
    private Organization organization;

    private Individual individual;

    private Employee employee;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
