package com.templateapplication;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.templateapplication.components.ToolbarBackLayout;

public class MineInfoActivity extends AppCompatActivity {

    private ToolbarBackLayout toolbarBackLayout;

    private TextInputEditText usernamrEditText;
    private TextInputEditText mobilephoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_info);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        initForm();
    }

    private void initForm(){
        toolbarBackLayout = (ToolbarBackLayout)findViewById(R.id.toolbar_back_layout);
        toolbarBackLayout.setTitle("个人信息");

        usernamrEditText = (TextInputEditText)findViewById(R.id.text_input_username);
        usernamrEditText.setText("zhangsan");
        usernamrEditText.setKeyListener(null);

        mobilephoneEditText = (TextInputEditText)findViewById(R.id.text_input_mobilephone);
        mobilephoneEditText.setText("13515818134");
        mobilephoneEditText.setKeyListener(null);
    }
}
