package com.fourgod.chen.ctm.view.impl.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.presenter.impl.EditUserInfPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Tolean on 2018/12/19.
 */

public class EditUserInfActivity extends BaseActivity<EditUserInfPresenter> {
    private WheelView mWvSex;
    private TextView mTvBirth;
    private TextView mTvHometown;
    @Override
    protected EditUserInfPresenter getPresenter() {
        return new EditUserInfPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_inf);
        initView();
    }
    private void initView(){
        mWvSex=findViewById(R.id.edit_user_sex);
        mTvBirth=findViewById(R.id.edit_user_birth);
        mTvHometown=findViewById(R.id.edit_user_hometown);
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
                        mTvBirth.setText(new SimpleDateFormat("yyyy-mm-dd").format(date));
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
                        .isDialog(true)//是否显示为对话框样式
                        .build();
                        pvTime.show();
            }
        });
        mTvHometown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OptionsPickerView pvOptions = new OptionsPickerBuilder(EditUserInfActivity.this, new OnOptionsSelectListener() {

                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                        //返回的分别是三个级别的选中位置
//                        String tx = options1Items.get(options1).getPickerViewText()
//                                + options2Items.get(options1).get(option2)
//                                + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
//                        tvOptions.setText(tx);
                    }
                }) .setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
                    @Override
                    public void onOptionsSelectChanged(int options1, int options2, int options3) {
                        String str = "options1: " + options1 + "\noptions2: " + options2 + "\noptions3: " + options3;
                        //Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                })
                        .setSubmitText("确定")//确定按钮文字
                        .setCancelText("取消")//取消按钮文字
                        .setTitleText("城市选择")//标题
                        .setSubCalSize(18)//确定和取消文字大小
                        .setTitleSize(20)//标题文字大小
                        .setTitleColor(Color.BLACK)//标题文字颜色
                        .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                        .setCancelColor(Color.BLUE)//取消按钮文字颜色
                        .setTitleBgColor(0xFF333333)//标题背景颜色 Night mode
                        .setBgColor(0xFF000000)//滚轮背景颜色 Night mode
                        .setContentTextSize(18)//滚轮文字大小
                        .setLabels("省", "市", "区")//设置选择的三级单位
                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                        .setCyclic(false, false, false)//循环与否
                        .setSelectOptions(1, 1, 1)  //设置默认选中项
                        .setOutSideCancelable(true)//点击外部dismiss default true
                        .isDialog(true)//是否显示为对话框样式
                        .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                        .build();
                pvOptions.show();
            }
        });
    }
}
