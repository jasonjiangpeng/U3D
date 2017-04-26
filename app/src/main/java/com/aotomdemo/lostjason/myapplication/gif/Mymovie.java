package com.aotomdemo.lostjason.myapplication.gif;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.aotomdemo.lostjason.myapplication.R;
import com.aotomdemo.lostjason.myapplication.log.Logshow;
import com.facebook.animated.gif.GifFrame;
import com.facebook.animated.gif.GifImage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by LostJason on 2017/4/19.
 */

public class Mymovie extends View {
    Movie movie;
    int durationtime;
    public Mymovie(Context context) {
        this(context,null);
    }

    public Mymovie(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParam();
    }
/*Ting 婷*/
String  name="Ting 婷";
    @Override
    protected void onDraw(Canvas canvas) {
       canvas.drawColor(Color.WHITE);
        movie.setTime(mCurrentAnimationTime);
        movie.draw(canvas,0,0);

    }

    public void  initParam(){
        long now = android.os.SystemClock.uptimeMillis();
        // 如果第一帧，记录起始时间
        if (mMovieStart == 0) {
            mMovieStart = now;
        }
        byte[]  data =getGiftBytes(R.raw.gif2);
        movie=Movie.decodeByteArray(data,0,data.length);
        durationtime = movie.duration();
        if (durationtime == 0) {
            durationtime = DEFAULT_MOVIE_DURATION;
        }
        // 算出需要显示第几帧
        mCurrentAnimationTime = (int) ((now - mMovieStart) % durationtime);

     //   movie.isOpaque()

    }
    int mCurrentAnimationTime;
    int DEFAULT_MOVIE_DURATION =1000;
    long mMovieStart;
    private byte[] getGiftBytes(int rawid) {  //输入流转字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = getResources().openRawResource(rawid);
        byte[] b = new byte[2048];
        int len;
        try {
            while ((len = is.read(b, 0, 2048)) != -1) {
                baos.write(b, 0, len);
            }
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logshow.logshow("onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logshow.logshow("onMeasure"+left+top+right+bottom);
    }
}
