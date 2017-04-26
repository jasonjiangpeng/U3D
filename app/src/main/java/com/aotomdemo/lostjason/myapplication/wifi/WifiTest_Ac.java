package com.aotomdemo.lostjason.myapplication.wifi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aotomdemo.lostjason.myapplication.R;
import com.aotomdemo.lostjason.myapplication.Utils.DataUpdata;
import com.aotomdemo.lostjason.myapplication.Utils.UdpHelper;
import com.aotomdemo.lostjason.myapplication.log.Logshow;
import com.aotomdemo.lostjason.myapplication.udp.SimpleUdp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Created by LostJason on 2017/4/21.
 */

public class WifiTest_Ac extends Activity implements DataUpdata, SimpleUdp.DataRec {
  SimpleUdp simpleUdp;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifitest);
        tv= (TextView) findViewById(R.id.tv);
        //WifiManager  wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        simpleUdp =new SimpleUdp();

    }
    public void onclickb(View view) throws IOException {
        /*   new Thread(new Runnable() {
               @Override
               public void run() {
                  simpleUdp.ServerReceviedByUdp();
               }
           }).start();*/
     ServerSocket  serverSocket =new ServerSocket(5678);
    }
    public static boolean isPortUsing(String host,int port) throws UnknownHostException {
        boolean flag = false;
        InetAddress theAddress = InetAddress.getByName(host);
        try {
            Socket socket = new Socket(theAddress,port);
            flag = true;
        } catch (IOException e) {

        }
        return flag;
    }
    public void onclicka(View view)

    {

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                simpleUdp.sendServerWithUDPSocket();
            }
        }).start();

*/


    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(enterAnim, exitAnim);

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

    @Override
    public void dataRec(String data) {
        tv.setText(data);
    }

    @Override
    public void run() {

    }
}
