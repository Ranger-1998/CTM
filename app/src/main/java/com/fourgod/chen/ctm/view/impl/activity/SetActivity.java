package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.SetPresenter;

/**
 * Created by Tolean on 2018/12/20.
 */

public class SetActivity extends BaseActivity<SetPresenter> {
    private ImageView mBack;
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
        mBack=findViewById(R.id.set_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetActivity.this.finish();
            }
        });
    }
}
