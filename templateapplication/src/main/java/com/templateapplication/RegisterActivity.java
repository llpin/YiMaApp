package com.templateapplication;

import android.content.Intent;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.templateapplication.components.ToolbarCloseAndCheckLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = "RegisterActivity";

    private ToolbarCloseAndCheckLayout toolbarCloseAndCheckLayout;

    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText passwordTwiceEditText;
    private TextInputEditText mobilephoneEditText;
    private TextInputEditText identifyingCodeEditText;
    private Button identifyingCodeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        initForm();
    }

    public void initForm(){
        toolbarCloseAndCheckLayout =
                (ToolbarCloseAndCheckLayout)findViewById(R.id.toolbar_close_check_layout);
        toolbarCloseAndCheckLayout.getCloseBtn().setOnClickListener(this);
        toolbarCloseAndCheckLayout.getCheckBtn().setOnClickListener(this);

        //修改标题
        toolbarCloseAndCheckLayout.setTitle(getString(R.string.register_title));

        usernameEditText = (TextInputEditText)findViewById(R.id.text_input_username);
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
        switch (id){
            case R.id.btn_close:
                Log.d(TAG, "close");
                Snackbar.make(v, "取消注册!", Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Log.d(TAG, String.valueOf(event));
                        RegisterActivity.this.finish();
                    }
                }).show();
                break;
            case R.id.btn_check:
                Log.d(TAG, "check");
                Snackbar.make(v, "注册成功!", Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                }).show();
                break;
            case R.id.btn_identifying_code:
                Snackbar.make(v, "获取验证码失败!", Snackbar.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
