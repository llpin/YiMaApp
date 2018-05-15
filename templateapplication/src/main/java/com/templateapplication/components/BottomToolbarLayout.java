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

public class BottomToolbarLayout extends RelativeLayout implements View.OnClickListener{

    private ImageButton btnClear;
    private ImageButton btnScan;
    private ImageButton btnSubmit;

    public BottomToolbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bottom_toolbar_layout, this);

        initForm();
    }

    public void initForm(){
        btnClear = (ImageButton)findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);

        btnScan = (ImageButton)findViewById(R.id.btn_scan);
        btnScan.setOnClickListener(this);

        btnSubmit = (ImageButton)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    public ImageButton getBtnClear() {
        return btnClear;
    }

    public ImageButton getBtnScan() {
        return btnScan;
    }

    public ImageButton getBtnSubmit() {
        return btnSubmit;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_clear:
                Snackbar.make(v, "clear", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.btn_scan:
                Snackbar.make(v, "scan", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.btn_submit:
                Snackbar.make(v, "submit", Snackbar.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
