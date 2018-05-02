package com.common.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.common.R;
import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.ProductContract;
import com.common.pojo.entity.User;
import com.common.utils.DateUtil;

public class ContractActivity extends BaseActivity implements BaseInter {
    ProductContract productContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        productContract = (ProductContract)getIntent().getSerializableExtra(
                getResources().getString(R.string.contract_entity_extra));

        initForm();
    }

    @Override
    public void initForm() {
        try {
            ProductContract productContract = getProductContract();

//            ((TextView)findViewById(R.id.signTime)).setText(
//                    DateUtil.formatDate(productContract.getCreateTime()));

            ((TextView)findViewById(R.id.cno)).setText(productContract.getCno());

            ((TextView)findViewById(R.id.createTime)).setText(
                    DateUtil.formatDate(productContract.getCreateTime()));

            ((TextView)findViewById(R.id.title)).setText(productContract.getTitle());

            ((TextView)findViewById(R.id.content)).setText(productContract.getContent());

            if(productContract.getEmployeeHasSign()){
                User draftUser = productContract.getEmployeePart().getEmployee().getUser();
                ((TextView)findViewById(R.id.draftUser)).setText(draftUser.getUsername());
            }

            if(productContract.getIndividualHasSign()){
                User customer = productContract.getIndividualPart().getIndividual().getUser();
                ((TextView)findViewById(R.id.customerUser)).setText(customer.getUsername());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductContract getProductContract() {
        return productContract;
    }

    public void setProductContract(ProductContract productContract) {
        this.productContract = productContract;
    }
}
