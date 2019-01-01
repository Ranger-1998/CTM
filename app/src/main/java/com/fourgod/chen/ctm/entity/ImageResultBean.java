package com.fourgod.chen.ctm.entity;

import java.util.List;

public class ImageResultBean extends BaseBean {
    List<ImageUploadBean> beans;

    public List<ImageUploadBean> getBeans() {
        return beans;
    }

    public void setBeans(List<ImageUploadBean> beans) {
        this.beans = beans;
    }
}
