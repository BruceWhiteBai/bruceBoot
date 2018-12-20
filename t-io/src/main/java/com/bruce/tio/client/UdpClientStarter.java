package com.bruce.tio.client;

import org.tio.core.udp.UdpClient;
import org.tio.core.udp.UdpClientConf;

/**
 * @author tanyaowu
 */
public class UdpClientStarter {
	/**
	 * @param args
	 * @author tanyaowu
	 */
	public static void main(String[] args) {
		UdpClientConf udpClientConf = new UdpClientConf("127.0.0.1", 3000, 5000);
		UdpClient udpClient = new UdpClient(udpClientConf);
		udpClient.start();

		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			String str = i + "、" + "用tio开发udp，有点意思";
			udpClient.send(str.getBytes());
		}
		long end = System.currentTimeMillis();
		long iv = end - start;
		System.out.println("耗时:" + iv + "ms");
	}
}