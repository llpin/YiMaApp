package com.common.components;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.common.R;

/**
 * Created by linlipin on 18/5/14.
 */

public class MainToolbarLayout extends LinearLayout implements View.OnClickListener {

    private ImageButton btnShoppingBike;
    private Button btnCountTag;

    private int count = 0;

    public MainToolbarLayout(Context context, AttributeSet attrs) {

        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_toolbar_layout,this);

        initForm();
    }

    public void initForm(){
        btnShoppingBike = (ImageButton)findViewById(R.id.btn_shopping_bike);
        btnCountTag = (Button)findViewById(R.id.btn_number_tag);

        btnShoppingBike.setOnClickListener(this);
        btnCountTag.setOnClickListener(this);

        setCount(0);
    }

    public ImageButton getBtnShoppingBike() {
        return btnShoppingBike;
    }

    public Button getBtnCountTag() {
        return btnCountTag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count < 200 && count >= 0){
            this.count = count;
            if(count < 100){
                btnCountTag.setText(String.valueOf(count));
            }else {
                btnCountTag.setText(R.string.max_count_label);
            }
        }
        else {
            Snackbar.make(this, "商品件数不可大于200或小于0",Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_shopping_bike) {
            Snackbar.make(v, "shopping bike", Snackbar.LENGTH_SHORT).show();

        } else if (id == R.id.btn_number_tag) {
            Snackbar.make(v, "shopping bike", Snackbar.LENGTH_SHORT).show();

        } else {
        }
    }
}
