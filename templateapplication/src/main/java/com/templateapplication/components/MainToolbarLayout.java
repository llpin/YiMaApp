package com.templateapplication.components;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.templateapplication.R;

/**
 * Created by linlipin on 18/5/14.
 */

public class MainToolbarLayout extends LinearLayout implements View.OnClickListener {

    private ImageButton btnShoppingBike;
    private Button btnNumberTag;

    private int number = 0;

    public MainToolbarLayout(Context context, AttributeSet attrs) {

        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.main_toolbar_layout,this);

        initForm();
    }

    public void initForm(){
        btnShoppingBike = (ImageButton)findViewById(R.id.btn_shopping_bike);
        btnNumberTag = (Button)findViewById(R.id.btn_number_tag);

        btnShoppingBike.setOnClickListener(this);
        btnNumberTag.setOnClickListener(this);

        setNumber(0);
    }

    public ImageButton getBtnShoppingBike() {
        return btnShoppingBike;
    }

    public Button getBtnNumberTag() {
        return btnNumberTag;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if(number < 200 && number >= 0){
            this.number = number;
            if(number < 100){
                btnNumberTag.setText(String.valueOf(number));
            }else {
                btnNumberTag.setText("99+");
            }
        }
        else {
            Snackbar.make(this, "商品件数不可大于200或小于0",Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_shopping_bike:
                Snackbar.make(v,"shopping bike",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.btn_number_tag:
                Snackbar.make(v,"shopping bike",Snackbar.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
