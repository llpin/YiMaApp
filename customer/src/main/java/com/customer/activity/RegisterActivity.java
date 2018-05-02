package com.customer.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.base.enums.IndividualTypeEnum;
import com.common.base.enums.PlatformMainTypeEnum;
import com.common.interfaces.BaseInter;
import com.common.pojo.request.IndividualRequest;
import com.common.pojo.request.UserRequest;
import com.common.utils.L;
import com.common.utils.OkHttpUtil;
import com.customer.R;

public class RegisterActivity extends BaseActivity implements BaseInter,View.OnClickListener {
    private TextInputEditText mUserNameInput;
    private TextInputEditText mPasswordInput;
    private TextInputEditText mDoPasswordInput;
    private TextView nextTextView;

    final static String TAG = "RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initForm();

        String url = getApiBaseUrl();
        if(url !=null){
            L.d(TAG,url);
            OkHttpUtil.setBaseUrl(getApiBaseUrl());
        }
    }


    @Override
    public void initForm() {
        mUserNameInput = (TextInputEditText) findViewById(R.id.username);
        mPasswordInput = (TextInputEditText) findViewById(R.id.password);
        mDoPasswordInput = (TextInputEditText) findViewById(R.id.doPassword);
        nextTextView = (TextView) findViewById(R.id.nextTextView);

        nextTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.nextTextView) {
            UserRequest userRequest = new UserRequest();
            userRequest.setUsername(
                    mUserNameInput.getText().toString()
            );
            userRequest.setPassword(
                    mPasswordInput.getText().toString()
            );
            userRequest.setDoPassword(
                    mDoPasswordInput.getText().toString()
            );
            userRequest.setPlatformMainTypeEnum(
                    PlatformMainTypeEnum.INDIVIDUAL);
            IndividualRequest individualRequest = new IndividualRequest();
            individualRequest.setUser(userRequest);
            individualRequest.setIndividualTypeEnum(IndividualTypeEnum.CUSTOMER);
            Intent intent = new Intent(RegisterActivity.this, IndividualActivity.class);
            intent.putExtra(
                    getResources().getString(R.string.individual_extra),
                    individualRequest);
            startActivity(intent);


        } else {
        }
    }
}
