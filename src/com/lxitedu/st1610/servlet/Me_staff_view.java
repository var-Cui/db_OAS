package com.lxitedu.st1610.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.me_staff_Dao_Impl;
import com.lxitedu.st1610.vo.me_staff_VO;

/**
 * Servlet implementation class me_staff_view
 */
public class Me_staff_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Me_staff_view() {
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
		 me_staff_Dao_Impl md = new me_staff_Dao_Impl();
		  String id =new String(request.getParameter("id").getBytes("iso-8859-1"),"UTF-8");
		  me_staff_VO uv = (me_staff_VO)md.query_sole(id);
		  request.setAttribute("view", uv);
		  if("query".equals(request.getParameter("name"))){
			  request.getRequestDispatcher("me_staff_view.jsp").forward(request,response);
		}else if("update".equals(request.getParameter("name"))){
			  request.getRequestDispatcher("me_staff_update.jsp").forward(request,response);
		}
	}

}
