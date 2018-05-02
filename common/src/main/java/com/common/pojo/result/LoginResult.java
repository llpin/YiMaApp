package com.common.pojo.result;

import com.common.pojo.params.ResultModel;
import com.common.pojo.params.LoginParams;

/**
 * Created by linlipin on 18/3/1.
 */

public class LoginResult extends ResultModel {
    private LoginParams params;

    public LoginParams getParams() {
        return params;
    }

    public void setParams(LoginParams params) {
        this.params = params;
    }
}
