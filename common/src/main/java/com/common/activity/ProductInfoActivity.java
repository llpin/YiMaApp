package com.common.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.R;
import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.CodeOrderModel;
import com.common.pojo.ProductCodeModel;
import com.common.pojo.ProductModel;
import com.common.pojo.ProductPromiseModel;
import com.common.pojo.entity.Organization;

public class ProductInfoActivity extends BaseActivity implements BaseInter, View.OnClickListener {
    private final static String TAG = "ProductInfoActivity";
    private ProductCodeModel mProductCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        mProductCode =
                (ProductCodeModel) getIntent().getSerializableExtra(
                        getResources().getString(R.string.product_code_extra)
                );

        initForm();
    }

    @Override
    public void initForm() {
        try {
            CodeOrderModel order = mProductCode.getOrder();
            Organization factory = order.getFactory();
            ProductModel product = order.getProduct();
            ProductPromiseModel promise = product.getPromise();
            ((TextView)findViewById(R.id.name)).setText(product.getName());
            ((TextView)findViewById(R.id.function)).setText(product.getFunction());
            ((TextView)findViewById(R.id.description)).setText(product.getDescription());
            ((TextView)findViewById(R.id.promise)).setText(promise.getContent());
            ((TextView)findViewById(R.id.orgName)).setText(factory.getName());
            ((TextView)findViewById(R.id.orgPhone)).setText(factory.getTelephone());
            ((TextView)findViewById(R.id.orgAddress)).setText(factory.getAddress());
        }catch (Exception e){
            e.printStackTrace();
        }

        ((Button)findViewById(R.id.signButton)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.signButton) {
        }
    }
}
