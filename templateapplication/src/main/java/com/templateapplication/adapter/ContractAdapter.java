package com.templateapplication.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.templateapplication.ContractDetailsActivity;
import com.templateapplication.R;

import java.util.List;

/**
 * Created by linlipin on 18/5/15.
 */

public class ContractAdapter extends RecyclerView.Adapter<ContractAdapter.ViewHolder> {

    private final static String TAG = "ContractAdapter";

    private List<Drawable> drawableList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContractAdapter(List<Drawable> drawableList) {
        this.drawableList = drawableList;
    }

    @Override
    public ContractAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contract_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        final ContractAdapter.ViewHolder vh = new ContractAdapter.ViewHolder(v);

        vh.contractView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                Log.d(TAG, String.valueOf(position));
                Intent intent = new Intent(parent.getContext(), ContractDetailsActivity.class);
                parent.getContext().startActivity(intent);
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ContractAdapter.ViewHolder holder, int position) {
        Drawable drawable = drawableList.get(position);
        try {
            holder.imageView.setBackground(drawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return drawableList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        public View contractView;

        public ViewHolder(View v) {
            super(v);
            contractView = v;
            imageView = (ImageView) v.findViewById(R.id.image_view_seal);
        }
    }
}
