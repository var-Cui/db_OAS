package com.lxitedu.st1610.servlet;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.message_Dao;
import com.lxitedu.st1610.dao.Impl.message_Dao_Impl;
import com.lxitedu.st1610.vo.Page_VO;
import com.lxitedu.st1610.vo.me_staff_VO;
import com.lxitedu.st1610.vo.message_VO;

/**
 * Servlet implementation class message_Servlet
 */
public class Message_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public message_Dao message_dao =null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println("action="+action);
		if(action==null||"".equals(action)){
			System.out.println(" ‰»Î”–ŒÛ");
		}else if("add".equals(action)){
			add(request,response);
		}else if("del".equals(action)){
			del(request,response);
		}else if("query".equals(action)){
			query(request,response);
		}else if("update".equals(action)){
			update(request,response);
		}
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		message_VO mv = new message_VO();
		mv.setMessage_id(new Integer(request.getParameter("message_id")));
		mv.setMessage_name(new String(request.getParameter("message_name").getBytes("iso-8859-1"),"UTF-8"));
		message_Dao md = new message_Dao_Impl();
		md.Message_add(mv);
		response.sendRedirect("message_list.jsp"); 
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException{
		message_Dao md = new message_Dao_Impl();
		System.out.println(request.getParameter("id"));
		md.Message_del(request.getParameter("id"));
		response.sendRedirect("message_list.jsp");
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<message_VO> mv = new ArrayList<message_VO>();
		Page_VO page =new Page_VO();
		message_Dao_Impl md = new message_Dao_Impl();
		String currentPage = request.getParameter("pageIndex");
		if(currentPage == null){
		     currentPage = "0";
		}    
		page.setCurrentPage(Integer.parseInt(currentPage));
		page=(Page_VO) md.page_Query(page);
		request.setAttribute("list", page);
		request.getRequestDispatcher("message_list.jsp").forward(request,response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String message_id =request.getParameter("message_id");
		String message_name = request.getParameter("message_name");
		message_Dao_Impl md = new message_Dao_Impl();
		message_VO mv = new message_VO();
		mv.setMessage_id(new Integer(message_id));
		mv.setMessage_name(new String(request.getParameter("message_name").getBytes("iso-8859-1"),"UTF-8"));
		md.Message_update(mv);
		response.sendRedirect("message_list.jsp");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
