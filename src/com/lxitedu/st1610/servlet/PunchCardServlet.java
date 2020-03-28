package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.PunchCardImpl;
import com.lxitedu.st1610.service.Impl.PunchCardService;
import com.lxitedu.st1610.vo.PunchVo;

/**
 * Servlet implementation class punchCardServlet
 */
public class PunchCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PunchCardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int punch_staffID = Integer.parseInt(request.getParameter("punch_staffID"));//员工编号
		String punch_staffName = request.getParameter("punch_staffName");//员工姓名
		String punch_type = request.getParameter("punch_type");//类型
		PrintWriter out = response.getWriter();//配置打印流
		Date punch_time = new Date();
		String punch_result="";
		if("上班".equals(punch_type)){
			 punch_result = PunchCardService.punchCard_morning(punch_staffID,punch_type,punch_time);
			 if("今日上班已打卡".equals(punch_result)){
				/*request.getSession().setAttribute("error", punch_result);
				response.sendRedirect("punchcard.jsp");*/
				

				out.print("<script>alert('今日上班已打卡！');location='punchcard.jsp';</script>");

				out.close();
			 }else{
				 PunchVo punchVo = new PunchVo(0,punch_staffID,punch_staffName,punch_type,punch_time,punch_result);
				 PunchCardImpl punchCardImpl = new PunchCardImpl();
				 punchCardImpl.punchCard_Add(punchVo);
				 /*request.getSession().setAttribute("error", "打卡成功！！！");
				 response.sendRedirect("punchcard.jsp");*/
				 out.print("<script>alert('打卡成功！');location='punchcard.jsp';</script>");

				out.close();
			 }
		}else if("下班".equals(punch_type)){
			 punch_result = PunchCardService.punchCard_lateness(punch_staffID,punch_type,punch_time);
			 if("今日上班未打卡".equals(punch_result)){
			/* request.getSession().setAttribute("error", punch_result+",无法打下班卡");
			 response.sendRedirect("punchcard.jsp");*/
			 
			 out.print("<script>alert('今日上班未打卡，无法打下班卡！');location='punchcard.jsp';</script>");

			out.close();
			 }else if("今日下班已打卡".equals(punch_result)){
				/* request.getSession().setAttribute("error", punch_result+",无需再次打卡");
				 response.sendRedirect("punchcard.jsp");*/
				 
				out.print("<script>alert('今日下班已打卡，无需再次打卡！');location='punchcard.jsp';</script>");

				out.close();
			 }else{
				 PunchVo punchVo = new PunchVo(0,punch_staffID,punch_staffName,punch_type,punch_time,punch_result);
				 PunchCardImpl punchCardImpl = new PunchCardImpl();
				 punchCardImpl.punchCard_Add(punchVo);
				 /*request.getSession().setAttribute("error", "打卡成功！！！");
				 response.sendRedirect("punchcard.jsp");*/
				 
				 out.print("<script>alert('打卡成功！！');location='punchcard.jsp';</script>");

				out.close();
			 }
			 
		}
		
		//System.out.println(punch_staffID+" === "+punch_staffName+" ==== "+punch_type+" === "+time+"===str"+str+" === date"+date);
		System.out.println(punch_result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
