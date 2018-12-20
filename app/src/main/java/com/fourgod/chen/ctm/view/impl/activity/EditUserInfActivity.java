package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.EditUserInfPresenter;
import com.fourgod.chen.ctm.utils.GlideLoadEngine;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Tolean on 2018/12/19.
 */

public class EditUserInfActivity extends BaseActivity<EditUserInfPresenter> {
    private CityPickerView mPicker = new CityPickerView();
    private WheelView mWvSex;
    private TextView mTvBirth;
    private TextView mTvHometown;
    private ImageView mIgBack;
    private CircleImageView mCivPortrait;
    @Override
    protected EditUserInfPresenter getPresenter() {
        return new EditUserInfPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_inf);
        mPicker.init(this);
        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String uri = Matisse.obtainPathResult(data).get(0);
                if (uri != null) {
                    Glide.with(this)
                            .asBitmap() // some .jpeg files are actually gif
                            .load(uri)
                            .apply(new RequestOptions() {{
                                override(Target.SIZE_ORIGINAL);
                            }})
                            .into(mCivPortrait);
                } else
                    Toast.makeText(this, "uri为null", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void initView(){
        mWvSex=findViewById(R.id.edit_user_sex);
        mTvBirth=findViewById(R.id.edit_user_birth);
        mTvHometown=findViewById(R.id.edit_user_hometown);
        mIgBack=findViewById(R.id.edit_user_back);
        mCivPortrait=findViewById(R.id.edit_user_portrait);
        mWvSex.setCyclic(false);
        mWvSex.setTextSize(14);
        final List<String> mOptionsItems = new ArrayList<>();
        mOptionsItems.add("男");
        mOptionsItems.add("女");
        mWvSex.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        mWvSex.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                //
            }
        });

        mIgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditUserInfActivity.this.finish();
            }
        });
        mCivPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Matisse.from(EditUserInfActivity.this).choose(MimeType.ofImage(), false)
                        .countable(true)
                        .maxSelectable(1)
                        .theme(R.style.Matisse_Dracula )
                        .gridExpectedSize((int) getResources().getDimension(R.dimen.imageSelectDimen))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                        .thumbnailScale(0.87f)
                        .imageEngine(new GlideLoadEngine())
                        .forResult(1);

            }
        });
        mTvBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar selectedDate = Calendar.getInstance();
                Calendar startDate = Calendar.getInstance();
                //startDate.set(2013,1,1);
                Calendar endDate = Calendar.getInstance();
                //endDate.set(2020,1,1);
                //正确设置方式 原因：注意事项有说明
                startDate.set(1800,0,1);
                endDate.set(2020,11,31);

                TimePickerView pvTime = new TimePickerBuilder(EditUserInfActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        mTvBirth.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
                    }
                })
                        .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .setTextColorCenter(getResources().getColor(R.color.white))
                        .setTitleSize(20)//标题文字大小
                        .setTitleText("日期")//标题文字
                        .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                        .isCyclic(false)//是否循环滚动
                        .setTitleColor(getResources().getColor(R.color.black))//标题文字颜色
                        .setSubmitColor(getResources().getColor(R.color.green))//确定按钮文字颜色
                        .setCancelColor(getResources().getColor(R.color.green))//取消按钮文字颜色
                        .setTitleBgColor(getResources().getColor(R.color.white))//标题背景颜色 Night mode
                        .setBgColor(getResources().getColor(R.color.gray))//滚轮背景颜色 Night mode
                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                        .setRangDate(startDate,endDate)//起始终止年月日设定
                        .setLabel("年","月","日","时","分","秒")//默认设置为年月日时分秒
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .isDialog(false)//是否显示为对话框样式
                        .build();
                        pvTime.show();
            }
        });
        mTvHometown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加默认的配置，可以自己修改
                CityConfig cityConfig = new CityConfig.Builder()
                        .province("北京") //设置默认显示省份
                        .build();
                mPicker.setConfig(cityConfig);
                //监听选择点击事件及返回结果
                mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
                    @Override
                    public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                        //省份
                        if (province != null && city != null && district != null) {
                            mTvHometown.setText(province.toString()+"  "+city.toString()+"  "+district.toString());
                        }
                    }

                    @Override
                    public void onCancel() {

                    }
                });
                //显示
                mPicker.showCityPicker( );

            }
        });
    }
}

