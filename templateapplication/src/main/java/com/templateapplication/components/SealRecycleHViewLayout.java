package com.templateapplication.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.templateapplication.R;
import com.templateapplication.adapter.SealAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlipin on 18/5/14.
 */

public class SealRecycleHViewLayout extends LinearLayout {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private List<Drawable> drawableList = new ArrayList<>();

    public SealRecycleHViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.seal_recycler_h_view_layout, this);

        initForm();
    }

    public void initForm(){
        recyclerView = (RecyclerView) findViewById(R.id.seal_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerViewLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        drawableList.add(getResources().getDrawable(R.mipmap.seal_success, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_unkown, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_selled, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_has_identified, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_not_identifying, null));

        SealAdapter adapter = new SealAdapter(drawableList);
        recyclerView.setAdapter(adapter);
    }
}
