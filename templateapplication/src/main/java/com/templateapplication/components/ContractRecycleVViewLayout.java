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
import com.templateapplication.adapter.ContractAdapter;
import com.templateapplication.adapter.SealAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linlipin on 18/5/15.
 */

public class ContractRecycleVViewLayout extends LinearLayout {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private List<Drawable> drawableList = new ArrayList<>();

    public ContractRecycleVViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.contract_recycle_v_view_layout, this);

        initForm();
    }

    public void initForm(){
        recyclerView = (RecyclerView) findViewById(R.id.contract_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerViewLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        drawableList.add(getResources().getDrawable(R.mipmap.seal_success_in_card, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_unkown_in_card, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_has_selled_in_card, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_has_identified_in_card, null));
        drawableList.add(getResources().getDrawable(R.mipmap.seal_not_identifying_in_card, null));

        ContractAdapter adapter = new ContractAdapter(drawableList);
        recyclerView.setAdapter(adapter);
    }
}
