package com.customer.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.interfaces.LoginInter;
import com.common.pojo.result.LoginResult;
import com.common.pojo.request.UserRequest;
import com.common.runnables.MessageToast;
import com.common.runnables.ResponseMessageToast;
import com.common.utils.ActivityUtil;
import com.common.utils.GsonUtil;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;
import com.common.utils.OkHttpUtil;
import com.customer.R;
import com.facebook.stetho.Stetho;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends BaseActivity implements LoginInter, View.OnClickListener {

    private final static String TAG = "LoginActivity";

    private Button loginButton;
    private TextInputEditText userNameInput;
    private TextInputEditText passwordInput;
    private TextInputEditText serverIpInput;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Stetho.initializeWithDefaults(this);

        initForm();
    }


    @Override
    public void initForm() {
        setLoginButton((Button) findViewById(R.id.login_button));
        getLoginButton().setOnClickListener(this);

        setUserNameInput((TextInputEditText) findViewById(R.id.login_username));
        setPasswordInput((TextInputEditText) findViewById(R.id.login_password));
        setServerIpInput((TextInputEditText) findViewById(R.id.server_ip));

        setRegisterTextView((TextView) findViewById(R.id.registerTextView));
        getRegisterTextView().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                String server_ip = getServerIpInput().getText().toString();
                if(!server_ip.isEmpty()){
                    OkHttpUtil.setBaseUrl("http://" + server_ip);
                }else {
                    String url = getApiBaseUrl();
                    if(url !=null){
                        L.d(TAG,url);
                        OkHttpUtil.setBaseUrl(getApiBaseUrl());
                    }
                }

                login(getUserNameInput().getText().toString(),
                        getPasswordInput().getText().toString());
                break;
            case R.id.registerTextView:
                ActivityUtil.startActivitySimple(LoginActivity.this, RegisterActivity.class);
                break;
            default:
                break;
        }
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public TextInputEditText getUserNameInput() {
        return userNameInput;
    }

    public void setUserNameInput(TextInputEditText userNameInput) {
        this.userNameInput = userNameInput;
    }

    public TextInputEditText getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(TextInputEditText passwordInput) {
        this.passwordInput = passwordInput;
    }

    public TextInputEditText getServerIpInput() {
        return serverIpInput;
    }

    public void setServerIpInput(TextInputEditText serverIpInput) {
        this.serverIpInput = serverIpInput;
    }

    public TextView getRegisterTextView() {
        return registerTextView;
    }

    public void setRegisterTextView(TextView registerTextView) {
        this.registerTextView = registerTextView;
    }

    @Override
    public void login(String username, String password) {
        L.d(TAG,username+":"+password);
        UserRequest user = new UserRequest();
        user.setUsername(username);
        user.setPassword(password);
//        user.setUsername("customer1");
//        user.setPassword("123456");
        if (isTestModel()){
//            测试环境，直接跳转
//            getUserApplication().setSimpleUser(user);
//            User testUser = getUserApplication().getSimpleUser();
//            L.d(TAG, testUser.getUsername());
            ActivityUtil.startActivitySimple(LoginActivity.this,MainActivity.class);

        }else {
            HttpApiUtil.login(
                    user,
                    new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                            MessageToast messageToast = new MessageToast(LoginActivity.this, e.getMessage());
                            runOnUiThread(messageToast);
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
//                            String ret = response.body().string();
//                            L.d(TAG, ret);
                            LoginResult loginResultResponse = GsonUtil.fromResponse(response, LoginResult.class);

                            runOnUiThread(new ResponseMessageToast(loginResultResponse, LoginActivity.this));

                            if(loginResultResponse.getCode().compareTo("200") == 0){
                                getUserApplication().setUserVo(loginResultResponse.getParams().getUserVo());
                                ActivityUtil.startActivitySimple(LoginActivity.this,MainActivity.class);
                            }
                        }
                    });
        }
    }
}
