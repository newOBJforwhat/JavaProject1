package FileDemo;

import java.io.File;

public class FileDemo2 {
	public static void main(String[] args) {
		File f = new File("/Users/MacBook/Downloads/mv.zip");
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.length());
	}
}
