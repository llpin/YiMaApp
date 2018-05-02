package com.customer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.IndividualRegisterResult;
import com.common.pojo.params.ResultModel;
import com.common.pojo.request.IndividualRequest;
import com.common.runnables.MessageToast;
import com.common.runnables.ResponseActivity;
import com.common.utils.GsonUtil;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;
import com.customer.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MobilePhoneActivity extends BaseActivity implements BaseInter, View.OnClickListener {
    private final static String TAG = "MobilePhoneActivity";
    TextInputEditText mMobilePhone;
    TextInputEditText mVerifyCode;

    private IndividualRequest mIndividualRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_phone);

        mIndividualRequest =
                (IndividualRequest) getIntent().getSerializableExtra(
                        getResources().getString(R.string.individual_extra)
                );

        initForm();
    }

    @Override
    public void initForm() {
        mMobilePhone = (TextInputEditText) findViewById(R.id.telephone);
        mVerifyCode = (TextInputEditText) findViewById(R.id.verifyCode);
        ((Button) findViewById(R.id.verifyButton)).setOnClickListener(this);
        ((Button) findViewById(R.id.submitButton)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.verifyButton) {
            String mobilePhone = mMobilePhone.getText().toString();
            HttpApiUtil.getVerifyCode(mobilePhone, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    L.d(TAG, response.body().toString());
                }
            });

        } else if (id == R.id.submitButton) {
            final String mobilePhone = mMobilePhone.getText().toString();
            final String verifyCode = mVerifyCode.getText().toString();
            HttpApiUtil.verifyCode(mobilePhone, verifyCode, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    L.d(TAG, response.body().toString());

                    try {
                        ResultModel resultResponse =
                                GsonUtil.fromResponse(response, ResultModel.class);
                        if (resultResponse.getCode().compareTo("200") != 0) {
                            runOnUiThread(new MessageToast(MobilePhoneActivity.this,
                                    resultResponse.getMessage()));
                            L.d(TAG, resultResponse.getMessage());
                        } else {
                            mIndividualRequest.setMobilePhone(mobilePhone);
                            mIndividualRequest.setVerifyCode(verifyCode);
//                            注册
                            HttpApiUtil.register(mIndividualRequest, new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                    e.printStackTrace();
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    IndividualRegisterResult registerResponse =
                                            GsonUtil.fromResponse(response, IndividualRegisterResult.class);
                                    try {
                                        runOnUiThread(new MessageToast(MobilePhoneActivity.this,
                                                registerResponse.getMessage()));
                                        if (registerResponse.getCode().compareTo("200") == 0) {
//                                        跳转登录页
                                            runOnUiThread(new ResponseActivity(MobilePhoneActivity.this,
                                                    new Intent(MobilePhoneActivity.this, LoginActivity.class)));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } else {
        }
    }
}
