package com.aotomdemo.lostjason.myapplication.annotations;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aotomdemo.lostjason.myapplication.R;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.res.AnimationRes;
import com.googlecode.androidannotations.helper.AnnotationHelper;

/**
 * Created by LostJason on 2017/4/24.
 */
@EActivity(R.layout.m_main)
public class TestAnnotations extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     //   AnnotationHelper.class.getInterfaces().
      //  setContentView(R.layout.m_main);
    }
}
