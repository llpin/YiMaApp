package com.templateapplication.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.templateapplication.R;

/**
 * Created by linlipin on 18/5/13.
 */

public class HeadlineLayout16_9 extends RelativeLayout {
    public HeadlineLayout16_9(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.headline_layout16_9, this);
    }
}
