package com.aotomdemo.lostjason.myapplication.gif;

import android.app.Activity;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.aotomdemo.lostjason.myapplication.R;

/**
 * Created by LostJason on 2017/4/19.
 */

public class TestGif extends Activity {
    MyGifView myGifView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giftest);
        myGifView = (MyGifView)findViewById(R.id.myGifView_demo);

    //   DataBindingUtil.bind()
    }
    public void onclicka(View view){
        myGifView.updateResource(R.raw.gif3, null);
    }
}
