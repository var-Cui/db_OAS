package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.service.Impl.RegisterTwoService;
import com.lxitedu.st1610.vo.PunchVo;
import com.lxitedu.st1610.vo.RegisterVo;
import com.lxitedu.st1610.vo.StaffVo;

/**
 * Servlet implementation class RegisterTwoServlet
 */
public class RegisterTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		StaffVo staffVo=(StaffVo) request.getSession().getAttribute("staffVo");
		String type = request.getParameter("type");
		String typeTwo = request.getParameter("punchType");
		String select = request.getParameter("select");
		RegisterTwoService rts = new RegisterTwoService();
		if("punch".equals(select)){
			if("个人".equals(type)||"".equals(type)||type==null){	
				List<PunchVo> punchVoList = rts.personage_Punch(staffVo.getStaff_num());
				request.getSession().setAttribute("punchVoList", punchVoList);
				response.sendRedirect("register_list.jsp");
			}else if("全部".equals(type)){
				List<PunchVo> punchVoList = rts.punchQuery();
				request.getSession().setAttribute("punchVoList", punchVoList);
				response.sendRedirect("register_list.jsp");
			}else if("员工编号".equals(type)){
				List<PunchVo> punchVoList = rts.punchQuery_Num(typeTwo);
				request.getSession().setAttribute("punchVoList", punchVoList);
				response.sendRedirect("register_list.jsp");
			}else if("员工名称".equals(type)){
				List<PunchVo> punchVoList =rts.punchQuery_Name(typeTwo);
				request.getSession().setAttribute("punchVoList", punchVoList);
				response.sendRedirect("register_list.jsp");
			}else if("部门名称".equals(type)){
				List<PunchVo> punchVoList = rts.punchQuery_branch(typeTwo);
				request.getSession().setAttribute("punchVoList", punchVoList);
				response.sendRedirect("register_list.jsp");
			}else{
				List<PunchVo> punchVoList = rts.personage_Punch(staffVo.getStaff_num());
				request.getSession().setAttribute("punchVoList", punchVoList);
				response.sendRedirect("register_list.jsp");
			}
		}else if("register".equals(select)){
			if("个人".equals(type)||"".equals(type)||type==null){	
				List<RegisterVo> registerVoList = rts.personage(staffVo.getStaff_num());
				request.getSession().setAttribute("registerVoList", registerVoList);
				response.sendRedirect("registerTwo_list.jsp");
			}else if("全部".equals(type)||"".equals(type)||type==null){
				List<RegisterVo> registerVoList = rts.personage_all();
				request.getSession().setAttribute("registerVoList", registerVoList);	
				response.sendRedirect("registerTwo_list.jsp");
			}else if("员工编号".equals(type)){
				List<RegisterVo> registerVoList = rts.personage_num(typeTwo);
				request.getSession().setAttribute("registerVoList", registerVoList);	
				response.sendRedirect("registerTwo_list.jsp");
	
			}else if("员工名称".equals(type)){
				List<RegisterVo> registerVoList = rts.personage_name(typeTwo);
				request.getSession().setAttribute("registerVoList", registerVoList);	
				response.sendRedirect("registerTwo_list.jsp");
		
			}else if("部门".equals(type)){
				List<RegisterVo> registerVoList = rts.personage_branch(typeTwo);
				request.getSession().setAttribute("registerVoList", registerVoList);	
				response.sendRedirect("registerTwo_list.jsp");
			}else{
				List<RegisterVo> registerVoList = rts.personage(staffVo.getStaff_num());
				request.getSession().setAttribute("registerVoList", registerVoList);
				response.sendRedirect("registerTwo_list.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
