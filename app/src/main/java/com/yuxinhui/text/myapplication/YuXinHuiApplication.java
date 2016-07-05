package com.yuxinhui.text.myapplication;

import android.app.Application;

import com.yuxinhui.text.myapplication.Utils.User;

/**
 * 用于存放全局变量的类
 * Created by Administrator on 2016/7/4.
 */

public class YuXinHuiApplication extends Application {
    private boolean isLogin=false;
    private boolean isRing = true;
    private boolean isVirbate = true;
    private boolean isOpenMiandarao = false;
    private User user;
    private static YuXinHuiApplication instace;

    @Override
    public void onCreate() {
        super.onCreate();
        instace = this;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isRing() {
        return isRing;
    }

    public void setRing(boolean ring) {
        isRing = ring;
    }

    public boolean isVirbate() {
        return isVirbate;
    }

    public void setVirbate(boolean virbate) {
        isVirbate = virbate;
    }

    public boolean isOpenMiandarao() {
        return isOpenMiandarao;
    }

    public void setOpenMiandarao(boolean openMiandarao) {
        isOpenMiandarao = openMiandarao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static YuXinHuiApplication getInstace() {
        return instace;
    }

    public static void setInstace(YuXinHuiApplication instace) {
        YuXinHuiApplication.instace = instace;
    }

    public void unLoginclear() {
        user = null;
        isLogin = false;

    }
}