package com.aotomdemo.lostjason.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aotomdemo.lostjason.myapplication.activity.NetUtils;
import com.aotomdemo.lostjason.myapplication.log.Logshow;

/**
 * Created by LostJason on 2017/4/19.
 */

public class BaseAcitvity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logshow.logshow("===================================="+NetUtils.isConnected(this));
       /* if (NetUtils.isConnected(this)){
            BaseAcitvity.this.setContentView(R.layout.m_main);
            return;
        }*/

    }
    //@Che
}
