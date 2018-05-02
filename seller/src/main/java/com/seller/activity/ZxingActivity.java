package com.seller.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.common.base.BaseActivity;
import com.common.interfaces.ZxingInter;
import com.common.runnables.ResponseActivity;

/**
 * Created by linlipin on 18/1/3.
 */

public class ZxingActivity extends BaseActivity implements ZxingInter {
    private final static String TAG = "ZxingActivity";

    public final static int CUSTOMIZED_REQUEST_CODE = 0x0000ffff;

//    @Override
//    public void zxingInit() {
//        ZXingLibrary.initDisplayOpinion(this);
//    }

    @Override
    public void startCaptureActivityWithContractId(Activity activity, Long contractId) {
        Intent intent = getCaptureIntentWithContractId(contractId);
        startActivity(intent);
    }

    @NonNull
    private Intent getCaptureIntentWithContractId(Long contractId) {
        Intent intent = new Intent(this, ContinuousCaptureActivity.class);
        intent.putExtra(getResources().getString(R.string.contract_id_extra),contractId);
        return intent;
    }


    @Override
    public void startCaptureActivityWithContractIdRunnable(Activity activity, Long contractId) {
        Intent intent = getCaptureIntentWithContractId(contractId);
        runOnUiThread(new ResponseActivity(activity, intent));
    }

    @Override
    public void startCaptureActivity(Activity activity) {
        Intent intent = new Intent(this, ContinuousCaptureActivity.class);
        startActivity(intent);
    }

    @Override
    public void startCaptureActivityRunnable(Activity activity) {
        Intent intent = new Intent(this, ContinuousCaptureActivity.class);
        runOnUiThread(new ResponseActivity(activity, intent));
    }

}
