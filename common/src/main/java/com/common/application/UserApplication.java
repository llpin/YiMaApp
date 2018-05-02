package com.common.application;

import android.app.Application;

//import com.common.handler.CrashHandler;
import com.common.pojo.UserVo;

/**
 * Created by linlipin on 18/3/2.
 */

public class UserApplication extends Application {
    private UserVo userVo;

    @Override
    public void onCreate(){
        super.onCreate();
//        CrashHandler.getInstance().init(this);
    }
    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

}
