package com.fourgod.chen.ctm.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fourgod.chen.ctm.R;

public class ProgressDialog extends Dialog {

    private TextView textView;
    private ProgressBar progressBar;
    private String message = "上传";

    public ProgressDialog(@NonNull Context context) {
        super(context);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_dialog);
        initView();
    }

    private void initView() {
        textView = findViewById(R.id.tv_progress);
        textView.setText("正在" + message);
        progressBar = findViewById(R.id.dialog_progress);
    }

    public void setState(boolean isSuccess) {
        progressBar.setVisibility(View.GONE);
        if (isSuccess) {
            textView.setText(message + "成功");
        } else {
            textView.setText(message + "上传失败");
        }
    }

}
