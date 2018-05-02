package com.common.pojo.entity.base;

import com.common.pojo.entity.base.BaseModel;

/**
 * Created by linlipin on 18/4/27.
 */

public class RsaModel extends BaseModel {
    private Boolean hasSign = false;

    public Boolean getHasSign() {
        return hasSign;
    }

    public void setHasSign(Boolean hasSign) {
        this.hasSign = hasSign;
    }
}
