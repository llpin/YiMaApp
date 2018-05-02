package com.common.pojo;

import com.common.base.enums.PlatformMainTypeEnum;
import com.common.pojo.entity.base.TypeModel;

/**
 * Created by linlipin on 18/3/1.
 */

public class PlatformMainType extends TypeModel {
    private PlatformMainTypeEnum code;

    public PlatformMainTypeEnum getCode() {
        return code;
    }

    public void setCode(PlatformMainTypeEnum code) {
        this.code = code;
    }
}
