package com.common.pojo.entity;

import com.common.base.enums.IndividualTypeEnum;
import com.common.pojo.entity.base.TypeModel;

/**
 * Created by linlipin on 18/4/27.
 */

public class IndividualType extends TypeModel {
    private IndividualTypeEnum code;

    public IndividualTypeEnum getCode() {
        return code;
    }

    public void setCode(IndividualTypeEnum code) {
        this.code = code;
    }
}
