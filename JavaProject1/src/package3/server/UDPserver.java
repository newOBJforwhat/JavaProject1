package package3.server;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * 实现udp协议通信的服务器类
 * @author MacBook
 *
 */
public class UDPserver {
	public static void main(String[] args) {
		byte[] recvBuf = new byte[100];
		DatagramPacket dPacket = new DatagramPacket(recvBuf,recvBuf.length);
		DatagramSocket server = null;
		try {
			server = new DatagramSocket(10000);
			System.out.println("启动成功");
			server.receive(dPacket);
			String recvStr = new String(dPacket.getData() , 0 ,dPacket.getLength());
			System.out.println("recvStr:"+recvStr);
			System.out.println("this is from addr:"+dPacket.getAddress());
			System.out.println("this is from port:"+dPacket.getPort());
			String response = "this is my server";
			byte[] sendbyte = response.getBytes();
			DatagramPacket sendpkg = new DatagramPacket(sendbyte, sendbyte.length,dPacket.getAddress(),dPacket.getPort());
			server.send(sendpkg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		server.close();
		
	}
}
