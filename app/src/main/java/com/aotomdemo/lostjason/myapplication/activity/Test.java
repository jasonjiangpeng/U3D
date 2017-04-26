package com.aotomdemo.lostjason.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.aotomdemo.lostjason.myapplication.BaseAcitvity;
import com.aotomdemo.lostjason.myapplication.R;
import com.aotomdemo.lostjason.myapplication.Utils.InputMethodUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by LostJason on 2017/4/18.
 */

public class Test extends BaseAcitvity {
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   Logshow.logshow("====================================22222222");
       setContentView(R.layout.m_main);
        View
        textView= (TextView) findViewById(R.id.tv);

  //    start();


        //     ACache  aCache=ACache.get(this);

        //  if (aCache.getAsBitmap("te").equals())
      //  aCache.put();
    }
    public void onclicka(View view){

        InputMethodUtils.showInputMethod(textView);
    }
    public void start(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream inputStream = getResources().openRawResource(R.raw.file);
                BufferedReader  bufferedReader =new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer =new StringBuffer();
                String  valuie =null;
                try {
                    while ((valuie=bufferedReader.readLine())!=null){
                        stringBuffer.append(valuie);
                    }
                  //  String finalValuie = valuie;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                         textView.setText(stringBuffer.toString());
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
