package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.BranchDaoImpl;
import com.lxitedu.st1610.dao.Impl.RegisterImpl;
import com.lxitedu.st1610.vo.RegisterVo;
import com.lxitedu.st1610.vo.StaffVo;


/**
 * Servlet implementation class registerServlet
 */
public class RegisterServlet extends HttpServlet {
//	private Logger log = Logger.getLogger(RegisterServlet.class); 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BranchDaoImpl branchDaoImpl = new BranchDaoImpl();
		request.setCharacterEncoding("UTF-8");
		int register_staffNum = Integer.parseInt(request.getParameter("register_staffNum"));//Ա�����
		String register_name = request.getParameter("register_name");//Ա������
		String register_branch = request.getParameter("register_branch");//Ա����������
		String register_type = request.getParameter("register_type");//��������
		String register_reason = request.getParameter("register_reason");//ԭ��
		String type = request.getParameter("type");
		System.out.println(type);
		Date register_startTime = null ;
		Date register_endTime = null ;
		Date date = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			register_startTime = (Date) sdf.parse(request.getParameter("register_startTime"));
			register_endTime = (Date) sdf.parse(request.getParameter("register_endTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		RegisterImpl registerImpl = new RegisterImpl(); 
		String register_assentor="";//��ȡ�����ϼ�����
		String register_result="";
		StaffVo staffVo = (StaffVo) request.getSession().getAttribute("staffVo");//��¼���Զ���
		if("��ͨԱ��".equals(staffVo.getStaff_position())) {
			register_result = "�����";
			register_assentor = branchDaoImpl.queryBranchMinister(staffVo.getStaff_branch());
		}
		RegisterVo registerVo = new RegisterVo(0,register_staffNum,register_name,register_branch,register_type,register_reason
				,register_startTime,register_endTime, register_assentor,register_result,null,date);
		registerImpl.registerAdd(registerVo);
		PrintWriter out = response.getWriter();
		if("register_leave".equals(type)){
			out.print("<script>alert('�ύ�ɹ���');location='register_leave.jsp';</script>");
			out.close();
		}else if("register_evection".equals(type)){
			out.print("<script>alert('�ύ�ɹ���');location='register_evection.jsp';</script>");
			out.close();
		}else if("register_outercome".equals(type)){
		
			out.print("<script>alert('�ύ�ɹ���');location='register_outercome.jsp';</script>");
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
