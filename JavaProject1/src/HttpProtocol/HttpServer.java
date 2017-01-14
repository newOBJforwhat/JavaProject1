package HttpProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * http服务器
 * @author ctk
 *
 */
public class HttpServer {
	private final static String encoding = "UTF-8";
	private final static int stateCode = 200;
	public static void main(String[] args) throws IOException {
		ServerSocket server = null;
		String responseContent = "<html><head><title>hello</title></head><body><h1>this is my page</h1></body>";
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 ").append(stateCode).append(" OK\r\n");
		sb.append("Server: Ctk\r\n");
		sb.append("Content-Length: ").append(responseContent.length()).append("\r\n");
		sb.append("Date: ").append(new Date(System.currentTimeMillis()).toString()).append("\r\n");
		sb.append("Connection: close\r\n");
		sb.append("\r\n");
		sb.append(responseContent).append("\r\n");
		sb.append("\r\n");
		try {
			server = new ServerSocket(8000);
			System.out.println("监听开始....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			Socket socket = server.accept();
			System.out.println("获得连接:"+socket.getInetAddress()+":"+socket.getPort());
			InputStream in = socket.getInputStream();
	        BufferedReader bufferedReader = new BufferedReader(
	                new InputStreamReader(in, encoding));
	        String str = "";
	        System.out.println("接受请求==============");
	        while (bufferedReader.read() != -1) {
	        	if(!((str = bufferedReader.readLine()) != null))
	        		System.out.println(str);
	        	else
	        		break;
	        }
	        System.out.println("请求结束==============");
	        System.out.println("回送响应==============");
	        System.out.println(sb.toString());
	        OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
	        out.write(sb.toString());
	        out.flush();
	        
	        out.close();
	        in.close();
	        socket.close();
	        System.out.println("响应结束==============");
		}
	}
}
