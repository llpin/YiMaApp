package com.common.pojo.entity;

import com.common.base.enums.OrganizationTypeEnum;
import com.common.pojo.entity.base.TypeModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class OrganizationType extends TypeModel {
    private OrganizationTypeEnum code;

    public OrganizationTypeEnum getCode() {
        return code;
    }

    public void setCode(OrganizationTypeEnum code) {
        this.code = code;
    }
}
