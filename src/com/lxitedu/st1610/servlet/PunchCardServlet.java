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
		int punch_staffID = Integer.parseInt(request.getParameter("punch_staffID"));//Ա�����
		String punch_staffName = request.getParameter("punch_staffName");//Ա������
		String punch_type = request.getParameter("punch_type");//����
		PrintWriter out = response.getWriter();//���ô�ӡ��
		Date punch_time = new Date();
		String punch_result="";
		if("�ϰ�".equals(punch_type)){
			 punch_result = PunchCardService.punchCard_morning(punch_staffID,punch_type,punch_time);
			 if("�����ϰ��Ѵ�".equals(punch_result)){
				/*request.getSession().setAttribute("error", punch_result);
				response.sendRedirect("punchcard.jsp");*/
				

				out.print("<script>alert('�����ϰ��Ѵ򿨣�');location='punchcard.jsp';</script>");

				out.close();
			 }else{
				 PunchVo punchVo = new PunchVo(0,punch_staffID,punch_staffName,punch_type,punch_time,punch_result);
				 PunchCardImpl punchCardImpl = new PunchCardImpl();
				 punchCardImpl.punchCard_Add(punchVo);
				 /*request.getSession().setAttribute("error", "�򿨳ɹ�������");
				 response.sendRedirect("punchcard.jsp");*/
				 out.print("<script>alert('�򿨳ɹ���');location='punchcard.jsp';</script>");

				out.close();
			 }
		}else if("�°�".equals(punch_type)){
			 punch_result = PunchCardService.punchCard_lateness(punch_staffID,punch_type,punch_time);
			 if("�����ϰ�δ��".equals(punch_result)){
			/* request.getSession().setAttribute("error", punch_result+",�޷����°࿨");
			 response.sendRedirect("punchcard.jsp");*/
			 
			 out.print("<script>alert('�����ϰ�δ�򿨣��޷����°࿨��');location='punchcard.jsp';</script>");

			out.close();
			 }else if("�����°��Ѵ�".equals(punch_result)){
				/* request.getSession().setAttribute("error", punch_result+",�����ٴδ�");
				 response.sendRedirect("punchcard.jsp");*/
				 
				out.print("<script>alert('�����°��Ѵ򿨣������ٴδ򿨣�');location='punchcard.jsp';</script>");

				out.close();
			 }else{
				 PunchVo punchVo = new PunchVo(0,punch_staffID,punch_staffName,punch_type,punch_time,punch_result);
				 PunchCardImpl punchCardImpl = new PunchCardImpl();
				 punchCardImpl.punchCard_Add(punchVo);
				 /*request.getSession().setAttribute("error", "�򿨳ɹ�������");
				 response.sendRedirect("punchcard.jsp");*/
				 
				 out.print("<script>alert('�򿨳ɹ�����');location='punchcard.jsp';</script>");

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
