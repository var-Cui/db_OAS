package cn.lxitedu.st1610.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.fileupload.FileItem;

public class FileUtils {
	
	public static void uploadFile(String path,String fileName,FileItem fileItem) {
		File file = new File(path);
		if(file.exists()) {
			File[] listFiles = file.listFiles();
			if(listFiles != null) {
				for (File file2 : listFiles) {
					if(file2.isFile()) {
						file2.delete();
					}
				}
			}
		}
		if(!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
	    InputStream in;
		try {
			String filePath = path+File.separator+fileName;
			in = fileItem.getInputStream();
			OutputStream out = new FileOutputStream(filePath);
			byte b[] = new byte[1024];
			int len = -1;
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
