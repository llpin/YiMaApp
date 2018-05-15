package com.common.components;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.common.R;

/**
 * Created by linlipin on 18/5/13.
 */

public class ToolbarBackLayout extends LinearLayout implements View.OnClickListener{
    private final String TAG = "ToolbarBackLayout";
    private TextView titleTextView;
    private ImageButton btnBack;

    public ToolbarBackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.toolbar_back_layout, this);

        initForm();
    }

    public void initForm(){
        titleTextView = (TextView)findViewById(R.id.text_view_title);

        btnBack = (ImageButton)findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
    }

    public TextView getTitleTextView(){
        return titleTextView;
    }

    public String getTitle(){
        return titleTextView.getText().toString();
    }

    public void setTitle(String title){
        titleTextView.setText(title);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.text_view_title) {
            Log.d(TAG, "title");

        } else if (id == R.id.btn_back) {
            Log.d(TAG, "back");
            ((Activity) getContext()).finish();

        } else {
        }
    }
}
