package com.common.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.R;

/**
 * Created by linlipin on 18/5/12.
 */

public class ToolbarTitleLayout extends LinearLayout {

    private TextView titleTextView;

    public ToolbarTitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.toolbar_title_layout, this);

        initForm();
    }

    public void initForm(){
        titleTextView = (TextView)findViewById(R.id.text_view_title);
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public String getTitle(){
        return titleTextView.getText().toString();
    }

    public void setTitle(String title){
        titleTextView.setText(title);
    }
}
