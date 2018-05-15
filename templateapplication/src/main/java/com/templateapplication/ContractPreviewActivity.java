package com.templateapplication;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.templateapplication.components.ToolbarBackLayout;

public class ContractPreviewActivity extends AppCompatActivity {

    private ToolbarBackLayout toolbarBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_preview);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        initForm();
    }

    public void initForm(){
        toolbarBackLayout = (ToolbarBackLayout)findViewById(R.id.toolbar_back_layout);
        toolbarBackLayout.setTitle("合约详情");

    }
}
