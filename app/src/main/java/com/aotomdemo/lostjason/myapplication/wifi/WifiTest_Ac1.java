package com.aotomdemo.lostjason.myapplication.wifi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.aotomdemo.lostjason.myapplication.R;
import com.aotomdemo.lostjason.myapplication.Utils.DataUpdata;
import com.aotomdemo.lostjason.myapplication.Utils.UdpHelper;

/**
 * Created by LostJason on 2017/4/21.
 */

public class WifiTest_Ac1 extends Activity implements DataUpdata {
  UdpHelper udpHelper;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifitest);
        tv= (TextView) findViewById(R.id.tv);
        //WifiManager  wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        udpHelper=new UdpHelper();
        udpHelper.setDataUpdata(this);

    }
    public void onclickb(View view)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                udpHelper.StartListen();
            }
        }).start();
    }
    public void onclicka(View view)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                UdpHelper.send("我是一个好人asda");
            }
        }).start();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void receiveupdata(String up) {
        if (up!=null&&up.trim().length()>1){
            tv.setText(up);
        }

    }
}
