package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fourgod.chen.ctm.CTMApplication;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.ResolvedBean;
import com.fourgod.chen.ctm.presenter.impl.ChangePasswordPresenter;
import com.fourgod.chen.ctm.view.widget.ProgressDialog;

public class ChangePasswordActivity extends BaseActivity<ChangePasswordPresenter>{

    private EditText oldPasswordEdit;
    private EditText newPasswordEdit;
    private EditText confirmPasswordEdit;

    private ImageView oldPasswordImageView;
    private ImageView newPasswordImageView;
    private ImageView confirmPasswordImageView;

    private ImageView backButton;
    private TextView confirmButton;

    private ProgressDialog dialog;

    @Override
    protected ChangePasswordPresenter getPresenter() {
        return new ChangePasswordPresenter(this);
    }

    private void initView() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("修改");

        oldPasswordEdit = findViewById(R.id.edit_old_pass);
        newPasswordEdit = findViewById(R.id.edit_new_pass);
        confirmPasswordEdit = findViewById(R.id.edit_confirm_pass);

        oldPasswordImageView = findViewById(R.id.iv_old_pass);
        oldPasswordImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPasswordEye(oldPasswordEdit);
            }
        });

        newPasswordImageView = findViewById(R.id.iv_new_pass);
        newPasswordImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPasswordEye(newPasswordEdit);
            }
        });

        confirmPasswordImageView = findViewById(R.id.iv_confirm_pass);
        confirmPasswordImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPasswordEye(confirmPasswordEdit);
            }
        });

        backButton = findViewById(R.id.iv_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePasswordActivity.this.finish();
            }
        });

        confirmButton = findViewById(R.id.confirm_change);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });

    }

    private void changePassword() {
        String oldPass = oldPasswordEdit.getText().toString();
        String newPass = oldPasswordEdit.getText().toString();
        String confirm = oldPasswordEdit.getText().toString();
        if (verify(oldPass, newPass, confirm)) {
            presenter.changePassword(oldPass, newPass);
            dialog.show();
        }
    }

    private boolean verify(String oldPass, String newPass, String confirm) {
        if (oldPass == null || oldPass.equals("")) {
            showMessage("请输入旧密码");
            return false;
        } else if (newPass == null || newPass.equals("")) {
            showMessage("请输入新密码");
            return false;
        } else if (confirm == null || confirm.equals("")) {
            showMessage("确认密码不可为空");
            return false;
        } else {
            if (!newPass.equals(confirm)) {
                showMessage("两次密码不一致");
                return false;
            }
        }
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(ChangePasswordActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    //设置密码可见和不可见
    private void setPasswordEye(EditText editText) {
        if (editText.getTransformationMethod() == HideReturnsTransformationMethod.getInstance()) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        editText.setSelection(editText.getText().toString().length());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initView();
    }

    public void changePassReturn(ResolvedBean bean) {
        if (bean.getMessage().equals("修改成功")) {
            showMessage("修改成功");
            Intent intent = new Intent(ChangePasswordActivity.this,
                    LoginActivity.class);
            SharedPreferences preferences = ChangePasswordActivity.
                    this.getSharedPreferences("token",
                    Context.MODE_PRIVATE);
            preferences.edit().clear().apply();
            ChangePasswordActivity.this.startActivity(intent);
            CTMApplication.getInstance().exitAllActivity();
        } else {
            showMessage(bean.getMessage());
        }

        dialog.dismiss();
    }

}
