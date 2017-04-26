package com.aotomdemo.lostjason.myapplication.activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.aotomdemo.lostjason.myapplication.R;

/**
 * Created by LostJason on 2017/4/18.
 */

public class TestAc extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(this::mytes,2000);
        MediaPlayer  mediaPlaye;

    }

    private void mytes() {
        setContentView(R.layout.m_main);
    }
}
