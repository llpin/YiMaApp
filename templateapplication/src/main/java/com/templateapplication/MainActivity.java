package com.templateapplication;

import android.content.Intent;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.templateapplication.components.BottomToolbarLayout;
import com.templateapplication.components.MainToolbarHeadlineLayout;
import com.templateapplication.components.MainToolbarLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainToolbarHeadlineLayout mainToolbarHeadlineLayout;
    private MainToolbarLayout mainToolbarLayout;
    private BottomToolbarLayout bottomToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        initForm();
    }

    public MainToolbarHeadlineLayout getMainToolbarHeadlineLayout() {
        return mainToolbarHeadlineLayout;
    }

    public MainToolbarLayout getMainToolbarLayout() {
        return mainToolbarLayout;
    }

    public BottomToolbarLayout getBottomToolbarLayout() {
        return bottomToolbarLayout;
    }

    public void initForm(){
        mainToolbarHeadlineLayout =
                (MainToolbarHeadlineLayout)findViewById(R.id.main_toolbar_headline_layout);
        mainToolbarLayout = (MainToolbarLayout)findViewById(R.id.main_toolbar_layout);

        bottomToolbarLayout = (BottomToolbarLayout)findViewById(R.id.bottom_toolbar_layout);

        mainToolbarHeadlineLayout.getBtnQrScan().setOnClickListener(this);
        mainToolbarHeadlineLayout.getBtnPersonInfo().setOnClickListener(this);
        mainToolbarHeadlineLayout.getBtnContractList().setOnClickListener(this);

        mainToolbarLayout.getBtnShoppingBike().setOnClickListener(this);
        mainToolbarLayout.getBtnNumberTag().setOnClickListener(this);

        bottomToolbarLayout.getBtnClear().setOnClickListener(this);
        bottomToolbarLayout.getBtnScan().setOnClickListener(this);
        bottomToolbarLayout.getBtnSubmit().setOnClickListener(this);

    }

    public void addNumber(){
        int num = mainToolbarLayout.getNumber();
        mainToolbarLayout.setNumber(num + 1);
    }

    public void clearNumber(){
        mainToolbarLayout.setNumber(0);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_qr_scan:
            case R.id.btn_scan:
                Snackbar.make(v, "main scan", Snackbar.LENGTH_SHORT).show();
                addNumber();
                break;
            case R.id.btn_person_info:
                Snackbar.make(v, "main person info", Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        startActivity(new Intent(MainActivity.this, MineInfoActivity.class));
                    }
                }).show();
                break;
            case R.id.btn_contract_list:
                Snackbar.make(v, "main contract list", Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        startActivity(new Intent(MainActivity.this, ContractListActivity.class));
                    }
                }).show();
                break;
            case R.id.btn_shopping_bike:
            case R.id.btn_number_tag:
                Snackbar.make(v, "main shopping bike", Snackbar.LENGTH_SHORT).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        startActivity(new Intent(MainActivity.this, ContractPreviewActivity.class));
                    }
                }).show();
                break;
            case R.id.btn_clear:
                Snackbar.make(v, "main clear", Snackbar.LENGTH_SHORT).show();
                clearNumber();
                break;
            case R.id.btn_submit:
                Snackbar.make(v, "main submit", Snackbar.LENGTH_SHORT).show();
                clearNumber();
                break;
            default:
                break;
        }
    }
}
