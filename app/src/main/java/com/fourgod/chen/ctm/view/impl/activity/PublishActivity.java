package com.fourgod.chen.ctm.view.impl.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fourgod.chen.ctm.R;
import com.fourgod.chen.ctm.entity.CategoryListBean;
import com.fourgod.chen.ctm.entity.ImageResultBean;
import com.fourgod.chen.ctm.entity.InfoAllListBean;
import com.fourgod.chen.ctm.entity.PushBean;
import com.fourgod.chen.ctm.presenter.impl.PublishPresenter;
import com.fourgod.chen.ctm.utils.GlideLoadEngine;
import com.fourgod.chen.ctm.view.widget.CustomDatePicker;
import com.fourgod.chen.ctm.view.widget.ProgressDialog;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class PublishActivity extends BaseActivity<PublishPresenter> {

    private boolean isEdit = false;
    private ImageView close;
    private TextView publish;
    private EditText editTitle;
    private EditText editContent;
    private LinearLayout chooseCate;
    private TextView chooseTime;
    private LinearLayout addImages;
    private RecyclerView imageRecyclerView;
    private CustomDatePicker datePicker;
    private Spinner cateSpinner;
    private int categoryId = -1;
    private int type = 0;
    private List<String> cateNameList = new ArrayList<>();
    private List<CategoryListBean.DataBean.ListBean> cateList = new ArrayList<>();
    private TextView cateMask;
    private ProgressDialog dialog;
    private List<String> selected = new ArrayList<>();
    private List<String> localSelected = new ArrayList<>();
    private ImageAdapter imageAdapter;
    private String imageUrls = "";
    private InfoAllListBean.DataBean bean;
    private TextView titleTextView;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        Intent intent = getIntent();
        if (intent != null) {
            type = intent.getIntExtra("type", 0);
            isEdit = intent.getBooleanExtra("isEdit", false);
            if (isEdit) {
                bean = ((InfoAllListBean.DataBean) intent.getSerializableExtra("bean"));
            }
        }

        initDialog();
        getCateList();
        bindView();
    }

    private void initDialog() {
        dialog = new ProgressDialog(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void bindView() {
        titleTextView = findViewById(R.id.toolbar_title);
        if (isEdit) {
            titleTextView.setText("编辑");
        }

        cateNameList.add("选择分类");
        cateSpinner = findViewById(R.id.sp_cate);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_cate, cateNameList);
        cateSpinner.setAdapter(adapter);
        cateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    categoryId = cateList.get(position - 1).getId();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        publish = findViewById(R.id.tv_publish);
        if (isEdit) {
            publish.setText("修改");
        }
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                if (localSelected != null && localSelected.size() != 0) {
                    presenter.uploadImage(localSelected);
                } else {
                    doPublish();
                }
            }
        });
        editTitle = findViewById(R.id.edit_title);
        editContent = findViewById(R.id.edit_content);

        if (bean != null) {
            editTitle.setText(bean.getTitle());
            editContent.setText(bean.getContent());
            chooseTime.setText(bean.getEndTime());
            if (bean.getPicture() != null && !bean.getPicture().equals("")) {
                selected = Arrays.asList(bean.getPicture().split("\\|"));
            }
        }
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

        imageAdapter = new ImageAdapter();
        imageRecyclerView = findViewById(R.id.rv_images);
        imageRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        imageRecyclerView.setAdapter(imageAdapter);
    }

    /**
     * 发布信息.
     */
    private void doPublish() {
        ArrayMap<String, String> param = new ArrayMap<>();
        if (imageUrls != null && !imageUrls.equals("")) {
            param.put("picture", imageUrls);
        }
        param.put("type", String.valueOf(type));
        param.put("title", editTitle.getText().toString());

        if (categoryId != -1) {
            param.put("categoryId", String.valueOf(categoryId));
        }
        param.put("content", editContent.getText().toString());
        if (!chooseTime.getText().equals("") && !chooseTime.getText().equals("选择失效时间")) {
            param.put("endTime", chooseTime.getText().toString());
        }

        presenter.publish(param);
    }

    private void getCateList() {
        ArrayMap<String, String> param = new ArrayMap<>();
        param.put("type", String.valueOf(type));
        presenter.getCateList(param);
    }

    @Override
    protected PublishPresenter getPresenter() {
        return new PublishPresenter(this);
    }

    public void publishReturn(PushBean obj) {
        if (obj.getCode() == 0) {
            dialog.setState(true);
        } else {
            dialog.setState(false);
        }

        new DelayThread().start();
    }

    public void getCateListReturn(CategoryListBean obj) {
        cateNameList.clear();
        cateNameList.add("选择分类");
        cateList = obj.getData().getList();
        for (CategoryListBean.DataBean.ListBean bean: obj.getData().getList()) {
            cateNameList.add(bean.getName());
        }
        int p = 0;
        for (int i = 0; i < cateList.size(); i++) {
            if (cateList.get(i).getId() == bean.getCategoryId()) {
                p = i + 1;
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_cate, cateNameList);
        cateSpinner.setAdapter(adapter);
        cateSpinner.setSelection(p);
    }

    public void showDialog() {
        dialog.show();
    }

    Handler handler = new Handler()
    {
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0x123)
            {
                dialog.dismiss();
                PublishActivity.this.finish();
            } else if (msg.what == 0) {
                dialog.dismiss();
            }
        };
    };

    public void imageUploadComplete(ImageResultBean bean) {
       for (int i = 0; i < bean.getBeans().size(); i++) {
           imageUrls = imageUrls + bean.getBeans().get(i).getMessage();
           imageUrls = imageUrls + "|";
       }
       selected.removeAll(localSelected);
       for (int i = 0; i < selected.size(); i++) {
           imageUrls = imageUrls + selected.get(i);
           imageUrls = imageUrls + "|";
       }
       imageUrls = imageUrls.substring(0, imageUrls.length() - 1);
       doPublish();
    }


    class DelayThread extends Thread {
        boolean isSuccess = true;
        @Override
        public void run() {
            //延迟1秒更新
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isSuccess) {
                handler.sendEmptyMessage(0x123);
            } else {
                handler.sendEmptyMessage(0);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                List<String> list = Matisse.obtainPathResult(data);
                for (String path: list) {
                    if (!selected.contains(path)) {
                        selected.add(path);
                    }
                    if (!localSelected.contains(path)) {
                        localSelected.add(path);
                    }
                }
                imageAdapter.notifyDataSetChanged();
            }
        }
    }

    class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            if (i == 1) {
                View head = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_add_image, viewGroup, false);
                return new HeadHolder(head);
            } else {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image,
                        viewGroup, false);
                return new ImageHolder(view);
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) return 1;
            else return 0;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
            if (i > 0) {
                ImageHolder imageHolder = (ImageHolder) viewHolder;
                Glide.with(PublishActivity.this).load(selected.get(i - 1))
                        .into(imageHolder.selected);
                imageHolder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selected.remove(i-1);
                        update(i);
                    }
                });
            } else {
                ((HeadHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Matisse.from(PublishActivity.this).choose(MimeType.ofImage(), false)
                                .countable(true)
                                .maxSelectable(7)
                                .theme(R.style.Matisse_Dracula )
                                .gridExpectedSize((int) getResources().getDimension(R.dimen.imageSelectDimen))
                                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                                .thumbnailScale(0.87f)
                                .imageEngine(new GlideLoadEngine())
                                .forResult(1);

                    }
                });
            }
        }

        private void update(int position) {
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return selected.size() + 1;
        }

        class ImageHolder extends RecyclerView.ViewHolder{
            public ImageView selected;
            public ImageView delete;

            public ImageHolder(@NonNull View itemView) {
                super(itemView);
                selected = itemView.findViewById(R.id.iv_selected);
                delete = itemView.findViewById(R.id.iv_selected_delete);
            }
        }

        class HeadHolder extends RecyclerView.ViewHolder{

            public HeadHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
