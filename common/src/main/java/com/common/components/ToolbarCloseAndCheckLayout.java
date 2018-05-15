package com.common.components;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.R;

/**
 * Created by linlipin on 18/5/14.
 */

public class ToolbarCloseAndCheckLayout extends RelativeLayout implements View.OnClickListener {
    private final static String TAG = "ToolbarCloseCheckLayout";

    private ImageButton closeBtn;
    private ImageButton checkBtn;
    private TextView titleTextView;

    public ToolbarCloseAndCheckLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.toolbar_close_and_check_layout, this);
        initForm();

//        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.zmaj_toolbar);
//        String text = ta.getString(R.styleable.zmaj_toolbar_text);
//        ta.recycle();
//        titleTextView.setText(text);
    }

    public void initForm(){
        closeBtn = (ImageButton)findViewById(R.id.btn_close);
        closeBtn.setOnClickListener(this);

        checkBtn = (ImageButton)findViewById(R.id.btn_check);
        checkBtn.setOnClickListener(this);

        titleTextView = (TextView)findViewById(R.id.text_view_title);
    }

    public ImageButton getCloseBtn() {
        return closeBtn;
    }

    public ImageButton getCheckBtn() {
        return checkBtn;
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_close) {
            Log.d(TAG, "title");
            ((Activity) getContext()).finish();

        } else if (id == R.id.btn_check) {
            Log.d(TAG, "check");

        } else {
        }
    }
}
