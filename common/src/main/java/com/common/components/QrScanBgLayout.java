package com.common.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.common.R;

/**
 * Created by linlipin on 18/5/14.
 */

public class QrScanBgLayout extends LinearLayout {
    public QrScanBgLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.qr_scan_bg_layout,this);

        initForm();
    }

    public void initForm(){

    }
}
