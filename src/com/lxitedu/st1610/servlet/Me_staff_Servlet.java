package com.lxitedu.st1610.servlet;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.lxitedu.st1610.dao.me_staff_Dao;
import com.lxitedu.st1610.dao.message_Dao;
import com.lxitedu.st1610.dao.Impl.me_staff_Dao_Impl;
import com.lxitedu.st1610.dao.Impl.message_Dao_Impl;
import com.lxitedu.st1610.vo.me_staff_VO;

/**
 * Servlet implementation class me_staff_Servlet
 */
public class Me_staff_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public me_staff_Dao  me_staff_dao =null;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<me_staff_VO> mv = new ArrayList<me_staff_VO>();
		me_staff_Dao_Impl md = new me_staff_Dao_Impl();
		String name= new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
		mv=(ArrayList<me_staff_VO>) md.me_staff_Query(name);
		request.setAttribute("mv", mv);
		request.getRequestDispatcher("me_staff_list.jsp").forward(request,response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String me_staff_id = new String(request.getParameter("me_staff_id"));
		String me_staff_name = new String(request.getParameter("me_staff_name").getBytes("iso-8859-1"),"UTF-8");
		String me_staff_branch = new String(request.getParameter("me_staff_branch").getBytes("iso-8859-1"),"UTF-8");
		String me_staff_message = new String(request.getParameter("me_staff_message").getBytes("iso-8859-1"),"UTF-8");
		String me_staff_address = new String(request.getParameter("me_staff_address").getBytes("iso-8859-1"),"UTF-8");
		String me_staff_phone = new String(request.getParameter("me_staff_phone").getBytes("iso-8859-1"),"UTF-8");
		
		me_staff_VO mv = new me_staff_VO();
		mv.setMe_staff_id(new Integer(me_staff_id));
		mv.setMe_staff_name(me_staff_name);
		mv.setMe_staff_branch(me_staff_branch);
		mv.setMe_staff_message(me_staff_message);
		mv.setMe_staff_address(me_staff_address);
		mv.setMe_staff_phone(me_staff_phone);
		me_staff_Dao_Impl md = new me_staff_Dao_Impl();
		md.Me_staff_update(mv);
		response.sendRedirect("me_staff_list.jsp");
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException{
		me_staff_Dao_Impl md = new me_staff_Dao_Impl();
		System.out.println("====="+request.getParameter("id"));
		md.Me_staff_del(new String(request.getParameter("id").getBytes("iso-8859-1"),"UTF-8"));
		response.sendRedirect("me_staff_list.jsp");
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException{
		me_staff_VO mv = new me_staff_VO();
		mv.setMe_staff_id(new Integer(request.getParameter("me_staff_id")) );
		mv.setMe_staff_name(new String(request.getParameter("me_staff_name").getBytes("iso-8859-1"),"UTF-8"));
		mv.setMe_staff_branch(new String(request.getParameter("me_staff_branch").getBytes("iso-8859-1"),"UTF-8"));
		mv.setMe_staff_message(new String(request.getParameter("me_staff_message").getBytes("iso-8859-1"),"UTF-8"));
		mv.setMe_staff_address(new String(request.getParameter("me_staff_address").getBytes("iso-8859-1"),"UTF-8"));
		mv.setMe_staff_phone(new String(request.getParameter("me_staff_phone").getBytes("iso-8859-1"),"UTF-8"));
		me_staff_Dao md = new me_staff_Dao_Impl();
		md.Me_staff_add(mv);
		response.sendRedirect("me_staff_list.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
