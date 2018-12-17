package com.fourgod.chen.ctm.presenter.impl;

import android.os.Handler;
import android.os.Message;

import com.fourgod.chen.ctm.model.impl.BaseModel;
import com.fourgod.chen.ctm.view.i.IBaseView;

import java.lang.ref.WeakReference;

/**
 * description Presenter 的父类.
 * *
 * Created by czt
 * on 2018/12/17.
 */
public abstract class BasePresenter<V extends IBaseView, M extends BaseModel> {
    V view;
    M model;

    public BasePresenter(V view) {
        this.view = view;
        model = getModel(getHandler());
    }

    /**
     * 获取Model对象,Model对象需要持有一个handel
     *
     * @param handler model持有的handel
     * @return model 对象
     */
    protected abstract M getModel(Handler handler);

    /**
     * 这个方法处理网络请求成功后从model层发送过来的事件
     * 子类在复写此方法时,从msg获取的obj请转换为对应的model中发送的类型
     * 在对应的Activity销毁后在调用这个方法会抛出NullPointerException,在调用这个方法的位置catch异常!!!
     * 异常发生原因:这个方法会使用持有的activity来调用activity的方法,当activity销毁后再调用activity的方法就
     * 会发生异常.将异常从这个函数抛出,在调用这个函数的地方catch.至于为什么不在异常发生的时候就catch,原因如下:
     * 1.如果要在发生的时候就catch需要在每个子类写try-catch代码块,比较繁琐;
     * 2.这个方法最主要的功能就是调用activity的方法,当activity销毁后这个方法就没有继续执行的意义,所以直接从
     * 这个方法抛出异常,没有必要再执行这个方法抛出异常之后的代码
     *
     * @param msg 消息,mes.what用于区分是哪个网络请求返回了,msg.obj包含了网络请求返回的数据
     */
    protected abstract void eventReceive(Message msg);

    /**
     * 获取handel对象,需要持有当前presenter的弱引用
     *
     * @return 主线程的handel
     */
    private Handler getHandler() {
        return new MainHandler(this);
    }

    /**
     * 用于获取主线程的handler
     * 这个内部类必须是静态的,不能让这个类持有外部类的引用,否则可能会造成内存泄漏
     * 使用弱引用来关联外部类,当只有弱应用存在时，变量会被回收，所以,请注意空指针!!!
     *
     * @see #eventReceive(Message) 调用的这个方法可能会抛出NullPointerException,在这里处理掉,不要让没有
     * 必要的异常使程序崩溃
     */
    private static class MainHandler extends Handler {

        private WeakReference<BasePresenter> presenter;     //弱引用

        MainHandler(BasePresenter presenter) {
            this.presenter = new WeakReference<>(presenter);
        }

        @Override
        public void handleMessage(Message msg) {
            if (presenter.get() != null) {
                try {                                           //在这里catch NullPointerException
                    if (!presenter.get().view.isFinish()) {
                        presenter.get().eventReceive(msg);      //接收到事件后的操作,可能会抛出NullPointerException
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            super.handleMessage(msg);
        }
    }

    /**
     * 将Activity对象置空,在Activity销毁时应该调用该方法,以便于JVM回收
     * 注意!在置空后不能再调用Activity的方法,否则会抛出NullPointerException
     */
    public void onDestroy() {
        view = null;
        if (model != null) {
            model.onDestroy();
            model = null;
        }
    }
}
