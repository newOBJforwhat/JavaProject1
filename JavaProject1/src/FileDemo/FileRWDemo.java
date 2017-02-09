package FileDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件读写demo
 * @author ctk
 *
 */
public class FileRWDemo {
	public static void main(String[] args) {
		File f= new File("src/FileDemo/hello.txt");//虚拟路径从项目下开始
		File nf = new File("src/FileDemo/temp.txt");
		long fsize = f.length();
		FileInputStream fins = null;
		FileOutputStream fous = null ;
		System.out.println(f.getAbsolutePath());
		System.out.println(fsize);
		try {
			if(!nf.exists())
				nf.createNewFile();
			fins = new FileInputStream(f);
			fous = new FileOutputStream(nf);
			long index = 0;
			int readSize = 20;
			
			while(index != fsize){
				if((fsize - index) < 20)
					readSize = (int)(fsize - index);
				byte[] b = new byte[readSize];
				fins.read(b);
				System.out.println(new String(b));
				index = index + readSize;
			}
			
//			fous.write(b);
//			fous.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fins != null)
					fins.close();
				if(fous != null)
					fous.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
