package HttpProtocol;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 实现一个http请求
 * @author ctk
 *
 */
public class HttpRequestImpl {
	private final static String encoding = "GBK";
	public static void main(String[] args) throws UnknownHostException, IOException {
		String host = "movie.douban.com";
		int port = 80;
		Socket request = new Socket(host,port);
		OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream());
		StringBuffer sb = new StringBuffer();
		String content = "username=134&password=123";
		//换行前不要加空格
		sb.append("GET / HTTP/1.1\r\n");
		sb.append("Accept:*/*\r\n");
		sb.append("Accept-Language:zh-cn\r\n");
		sb.append("User-Agent: JavaSocket/").append(System.getProperty("java.version")).append("\r\n");
		sb.append("Host:").append(host).append(":").append(port).append("\r\n");
		sb.append("Connection:close\r\n");
//		sb.append("Connection:Keep-Alive\r\n");
		sb.append("Content-Type:text/xml;"+"charset="+encoding+"\r\n");//请求提交text
//		sb.append("Content-Type:application/x-www-form-urlencoded;"+"charset="+encoding+"\r\n");//请求提交表单模式
//		sb.append("Content-Length:"+content.length()+"\r\n");
//	    sb.append("\r\n");  
//		sb.append(content+"\r\n");
		 //一个请求的结束应该有一个换行
        sb.append("\r\n");  
        System.out.println("发送请求.....");
        System.out.println(sb.toString());
        out.write(sb.toString());
        out.flush();
      
        //获取响应
        InputStream is = request.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(is, encoding));
        String str = "";
        int i = 0;
        File f = new File("src/rev.txt");
        if(!f.exists())
        	f.createNewFile();
        FileOutputStream fout = new FileOutputStream(f);
        while ((str = bufferedReader.readLine()) != null) {
        	fout.write((str+"\r\n").getBytes());
        	fout.flush();
        	System.out.println((i++)+":"+str);
        }
        is.close();
        fout.close();
        out.close();
        request.close();
        System.out.println("==============");
	}
}
