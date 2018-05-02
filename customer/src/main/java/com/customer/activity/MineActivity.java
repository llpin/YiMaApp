package com.customer.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.entity.Individual;
import com.common.pojo.UserVo;
import com.customer.R;

public class MineActivity extends BaseActivity implements BaseInter {
    Individual mIndividual;

    TextView mUsernameText;
    TextView mUsertypeText;
    TextView mName;
    TextView mMobilePhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        try{
            UserVo user = getUserApplication().getUserVo();
            if(user != null)
                mIndividual = user.getIndividual();
        }catch (Exception e){
            e.printStackTrace();
        }


        initForm();
    }

    @Override
    public void initForm() {
        if(mIndividual != null){
            try{
                mUsernameText = (TextView)findViewById(R.id.username);
                mUsertypeText = (TextView)findViewById(R.id.usertype);
                mName = (TextView)findViewById(R.id.name);
                mMobilePhone = (TextView)findViewById(R.id.mobilePhone);

                mUsernameText.setText(mIndividual.getUser().getUsername());
                mUsertypeText.setText(mIndividual.getUser().getPlatformMainType().getName());
                mName.setText(mIndividual.getName());
                mMobilePhone.setText(mIndividual.getMobilePhone());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
