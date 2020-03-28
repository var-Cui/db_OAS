package com.lxitedu.st1610.servlet;




import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;




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
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		DiskFileItemFactory factory = new DiskFileItemFactory(4*1024, new File(tempPath));
		//为了接收jsp上传过来的inputStream
		//fileupload对象
		ServletFileUpload upload = new ServletFileUpload(factory);//outputStream
		upload.setSizeMax(15*1024*1024);
		try {
			if(upload.isMultipartContent(request)){//判断是否是文件上传表单
				List fileItems = upload.parseRequest(request); //request.getInputStream
				Iterator<FileItem> it = fileItems.iterator();
				while (it.hasNext()) {
					FileItem item = it.next();
					processUploadFile(item,pw);
					pw.close();
				}
			}else{
				log.info("文件不对");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


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

