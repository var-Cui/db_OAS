package com.lxitedu.st1610.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.NoticeDaoImpl;
import com.lxitedu.st1610.vo.NoticeVo;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NoticeDaoImpl noticeDaoImpl=new NoticeDaoImpl();
		String id = request.getParameter("id");
		NoticeVo noticeVo = noticeDaoImpl.queryNoticeTypeOne(id);
		String name = noticeVo.getFile_name();
		String filePath = id + File.separator +name;
		String path = request.getServletContext().getRealPath("/uploadFile");
		path += File.separator + filePath;
		//2.获取要下载的文件名
		String fileName = path.substring(path.lastIndexOf(File.separator)+1);
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		//设置context-disposition响应头，控制浏览器以下载形式打开，这里注意文件字符集编码格式，设置utf-8，不然会出现乱码
		response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
		//4.获取要下载的文件输入流
		//字符流输入流FileReader in = new FileReader(path);
		InputStream in=new FileInputStream(path);
		int len=0;
		//5.创建数据缓冲区
		//字符流缓冲区：char[] buffer = new char[1024];
		byte[] buffer = new byte[1024];
		//6.通过response对象获取OutputStream流
		//编写文件下载功能时推荐使用OutputStream流，避免使用PrintWriter流，
		//因为OutputStream流是字节流，可以处理任意类型的数据，
		//而PrintWriter流是字符流，只能处理字符数据，如果用字符流处理字节数据，会导致数据丢失
		//字符流写入流：PrintWriter out = response.getWriter();
		ServletOutputStream out = response.getOutputStream();
		//7.将FileInputStream流写入到buffer缓冲区
		while((len=in.read(buffer))!=-1){
			//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
