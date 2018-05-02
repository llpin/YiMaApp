package com.common.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.R;
import com.common.activity.ContractActivity;
import com.common.pojo.ProductContract;
import com.common.utils.DateUtil;

import java.util.List;

/**
 * Created by linlipin on 18/3/9.
 */

public class ProductContractAdapter extends RecyclerView.Adapter<ProductContractAdapter.ViewHolder > {
    private List<ProductContract> mProductContractList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView createTimeTextView;
        public TextView contractTitleTextView;
        public View contractPartView;

        public ViewHolder(View v) {
            super(v);
            contractPartView = v;
            createTimeTextView = (TextView)v.findViewById(R.id.createTime);
            contractTitleTextView = (TextView)v.findViewById(R.id.contractTitle);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)


    public ProductContractAdapter(List<ProductContract> productContractList) {
        this.mProductContractList = productContractList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductContractAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent,
                                                                int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contract_part_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        final ViewHolder vh = new ViewHolder(v);

        vh.contractPartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                ProductContract productContract = mProductContractList.get(position);
//                TODO start ContractActivity intent
                Intent intent = new Intent(parent.getContext(), ContractActivity.class);
                intent.putExtra(
                        parent.getResources().getString(R.string.contract_entity_extra),
                        productContract);
                parent.getContext().startActivity(intent);

            }
        });

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ProductContract contract = mProductContractList.get(position);
        try {
            holder.createTimeTextView.setText(DateUtil.formatDate(contract.getCreateTime()));
            holder.contractTitleTextView.setText(contract.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mProductContractList.size();
    }
}



