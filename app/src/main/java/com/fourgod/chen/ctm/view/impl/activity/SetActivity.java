package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fourgod.chen.ctm.CTMApplication;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.SetPresenter;

/**
 * Created by Tolean on 2018/12/20.
 */

public class SetActivity extends BaseActivity<SetPresenter> {
    private ImageView mBack;
    private TextView mLogout;
    private RelativeLayout changePass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
    }

    @Override
    protected SetPresenter getPresenter() {
        return new SetPresenter(this);
    }
    private void initView(){
        changePass = findViewById(R.id.change_pass);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetActivity.this,
                        ChangePasswordActivity.class);
                SetActivity.this.startActivity(intent);
            }
        });

        mBack=findViewById(R.id.set_back);
        mLogout=findViewById(R.id.set_logout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("token",
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("token");
                editor.clear();
                editor.apply();
                CTMApplication.getInstance().exitAllActivity();
                startActivity(new Intent(SetActivity.this,LoginActivity.class));
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetActivity.this.finish();
            }
        });
    }
}
