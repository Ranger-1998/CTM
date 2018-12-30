package com.fourgod.chen.ctm.event;

/**
 * Created by chen on 2018/9/15.
 */
public class NewsBean extends BaseBean {
    public static final int NEWS_TOP = 1;
    public static final int NEWS_SOCIETY= 2;
    public static final int NEWS_DOMESTIC = 3;
    public static final int NEWS_INTERNATIONAL = 4;

    private com.fourgod.chen.ctm.entity.NewsBean newsBean;

    public void setNewsBean (com.fourgod.chen.ctm.entity.NewsBean newsBean) {
        this.newsBean = newsBean;
    }

    public com.fourgod.chen.ctm.entity.NewsBean getNewsBean () {
        return newsBean;
    }
}
