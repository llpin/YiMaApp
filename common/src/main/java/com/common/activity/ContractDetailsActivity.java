package com.common.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.common.R;
import com.common.components.ToolbarBackLayout;

public class ContractDetailsActivity extends AppCompatActivity {

    private ToolbarBackLayout toolbarBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_details);
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
