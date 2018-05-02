package com.common.pojo.entity;

import com.common.base.enums.KeyStateEnum;
import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class KeyPair extends BaseModel {

    private KeyStateEnum stateEnum;

    public KeyStateEnum getStateEnum() {
        return stateEnum;
    }

    public void setStateEnum(KeyStateEnum stateEnum) {
        this.stateEnum = stateEnum;
    }
}
