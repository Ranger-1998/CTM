package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.LoginBean;
import com.fourgod.chen.ctm.network.NetworkManager;
import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.presenter.impl.LoginPresenter;

/**
 * Created by Tolean on 2018/12/18.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> {
    TextView loginText;
    LinearLayout loggingLinearLayout;
    TextView mTvRegister;
    RelativeLayout loginButton;
    EditText passwordEdit;
    EditText userNameEdit;
    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
    }

    private void bindView() {
        loginText = findViewById(R.id.tv_login);
        loggingLinearLayout = findViewById(R.id.ll_logging);
        userNameEdit = findViewById(R.id.login_account);
        passwordEdit = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginText.setVisibility(View.GONE);
                loggingLinearLayout.setVisibility(View.VISIBLE);
                login();
            }
        });
        mTvRegister=findViewById(R.id.login_register);
        mTvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    private void login() {
        String password = passwordEdit.getText().toString();
        String userName = userNameEdit.getText().toString();
        if (password.equals("") || userName.equals("")) {
            Toast.makeText(LoginActivity.this, "请输入用户名和密码",
                    Toast.LENGTH_SHORT).show();
        } else {
            ArrayMap<String, String> param = new ArrayMap<>();
            param.put("password", password);
            param.put("username", userName);
            presenter.login(param);
        }
    }

    public void loginReturn(LoginBean bean) {
        if (bean.getCode() == 0) {
            loginText.setText("登录成功");
            SharedPreferences preferences = getSharedPreferences("token",
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("token", bean.getData().getToken());
            editor.apply();

            NetworkManager.getInstance().setToken(bean.getData().getToken());
            Intent intent = new Intent(LoginActivity.this,
                    HomeActivity.class);
            LoginActivity.this.startActivity(intent);
            LoginActivity.this.finish();
        } else {
            Toast.makeText(LoginActivity.this, bean.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
        loggingLinearLayout.setVisibility(View.GONE);
        loginText.setVisibility(View.VISIBLE);
    }
}
