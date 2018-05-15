package com.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.R;
import com.common.components.ToolbarTitleLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText userNameEditText;
    private TextInputEditText passwordEditText;
    private TextView forgetTextView;
    private Button submitBtn;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        initForm();
    }

    protected void initForm(){

        ToolbarTitleLayout toolbarTitleLayout =
                (ToolbarTitleLayout)findViewById(R.id.toolbar_title_layout);
        toolbarTitleLayout.setTitle(getString(R.string.app_name));

        userNameEditText = (TextInputEditText)findViewById(R.id.text_input_username);
        passwordEditText = (TextInputEditText)findViewById(R.id.text_input_password);

        //忘记密码
        forgetTextView = (TextView)findViewById(R.id.textview_forget_password);
        forgetTextView.setOnClickListener(this);

        //登录
        submitBtn = (Button)findViewById(R.id.btn_submit);
        submitBtn.setOnClickListener(this);

        //注册
        registerTextView = (TextView)findViewById(R.id.textview_register);
        registerTextView.setOnClickListener(this);
    }

    public String getUsername(){
        return userNameEditText.getText().toString();
    }

    public String getPassword(){
        return passwordEditText.getText().toString();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.textview_register) {
            startActivity(new Intent(this, RegisterActivity.class));

        } else if (id == R.id.textview_forget_password) {//                Toast.makeText(this,"forget password",Toast.LENGTH_SHORT).show();
            Snackbar.make(v, "重置密码!", Snackbar.LENGTH_SHORT).addCallback(
                    new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                        @Override
                        public void onDismissed(Snackbar transientBottomBar, int event) {
                            super.onDismissed(transientBottomBar, event);
                            startActivity(new Intent(LoginActivity.this, RestPasswordActivity.class));
                        }
                    }).show();

        } else if (id == R.id.btn_submit) {//                Toast.makeText(this,"submit",Toast.LENGTH_SHORT).show();
            Snackbar.make(v, "登录中!", Snackbar.LENGTH_SHORT).addCallback(
                    new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                        @Override
                        public void onDismissed(Snackbar transientBottomBar, int event) {
                            super.onDismissed(transientBottomBar, event);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                    }).show();

        } else {
        }
    }
}
