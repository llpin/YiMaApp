package com.templateapplication.components;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.templateapplication.R;

/**
 * Created by linlipin on 18/5/14.
 */

public class MainToolbarHeadlineLayout extends RelativeLayout implements View.OnClickListener {

    private ImageButton btnQrScan;
    private ImageButton btnPersonInfo;
    private ImageButton btnContractList;

    public MainToolbarHeadlineLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_toolbar_headline_layout, this);

        initForm();
    }

    public void initForm(){
        btnQrScan = (ImageButton)findViewById(R.id.btn_qr_scan);
        btnPersonInfo = (ImageButton)findViewById(R.id.btn_person_info);
        btnContractList = (ImageButton)findViewById(R.id.btn_contract_list);

        btnQrScan.setOnClickListener(this);
        btnPersonInfo.setOnClickListener(this);
        btnContractList.setOnClickListener(this);
    }

    public ImageButton getBtnQrScan() {
        return btnQrScan;
    }

    public ImageButton getBtnPersonInfo() {
        return btnPersonInfo;
    }

    public ImageButton getBtnContractList() {
        return btnContractList;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_qr_scan:
                Snackbar.make(v,"scan",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.btn_person_info:
                Snackbar.make(v,"person",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.btn_contract_list:
                Snackbar.make(v,"contract",Snackbar.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
