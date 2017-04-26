package com.aotomdemo.lostjason.myapplication.Utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by LostJason on 2017/4/21.
 */

public class NetUtils {
    /*获取局域网所有主机名和ip地址*/
    public void search(){
        System.out.println("======start=========");
        for(int num = 0; num <= 255; num++) {
            final String host = "192.168.11." + num;
            new Thread() {
                public void run() {
                    try {
                        InetAddress hostAddress = InetAddress.getByName(host);
                        if(!hostAddress.getHostName().equalsIgnoreCase(hostAddress.getHostAddress()))
                            System.out.println(hostAddress.getHostName()+":"+host);
                    }catch(UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }

        System.out.println("======end=========");

    }
    /*获取本地IP*/
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
            System.out.println("WifiPreference IpAddress"+ ex.toString());
        }
        return null;
    }
}
