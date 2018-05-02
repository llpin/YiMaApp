package com.common.interfaces;


import android.app.Activity;
import android.content.Intent;

/**
 * Created by linlipin on 18/1/3.
 */

public interface ZxingInter {
    void startCaptureActivityWithContractId(Activity activity, Long contractId);
    void startCaptureActivityWithContractIdRunnable(Activity activity, Long contractId);

    void startCaptureActivity(Activity activity);
    void startCaptureActivityRunnable(Activity activity);
}
