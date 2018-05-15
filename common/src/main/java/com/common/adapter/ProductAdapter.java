package com.common.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.common.R;

import java.util.List;

/**
 * Created by linlipin on 18/5/15.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private final static String TAG = "ProductAdapter";

    private List<Drawable> drawableList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductAdapter(List<Drawable> drawableList) {
        this.drawableList = drawableList;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        final ProductAdapter.ViewHolder vh = new ProductAdapter.ViewHolder(v);

        vh.productView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                Log.d(TAG, String.valueOf(position));
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
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
        public View productView;

        public ViewHolder(View v) {
            super(v);
            productView = v;
            imageView = (ImageView) v.findViewById(R.id.image_view_seal);
        }
    }
}
