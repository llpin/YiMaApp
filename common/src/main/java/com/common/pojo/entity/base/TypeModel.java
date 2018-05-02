package com.common.pojo.entity.base;

import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class TypeModel extends BaseModel {
    private String name;
    private String description;

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
}
