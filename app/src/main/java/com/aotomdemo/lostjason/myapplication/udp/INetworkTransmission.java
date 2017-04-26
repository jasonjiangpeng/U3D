package com.aotomdemo.lostjason.myapplication.udp;

public interface INetworkTransmission //�������ӽӿ�
{

	public void setParameters(String ip, int port);
	public boolean open();
	public void close();
	public boolean send(String text);
	public void onReceive(byte[] buffer, int length);
}
