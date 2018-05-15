package com.templateapplication.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.templateapplication.R;

/**
 * Created by linlipin on 18/5/15.
 */

public class ContractPreviewCardLayout extends LinearLayout {
    public ContractPreviewCardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.contract_preview_card_layout, this);

        initForm();
    }

    public void initForm(){

    }
}
