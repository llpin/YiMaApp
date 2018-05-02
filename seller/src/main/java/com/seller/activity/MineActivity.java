package com.seller.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.entity.Employee;
import com.common.pojo.UserVo;

public class MineActivity extends BaseActivity implements BaseInter {
    Employee mEmployee;

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
                mEmployee = user.getEmployee();
        }catch (Exception e){
            e.printStackTrace();
        }


        initForm();
    }

    @Override
    public void initForm() {
        if(mEmployee != null){
            try{
                mUsernameText = (TextView)findViewById(R.id.username);
                mUsertypeText = (TextView)findViewById(R.id.usertype);
                mName = (TextView)findViewById(R.id.name);
                mMobilePhone = (TextView)findViewById(R.id.mobilePhone);

                mUsernameText.setText(mEmployee.getUser().getUsername());
                mUsertypeText.setText(mEmployee.getUser().getPlatformMainType().getName());
                mName.setText(mEmployee.getName());
                mMobilePhone.setText(mEmployee.getMobilePhone());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
