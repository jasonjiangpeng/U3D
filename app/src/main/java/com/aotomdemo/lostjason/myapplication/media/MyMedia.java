package com.aotomdemo.lostjason.myapplication.media;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.aotomdemo.lostjason.myapplication.R;

/**
 * Created by LostJason on 2017/4/19.
 */

public class MyMedia   extends Activity implements SurfaceHolder.Callback {
    SurfaceView surfaceView;
    SurfaceHolder  surfaceHolder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_test);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        surfaceView.getHolder().addCallback(this);
    }

    public void playMedia(){
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.test);
        mediaPlayer.setSurface(surfaceHolder.getSurface());
        mediaPlayer.start();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        surfaceHolder=holder;
        playMedia();


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
