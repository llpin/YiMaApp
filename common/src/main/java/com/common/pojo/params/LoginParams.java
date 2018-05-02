package com.common.pojo.params;

import com.common.pojo.UserVo;

import java.io.Serializable;

/**
 * Created by linlipin on 18/4/27.
 */

public class LoginParams implements Serializable {
    private String redirection;
    private UserVo userVo;

    public String getRedirection() {
        return redirection;
    }

    public void setRedirection(String redirection) {
        this.redirection = redirection;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
}
