package package3.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 文件命令客户端
 * @author ctk
 */
public class CommandClient {
	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("localhost",9999);
			System.out.println("connect server successful!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataInputStream dins = null;
		DataOutputStream dous = null;
		BufferedReader cmdReader =new BufferedReader(new InputStreamReader(System.in));
		try {
			dins = new DataInputStream(client.getInputStream());
			dous = new DataOutputStream(client.getOutputStream());
			BufferedReader bins = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
			while(true){
				String cmd = cmdReader.readLine();
				if(cmd == null)
					break;
				else if(cmd.equals(""))
					continue;
				if(cmd.equals("ls")){
					dous.write((cmd+"\r\n").getBytes());
					int len = dins.readInt();
					for(int i = 0;i<len;i++){
						System.out.println(bins.readLine());
					}
				}else
				{
					dous.write((cmd+"\r\n").getBytes());
					String msg = bins.readLine();
					System.out.println("client recv :"+msg);
				}
			}

			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dins.close();
				dous.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
