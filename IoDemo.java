package webproject.thinkinjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IoDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		File src = new File("e:/test/li/超高清晰世界地图.jpg");
		File dest = new File("e:/test/li/超高清晰世界地图copy.jpg");
		fileCopy(src,dest);
//		fileTemp();
		
	}
	
	/**
	 * 字节流
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public  static void fileCopy(File src, File dest) throws IOException{

		if(!dest.exists()){
			dest.getParentFile().mkdirs();
			dest.createNewFile();
		}
		InputStream fis = new BufferedInputStream(new FileInputStream(src));
		OutputStream fos = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] flush = new byte[1024];
		int len  = 0;
		while(-1 != (len = fis.read(flush))){
			fos.write(flush, 0, 11);
		}
		
		fis.close();
		fos.close();
	}
	/**
	 * 临时文件
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void fileTemp() throws IOException, InterruptedException{
		for(int i = 0; i < 10; i ++){
			File src = File.createTempFile("lll", "eeee", new File("e:/test/li"));
			Thread.sleep(2000);
			src.delete();
//			src.deleteOnExit();
		}
	}
	/**
	 * 
	 */
	public static void charCopy(){
		File src = new File("");
	}
}
