package FileDemo;

import java.io.File;
import java.io.IOException;
/**
 * 获取目录下的所有文件
 * @author ctk
 *
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		File f = new File("/Users/MacBook/Downloads");
		File[] files = f.listFiles();
		for(int i=0;i<files.length;i++)
		{
			System.out.println("filesName:"+files[i].getName());
			System.out.println("isDir:"+files[i].isDirectory());
		}
			
	}
}
