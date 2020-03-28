package com.lxitedu.st1610.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.me_staff_Dao_Impl;
import com.lxitedu.st1610.dao.Impl.message_Dao_Impl;
import com.lxitedu.st1610.vo.me_staff_VO;
import com.lxitedu.st1610.vo.message_VO;

/**
 * Servlet implementation class message_view
 */
public class Message_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Message_view() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		 message_Dao_Impl md = new message_Dao_Impl();
		  String id =new String(request.getParameter("id").getBytes("iso-8859-1"),"UTF-8");
		  message_VO uv = (message_VO)md.message_Query(id);
		  request.setAttribute("view", uv);
		  if("query".equals(request.getParameter("name"))){
			  request.getRequestDispatcher("message_view.jsp").forward(request,response);
		}else if("update".equals(request.getParameter("name"))){
			  request.getRequestDispatcher("message_update.jsp").forward(request,response);
		}
	}

}
