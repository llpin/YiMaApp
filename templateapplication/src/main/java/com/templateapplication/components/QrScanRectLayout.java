package com.templateapplication.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.templateapplication.R;

/**
 * Created by linlipin on 18/5/14.
 */

public class QrScanRectLayout extends RelativeLayout {
    public QrScanRectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.qr_scan_rect_layout,this);

        initForm();
    }

    public void initForm(){

    }
}
