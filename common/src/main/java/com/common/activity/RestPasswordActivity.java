package com.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.common.R;
import com.common.components.ToolbarCloseAndCheckLayout;

public class RestPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "RestPasswordActivity";

    private ToolbarCloseAndCheckLayout toolbarCloseAndCheckLayout;

    private TextInputEditText passwordEditText;
    private TextInputEditText passwordTwiceEditText;
    private TextInputEditText mobilephoneEditText;
    private TextInputEditText identifyingCodeEditText;
    private Button identifyingCodeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_password);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        initForm();
    }

    protected void initForm(){
        toolbarCloseAndCheckLayout =
                (ToolbarCloseAndCheckLayout)findViewById(R.id.toolbar_title_layout);
        toolbarCloseAndCheckLayout.setTitle("重置密码");

        toolbarCloseAndCheckLayout.getCloseBtn().setOnClickListener(this);
        toolbarCloseAndCheckLayout.getCheckBtn().setOnClickListener(this);

        passwordEditText = (TextInputEditText)findViewById(R.id.text_input_password);
        passwordTwiceEditText = (TextInputEditText)findViewById(R.id.text_input_password_twice);
        mobilephoneEditText = (TextInputEditText)findViewById(R.id.text_input_mobilephone);
        identifyingCodeEditText = (TextInputEditText)findViewById(R.id.text_input_identifying_code);
        identifyingCodeBtn = (Button)findViewById(R.id.btn_identifying_code);
        identifyingCodeBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_close) {
            Log.d(TAG, "close");
            Snackbar.make(v, "取消密码重置!", Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                @Override
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    super.onDismissed(transientBottomBar, event);
                    Log.d(TAG, String.valueOf(event));
                    RestPasswordActivity.this.finish();
                }
            }).show();

        } else if (id == R.id.btn_check) {
            Log.d(TAG, "check");
            Snackbar.make(v, "密码重置成功!", Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                @Override
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    super.onDismissed(transientBottomBar, event);
                    startActivity(new Intent(RestPasswordActivity.this, LoginActivity.class));
                }
            }).show();

        } else if (id == R.id.btn_identifying_code) {
            Snackbar.make(v, "获取验证码失败!", Snackbar.LENGTH_SHORT).show();

        } else {
        }
    }
}
