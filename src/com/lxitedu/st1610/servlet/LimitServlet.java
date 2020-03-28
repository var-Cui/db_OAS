package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.StaffDaoImpl;
import com.lxitedu.st1610.vo.PageVo;
import com.lxitedu.st1610.vo.StaffVo;


/**
 * Servlet implementation class LimitServlet
 */
public class LimitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String action=request.getParameter("action");//获取操作符
		if("staffVo".equals(action)){
			System.out.println("进来没有1111");
			
			StaffDaoImpl staffVoImpl = new StaffDaoImpl();
			 PageVo p = new PageVo();
			   p.setTotalCount(staffVoImpl.getPageCount());
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);
			  int no=0;
			  if(null==currPageNo)
			  {
				  no=1;
			  }
			  else{
				no= Integer.parseInt(currPageNo);
			  }
			   p.setCurrPageNo(no);
			   ArrayList<StaffVo>list = (ArrayList<StaffVo>) staffVoImpl.getList(no, p.getPageSize());
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("list", list);
			   
			
			  request.getRequestDispatcher("staff_list.jsp").forward(request, response);
		}else if("delete".equals(action)){
			
		}else if("update".equals(action)){
			
		}else if("query".equals(action)){
			
		}
	}

}
