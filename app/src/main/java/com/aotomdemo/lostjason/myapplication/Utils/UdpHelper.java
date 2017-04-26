package com.aotomdemo.lostjason.myapplication.Utils;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Observable;

import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.util.Log;
/**
 *
 * UdpHelper帮助类
 *
 * @author 陈喆榕
 *
 */
public class UdpHelper  implements Runnable {
    public    Boolean IsThreadDisable = false;//指示监听线程是否终止
    private static WifiManager.MulticastLock lock;
    InetAddress mInetAddress;
    public UdpHelper() {
        ///    this.lock= manager.createMulticastLock("UDPwifi");
    }
    public void StartListen() {
        // UDP服务器监听的端口
        Integer port = 8904;
        // 接收的字节大小，客户端发送的数据不能超过这个大小
        byte[] message = new byte[1024];

            // 建立Socket连接
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket =null;
        try {
            datagramSocket = new DatagramSocket(port);
            datagramSocket.setBroadcast(true);
            datagramPacket = new DatagramPacket(message,
                    message.length);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
                while (!IsThreadDisable) {



                    // 准备接收数据
                    Log.d("UDP Demo", "准备接受");

                    datagramSocket.receive(datagramPacket);

                    String strMsg = new String(datagramPacket.getData()).trim();
                    Log.d("UDP Demo", strMsg);
                    if (strMsg != null) {
                        DataUpdata.receiveupdata(strMsg);
                    }
                    Log.d("UDP Demo", datagramPacket.getAddress()
                            .getHostAddress().toString()
                            + ":" + strMsg);
                }
            } catch (IOException e) {//IOException
                e.printStackTrace();
            }




}

    public com.aotomdemo.lostjason.myapplication.Utils.DataUpdata getDataUpdata() {
        return DataUpdata;
    }

    public void setDataUpdata(com.aotomdemo.lostjason.myapplication.Utils.DataUpdata dataUpdata) {
        DataUpdata = dataUpdata;
    }

    public static void send(String message) {
        message = (message == null ? "Hello IdeasAndroid!" : message);
        int server_port = 8904;
        Log.d("UDP Demo", "UDP发送数据:"+ message);
        DatagramSocket s = null;
        try {
            s = new DatagramSocket();
        }catch (IOException e) {
            e.printStackTrace();
        }
        InetAddress local = null;
        try {
            local = InetAddress.getByName("255.255.255.0"); //192.168.22.88
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int msg_length = message.length();
        byte[] messageByte = message.getBytes();
        DatagramPacket p = new DatagramPacket(messageByte, msg_length, local,
                server_port);
        try {
            s.send(p);
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("UDP Demo", "发送成功:"+ message);
    }



    @Override
    public void run() {
        StartListen();
    }
    DataUpdata DataUpdata;
}