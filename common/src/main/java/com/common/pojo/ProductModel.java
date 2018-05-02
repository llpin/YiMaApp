package com.common.pojo;

import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/3.
 */

public class ProductModel extends BaseModel {
    private String name;
    private String function;
    private String description;
    private ProductPromiseModel promise;
    private Long organizationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductPromiseModel getPromise() {
        return promise;
    }

    public void setPromise(ProductPromiseModel promise) {
        this.promise = promise;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
