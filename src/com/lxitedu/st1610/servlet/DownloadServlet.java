package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//TODO �۳���Ա�Ļ���...
		

		//1)��ȡ���������ļ�
		//������ǰwebӦ�õĸ�Ŀ¼�µ��ļ�,���ؾ���·��
		/*
		String path = this.getServletContext().getRealPath("/upload/1.jpg");
		FileInputStream in = new FileInputStream(new File(path));
		*/
		
	//	String fileName = "1.jpg";
		String fileName = "������.txt";
		
		
		InputStream in = this.getServletContext().getResourceAsStream("/upload/"+fileName);
		
		/**
		 * �����ĵ��ļ�������URLEncoder����
		 *  ���������ݣ�  request ������  ->  ��������䣨URLEncoder�� -��( ��������ȡ��URLDecoder��)
			��Ӧ�������ݣ�  response ������( URLEncoder  ) -> ��������� - ��  �������ȡ(URLDecoder)
		 */
		fileName = URLEncoder.encode(fileName, "utf-8");
		/**
		 * ����һ����Ӧͷ: Content-Disposition  ��������������صķ����򿪸���Դ
		 */
		/**
		 * ע�⣺ ��ͬ���������ʶ��content-dispositionֵ�������в���
		 * 	     IE: attachment;filename=1.jpg
		 *      ��IE: attachment;filename*=1.jpg
		 */
		String userAgent = request.getHeader("user-agent");
		String content = "";
		if(userAgent.contains("Trident")){
			//IE
			content = "attachment;filename="+fileName;
		}else{
			//��IE
			content = "attachment;filename*="+fileName;
		}
		response.setHeader("content-disposition", content);

		//2)���ļ����ݷ��͸������
		OutputStream out = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while(  (len=in.read(buf))!=-1   ){
			out.write(buf, 0, len);
		}
		out.close();
		in.close();	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}