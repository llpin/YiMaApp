package com.common.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.common.R;
import com.common.components.ToolbarBackLayout;

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
        toolbarBackLayout.setTitle(getString(R.string.toolbar_title_label_mine_info));

        usernamrEditText = (TextInputEditText)findViewById(R.id.text_input_username);
        usernamrEditText.setText(R.string.username_default);
        usernamrEditText.setKeyListener(null);

        mobilephoneEditText = (TextInputEditText)findViewById(R.id.text_input_mobilephone);
        mobilephoneEditText.setText(R.string.mobielphone_default);
        mobilephoneEditText.setKeyListener(null);
    }
}
