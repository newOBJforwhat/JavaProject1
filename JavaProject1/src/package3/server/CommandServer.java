package package3.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件命令服务器
 * @author ctk
 */
public class CommandServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
			System.out.println("server setup successful!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Socket client = null;
		BufferedReader ins = null;
		DataOutputStream dous = null;
		try {
			client = server.accept();
			ins = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
			dous = new DataOutputStream(client.getOutputStream());
			while(true){
				String cmd = ins.readLine();
				System.out.println("server recv cmd:"+cmd);
				if(cmd.equals("hello"))
				{
					dous.write("hello\r\n".getBytes());
					dous.flush();
				}else if(cmd.equals("ls")){
					File f = new File("/Users/MacBook/Downloads");
					File[] files = f.listFiles();
					dous.writeInt(files.length);
					dous.flush();
					for(int i=0;i<files.length;i++){
						dous.write((files[i].getName()+"\r\n").getBytes());
					}
				}else if(cmd.equals("bye")){
					dous.write("bye\r\n".getBytes());
					dous.flush();
					break;
				}else if(cmd != null && cmd.equals("")){
					continue;
				}else
					dous.write("unknow cmd \r\n".getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				dous.close();
				ins.close();
				client.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
