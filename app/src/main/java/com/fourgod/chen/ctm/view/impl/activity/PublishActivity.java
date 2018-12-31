package com.fourgod.chen.ctm.view.impl.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.PublishPresenter;
import com.fourgod.chen.ctm.view.widget.CustomDatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PublishActivity extends BaseActivity<PublishPresenter> {

    private ImageView close;
    private TextView publish;
    private EditText editTitle;
    private EditText editContent;
    private LinearLayout chooseCate;
    private TextView chooseTime;
    private LinearLayout addImages;
    private RecyclerView recyclerViewFirst;
    private RecyclerView recyclerViewSecond;
    private CustomDatePicker datePicker;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        bindView();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void bindView() {
        chooseTime = findViewById(R.id.choose_time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);

        Date nowTime = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(nowTime);
        rightNow.add(Calendar.YEAR,3);//日期加3年
        Date endTime = rightNow.getTime();

        final String now = sdf.format(nowTime);
        String end = sdf.format(endTime);

        datePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) {
                chooseTime.setText(time.split(" ")[0]);
            }
        }, now, end);
        datePicker.showSpecificTime(false);
        datePicker.setIsLoop(false);
        close = findViewById(R.id.iv_cancel);
        publish = findViewById(R.id.tv_publish);
        editTitle = findViewById(R.id.edit_title);
        editContent = findViewById(R.id.edit_content);
        chooseCate = findViewById(R.id.ll_cate);
        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time;
                if (chooseTime.getText().equals("选择失效时间")){
                    time = now;
                } else {
                    time = chooseTime.getText().toString();
                }
                datePicker.show(time);
            }
        });

        addImages = findViewById(R.id.ll_add_img);
        recyclerViewFirst = findViewById(R.id.rv_images_first);
        recyclerViewSecond = findViewById(R.id.rv_images_second);
    }

    @Override
    protected PublishPresenter getPresenter() {
        return new PublishPresenter(this);
    }
}
