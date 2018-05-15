package com.common.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.common.R;

import java.util.List;

/**
 * Created by linlipin on 18/5/14.
 */

public class SealAdapter extends RecyclerView.Adapter<SealAdapter.ViewHolder> {

    private List<Drawable> drawableList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public SealAdapter(List<Drawable> drawableList) {
        this.drawableList = drawableList;
    }

    @Override
    public SealAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.seal_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SealAdapter.ViewHolder holder, int position) {
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

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        public View sealView;

        public ViewHolder(View v) {
            super(v);
            sealView = v;
            imageView = (ImageView) v.findViewById(R.id.image_view);
        }
    }
}
