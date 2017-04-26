package com.aotomdemo.lostjason.myapplication.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.aotomdemo.lostjason.myapplication.R;
import com.aotomdemo.lostjason.myapplication.log.Logshow;

/**
 * Created by LostJason on 2017/4/20.
 */

public class MyColorfilter extends View {
    Bitmap  bitmap;
    public MyColorfilter(Context context) {
        this(context,null);
    }

    public MyColorfilter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
       Bitmap resource= BitmapFactory.decodeResource(getResources(), R.drawable.bizhi);
        bitmap=Bitmap.createBitmap(resource,0,0,400,400);
    //    Bitmap bitmaps = bitmap.extractAlpha();
       // Drawable drawable =new BitmapDrawable(getResources(),bitmap);
     //   Canvas canvas =new Canvas(bitmap);
     //   drawable.


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap,50,50,getpaint());

    }
int count =0;
    public Paint getpaint(){
        Paint paint =new Paint(Paint.ANTI_ALIAS_FLAG);


        paint.setMaskFilter(getcount(count));
        //    paint.setFlags();
      //  paint.setAntiAlias(true);
     //   paint.setMaskFilter(MaskFilter)
        return paint;
    }
    public BlurMaskFilter getcount(int count){
        BlurMaskFilter blurMaskFilter =null;
        switch (count){
            case 0:
                return new BlurMaskFilter(30f, BlurMaskFilter.Blur.SOLID);
            case 1:
                return new BlurMaskFilter(30f, BlurMaskFilter.Blur.INNER);
            case 2:
                return new BlurMaskFilter(30f, BlurMaskFilter.Blur.NORMAL);
            case 3:
                return new BlurMaskFilter(30f, BlurMaskFilter.Blur.OUTER);

        }
        return blurMaskFilter;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logshow.logshow("count"+count);
        count++;
        if (count>3){
            count=0;
        }
        if (event.getAction()==MotionEvent.ACTION_UP){

        }
        return super.onTouchEvent(event);
    }
}
