package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.BasePresenter;
import com.fourgod.chen.ctm.presenter.impl.RegisterPresenter;
import com.fourgod.chen.ctm.utils.PhoneFormatCheckUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Tolean on 2018/12/18.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> {
    private EditText mPhone;
    private EditText mNickname;
    private EditText mPassword;
    private EditText mRePassword;
    private EditText mCode;
    private TextView mRegister;
    private LinearLayout mRegistering;
    private Button mGetCode;
    private int time;
    @Override
    protected RegisterPresenter getPresenter() {
        return new RegisterPresenter(this);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Init();
    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                mGetCode.setText(String.valueOf(time--)+"s");
                if(time==0){
                    timer.cancel();
                    mGetCode.setText("获取验证码");
                }
            }
            super.handleMessage(msg);
        }
    };

    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };
    private void Init(){
        mPhone=findViewById(R.id.register_phone);
        mNickname=findViewById(R.id.register_nickname);
        mPassword=findViewById(R.id.register_password);
        mRePassword=findViewById(R.id.register_rpassword);
        mRegister=findViewById(R.id.tv_register);
        mRegistering=findViewById(R.id.ll_register);
        mCode=findViewById(R.id.register_code);
        mGetCode=findViewById(R.id.register_get_code);
        mGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(time>0){
                    return ;
                }
                if(mPhone.getText().toString().length()!=11){
                    Toast.makeText(RegisterActivity.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
                    return ;
                }
                time=59;
                ArrayMap<String, String> param=new ArrayMap<>();
                param.put("phoneNumber",mPhone.getText().toString());
                presenter.sendCode(param);
                timer.schedule(timerTask,0,1000);//延时1s，每隔500毫秒执行一次run方法
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRegistering.setVisibility(View.VISIBLE);
                mRegister.setVisibility(View.GONE);
                if(!checkInfo()){
                    mRegistering.setVisibility(View.GONE);
                    mRegister.setVisibility(View.VISIBLE);
                }
            }
        });


    }
    public Boolean checkInfo(){
        Log.d("Lyon",mCode.getText().toString());
        if(mPhone.getText().toString().length()!=11){
            Toast.makeText(RegisterActivity.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
            return false;
        }else if(mNickname.getText().toString().length()<4||mNickname.getText().toString().length()>16){
            Toast.makeText(RegisterActivity.this,"昵称长度应在4-16个字符之间",Toast.LENGTH_SHORT).show();
            return false;
        }else if(mPassword.getText().toString().length()<6||mPassword.getText().toString().length()>12){
            Toast.makeText(RegisterActivity.this,"密码长度应在6-12个字符之间",Toast.LENGTH_SHORT).show();
            return false;
        }else if(!mPassword.getText().toString().equals(mRePassword.getText().toString())){
            Toast.makeText(RegisterActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
            return false;
        }else if(mCode.getText().toString().length()==0) {
            Toast.makeText(RegisterActivity.this,"请输入验证码",Toast.LENGTH_SHORT).show();
            return false;
        }else {
            ArrayMap<String, String> param=new ArrayMap<>();
            param.put("phoneNumber",mPhone.getText().toString());
            param.put("code",mCode.getText().toString());
            presenter.checkCode(param);
        }
        return true;
    }
    public void register(boolean isCodeRight){
        if(!isCodeRight){
            Toast.makeText(RegisterActivity.this,"验证码不正确",Toast.LENGTH_SHORT).show();
            mRegistering.setVisibility(View.GONE);
            mRegister.setVisibility(View.VISIBLE);
            return ;
        }else{
            Toast.makeText(RegisterActivity.this,"验证码正确",Toast.LENGTH_SHORT).show();
            ArrayMap<String, String> param=new ArrayMap<>();
            param.put("nickname",mNickname.getText().toString());
            param.put("password",mPassword.getText().toString());
            param.put("telephone",mPhone.getText().toString());
            param.put("username",mPhone.getText().toString());
            presenter.register(param);
            return ;
        }
    }

    public void registerSuccess(){
        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        RegisterActivity.this.finish();
    }

    public void registerFail(){
        Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
        mRegistering.setVisibility(View.GONE);
        mRegister.setVisibility(View.VISIBLE);
    }
}

