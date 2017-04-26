package com.aotomdemo.lostjason.myapplication.wifi;

import android.os.SystemClock;

import com.aotomdemo.lostjason.myapplication.log.Logshow;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by LostJason on 2017/4/21.
 */

public class DataSend  {
    DatagramSocket  datagramSocket=null;
    MulticastSocket multicastSocket;
    int  port=32541;
 //   DatagramPacket datagramPacket=null;
    public DataSend(){
        try {
            datagramSocket=new DatagramSocket(port);
            datagramSocket.setBroadcast(true);


        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    public void sendData(String  value){
        //    InetSocketAddress  inetSocketAddress =new InetSocketAddress()
          //  datagramPacket.
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   DatagramPacket    datagramPacket=new DatagramPacket(value.getBytes(),0,value.getBytes()
                           .length,InetAddress.getByName("255.255.255.0"),port);
                   datagramSocket.send(datagramPacket);
               } catch (IOException e) {
                   Logshow.logshow("datagramSocketError");
                   e.printStackTrace();
               }
           }
       }).start();

    }
    public void revice(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRun){
                    byte[] bytes=new byte[1024];
                    Logshow.logshow("Start=========");
                    DatagramPacket     datagramPacket =new DatagramPacket(bytes,0,bytes.length);
                    try {
                        datagramSocket.setSoTimeout(1000);
                        datagramSocket.receive(datagramPacket);
                        Logshow.logshow(new String(bytes,0,bytes.length));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SystemClock.sleep(500);
                }
            }
        }).start();

    }

    boolean  isRun=true;

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    public String getLocalIpAddress()
    {
        try
        {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)
            {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)
                {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress())
                    {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        }
        catch (SocketException ex)
        {
            Logshow.logshow("DataWifiPreference IpAddress"+ ex.toString());
        }
        return null;
    }
}
