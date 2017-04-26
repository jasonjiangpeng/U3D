package com.aotomdemo.lostjason.myapplication.activity;

import android.app.Application;
import android.widget.Switch;


import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by LostJason on 2017/4/18.
 */

public class UseDeviceSizeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        Switch switchs;
    }
}
