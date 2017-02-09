package package1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * socket发送email
 * @author ctk
 * 不用flush会偷懒
 */
public class emailSender {
	static String emailAddr = "9168376@163.com";
	static String emailUsername = "9168376";
	static String emailPassword = "4721492";
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("smtp.163.com",25);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader ins = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			System.out.println("收到:"+ins.readLine());
			
			//登录成功之后发送helo
			out.println("helo 163");
			out.flush();
			System.out.println("发送:helo 163");
			System.out.println("收到:"+ins.readLine());
			
			//发送登录请求
			out.println("AUTH LOGIN");
			out.flush();
			System.out.println("发送:AUTH LOGIN");
			System.out.println("收到:"+ins.readLine());
			
			//发送用户名
			out.println(emailSender.Base64Encoder(emailSender.emailUsername));
			out.flush();
			System.out.println("发送:"+emailUsername);
			System.out.println("收到:"+ins.readLine());
			
			//发送密码
			out.println(emailSender.Base64Encoder(emailSender.emailPassword));
			out.flush();
			System.out.println("发送:"+emailSender.emailPassword);
			System.out.println("收到:"+ins.readLine());
			
			//发件人
			out.println("mail from:<"+emailSender.emailAddr+">");
			out.flush();
			System.out.println("发送:"+"mail from:<"+emailUsername+">");
			System.out.println("收到:"+ins.readLine());
			
			//收件人
			out.println("rcpt to:<3331886@163.com>");
			out.flush();
			System.out.println("发送:"+"rcpt to:<3331886@163.com>");
			System.out.println("收到:"+ins.readLine());
			
			//内容
			out.println("data");  
			out.flush();
			System.out.println("收到:"+ins.readLine());
			
			out.println("subject:鸟叔收"); 
            out.println("from:9168376@163.com"); 
            out.println("to:3331886@163.com");
            out.println("Content-Type:text/plain;charset=\"utf-8\"");
            out.println();
            out.println("Java发送");
            out.println(".");
            out.println("");
            out.flush();
            
            System.out.println("这里收到"+ins.readLine());
            out.println("rset");
            out.flush();
            System.out.println("收到"+ins.readLine());  
            out.println("quit");  
            out.flush();
            System.out.println("收到"+ins.readLine()); 
            
            socket.close(); 
            ins.close();  
            out.close();  
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String Base64Encoder(String text){
		byte[] b = null;
		try {
			b = text.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new BASE64Encoder().encode(b);
	}
	public static String Base64Decoder(String text){
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b = null;
		String result = null;
		
		try {
			b = decoder.decodeBuffer(text);
			result = new String(b,"utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
