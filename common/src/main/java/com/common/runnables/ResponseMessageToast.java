package com.common.runnables;

import android.content.Context;

import com.common.pojo.params.ResultModel;
import com.common.utils.ToastUtil;

/**
 * Created by linlipin on 18/3/1.
 */

public class ResponseMessageToast implements Runnable {
    private ResultModel resultResponse;
    private Context ct;

    public ResponseMessageToast(ResultModel resultResponse, Context ct) {
        this.resultResponse = resultResponse;
        this.ct = ct;
    }

    @Override
    public void run() {
        ToastUtil.showLong(ct, resultResponse.getMessage());
    }
}
