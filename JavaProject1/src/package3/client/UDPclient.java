package package3.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * udp协议客户端
 * @author MacBook
 *
 */
public class UDPclient {
	public static void main(String[] args) {
		DatagramSocket client = null;
		String send = "Hello I am client";
		byte[] sendbyte = send.getBytes();
		try {
			client = new DatagramSocket();
			InetAddress addr = InetAddress.getByName("localhost");
			int port = 10000;
			DatagramPacket dPacket = new DatagramPacket(sendbyte,sendbyte.length,addr,port);
			client.send(dPacket);
			
			byte[] recvBuf = new byte[100];
	        DatagramPacket recvPacket
	            = new DatagramPacket(recvBuf , recvBuf.length);
	        client.receive(recvPacket);
	        String recvStr = new String(recvPacket.getData() , 0 ,recvPacket.getLength());
	        System.out.println("收到:" + recvStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.close();
	}
}
