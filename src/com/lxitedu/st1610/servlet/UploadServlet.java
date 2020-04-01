package com.lxitedu.st1610.servlet;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class commonsServelet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filePath = "D:\\Java Base\\eclipse\\db_OAS\\WebContent\\upload";
    private String tempPath="F:\\temp"; 
   
    Logger log  = Logger.getLogger(UploadServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
     


	@Override


    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath = this.getServletContext().getRealPath("/uploadFile");
		File file = new File(savePath);
		if(!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);//outputStream
		upload.setSizeMax(15*1024*1024);
		try {
			List<FileItem> items = upload.parseRequest(request);
			if(items != null) {
				for (FileItem fileItem : items) {
					if(fileItem.isFormField()) {
					} else {
						String fileName = new File(fileItem.getName()).getName();
						fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
		                String filePath = savePath+"\\"+fileName;
		                System.err.println(filePath);
						InputStream in = fileItem.getInputStream();
	                    OutputStream out = new FileOutputStream(filePath);
	                    byte b[] = new byte[1024];
	                    int len = -1;
	                    while((len=in.read(b))!=-1){
	                        out.write(b, 0, len);
	                    }
	                    //关闭流
	                    out.close();
	                    in.close();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
		
//		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//		int num = path.indexOf(".metadata");
//		String realPath = path.substring(1,num).replace('/', '\\')+"db_OAS\\WebContent\\uploadFile";
//		System.err.println(realPath);
//		File f = new File(realPath);
//        if(!f.exists()&&!f.isDirectory()){
//            f.mkdir();
//        }
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		ServletFileUpload upload = new ServletFileUpload(factory);//outputStream
//		upload.setSizeMax(15*1024*1024);
//		
//		Map<String, List<FileItem>> parseParameterMap;
//		try {
//			parseParameterMap = upload.parseParameterMap(request);
//			Set<Entry<String, List<FileItem>>> entrySet = parseParameterMap.entrySet();
//			
//			for (Entry<String, List<FileItem>> entry : entrySet) {
//				List<FileItem> file = entry.getValue();
//				for(FileItem fileItem : file) {
//					String name = fileItem.getName();
//					if(name == null || "".equals(name) ) {
//						return;
//					}
//					name = name.substring(name.lastIndexOf("\\")+1);
//	                String filePath = realPath+"\\"+name;
//	                InputStream in = fileItem.getInputStream();
//                    OutputStream out = new FileOutputStream(filePath);
//                       
//                    byte b[] = new byte[1024];
//                    int len = -1;
//                    while((len=in.read(b))!=-1){
//                        out.write(b, 0, len);
//                    }
//                    //关闭流
//                    out.close();
//                    in.close();
//				}
//			}
//		} catch (FileUploadException e) {
//			throw new RuntimeException("服务器繁忙，文件上传失败");
//		}
	}
	
	private void processUploadFile(FileItem item ,PrintWriter pw) {
		String fileName = item.getName();
		log.info("文件名："+fileName);
		File uploadFile = new File(filePath+"\\"+fileName);
		try {
			uploadFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean flag = true;
		try {
			item.write(uploadFile);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
			pw.println("文件上传失败：");
		}
		if(flag)
			try {
				Thread.sleep(2000);
				item.delete();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		pw.println(fileName+"文件上传完毕：");
		
	}
	


}

