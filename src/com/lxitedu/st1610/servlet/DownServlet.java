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
		//2.��ȡҪ���ص��ļ���
		String fileName = path.substring(path.lastIndexOf(File.separator)+1);
		//3.����content-disposition��Ӧͷ��������������ص���ʽ���ļ�
		//����context-disposition��Ӧͷ�������������������ʽ�򿪣�����ע���ļ��ַ��������ʽ������utf-8����Ȼ���������
		response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));
		//4.��ȡҪ���ص��ļ�������
		//�ַ���������FileReader in = new FileReader(path);
		InputStream in=new FileInputStream(path);
		int len=0;
		//5.�������ݻ�����
		//�ַ�����������char[] buffer = new char[1024];
		byte[] buffer = new byte[1024];
		//6.ͨ��response�����ȡOutputStream��
		//��д�ļ����ع���ʱ�Ƽ�ʹ��OutputStream��������ʹ��PrintWriter����
		//��ΪOutputStream�����ֽ��������Դ����������͵����ݣ�
		//��PrintWriter�����ַ�����ֻ�ܴ����ַ����ݣ�������ַ��������ֽ����ݣ��ᵼ�����ݶ�ʧ
		//�ַ���д������PrintWriter out = response.getWriter();
		ServletOutputStream out = response.getOutputStream();
		//7.��FileInputStream��д�뵽buffer������
		while((len=in.read(buffer))!=-1){
			//8.ʹ��OutputStream��������������������ͻ��������
			out.write(buffer, 0, len);
		}
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
