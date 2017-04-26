package com.aotomdemo.lostjason.myapplication.udp;

import com.aotomdemo.lostjason.myapplication.log.Logshow;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by LostJason on 2017/4/21.
 */

public class SimpleUdp {

    public void ServerReceviedByUdp(){ //服务端接收数据
        //创建一个DatagramSocket对象，并指定监听端口。（UDP使用DatagramSocket）
        DatagramSocket socket;

        try {
            socket = new DatagramSocket(10025);
            //创建一个byte类型的数组，用于存放接收到得数据
            byte data[] = new byte[4*1024];
            //创建一个DatagramPacket对象，并指定DatagramPacket对象的大小
            DatagramPacket packet = new DatagramPacket(data,data.length);
            while (true){
                socket.receive(packet);
                String result = new String(packet.getData(),packet.getOffset() ,packet.getLength());
                Logshow.logshow(result);
            }
            //读取接收到得数据

            //把客户端发送的数据转换为字符串。
            //使用三个参数的String方法。参数一：数据包 参数二：起始位置 参数三：数据包长


        //    dataRec.dataRec(result);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReceiveServerSocketData() { //客户端接入服务端数据
        DatagramSocket socket;
        try {
            //实例化的端口号要和发送时的socket一致，否则收不到data
            socket = new DatagramSocket(1985);
            byte data[] = new byte[4 * 1024];
            //参数一:要接受的data 参数二：data的长度
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            //把接收到的data转换为String字符串
            String result = new String(packet.getData(), packet.getOffset(),
                    packet.getLength());
            socket.close();//不使用了记得要关闭
            System.out.println("the number of reveived Socket is  :" + "udpData:" + result);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendServerWithUDPSocket() {//客户端发送数据

        DatagramSocket socket;
        try {
            //创建DatagramSocket对象并指定一个端口号，注意，如果客户端需要接收服务器的返回数据,
            //还需要使用这个端口号来receive，所以一定要记住
            socket = new DatagramSocket(1985);
            //使用InetAddress(Inet4Address).getByName把IP地址转换为网络地址
            InetAddress serverAddress = InetAddress.getByName("192.168.22.88");
            //Inet4Address serverAddress = (Inet4Address) Inet4Address.getByName("192.168.1.32");
            String str = "[2143213;21343fjks;213]";//设置要发送的报文
            byte data[] = str.getBytes();//把字符串str字符串转换为字节数组
            //创建一个DatagramPacket对象，用于发送数据。
            //参数一：要发送的数据  参数二：数据的长度  参数三：服务端的网络地址  参数四：服务器端端口号
            DatagramPacket packet = new DatagramPacket(data, data.length ,serverAddress ,10025);
            socket.send(packet);//把数据发送到服务端。
            socket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public interface  DataRec extends Runnable{
     public    void  dataRec(String data);
    }
}
