package webproject.net.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class server {
	public static void main(String[] args) {
//		decrypt("F:/项目/APIインターフェイス仕様書（統合ID管理）_v1.83.zip","F:/项目/test.zip");
		joinPro(new File("F:/项目/test2"),new  File("F:/项目/APIインターフェイス仕様書（統合ID管理）_v1.80.xlsx"),new File("F:/项目/APIインターフェイス仕様書（統合ID管理）_v1.81.xlsx"));
		System.out.println("成功");
	}

	public static void decrypt(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int len = -1;
			while ((len = fis.read())!=-1){
				fos.write(len^0xff);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				if(fis != null){
					fis.close();
				}
				if(fos!= null){
					fos.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public static void joinPro(File destFile,File... files){
		int len = files.length;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(destFile);
			for(int i = 0 ;i < len ;i ++){
					FileInputStream fis = new FileInputStream(files[i]);
					int len1 = -1;
					while ((len1 = fis.read())!= -1){
						fos.write(len1^0xff);
					}
					fis.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
