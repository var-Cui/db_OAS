package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.PlanDaoImpl;
import com.lxitedu.st1610.service.Impl.ExamineServiceImpl;
import com.lxitedu.st1610.vo.PageVo;
import com.lxitedu.st1610.vo.StaffVo;

/**
 * Servlet implementation class ExamineServlet
 */
public class ExamineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		StaffVo staffVo=(StaffVo) request.getSession().getAttribute("staffVo");//登录属性对象
		//String examineType=request.getParameter("examineType");// 审核类型
		System.out.println(action);
		ExamineServiceImpl esImpl=new ExamineServiceImpl();
		PlanDaoImpl planDaoImpl=new PlanDaoImpl();
		if(("examineQuery").equals(action)){
			System.out.println("进入审核筛选查询");
			String examineType=request.getParameter("examineType");
			System.out.println("审核类型:"+examineType);
			String sql1=esImpl.examinePageQuery(examineType,staffVo.getStaff_branch());
			System.out.println(sql1);
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);	
			  ArrayList<?> list=esImpl.examinePlanQuery(p,currPageNo,examineType,staffVo.getStaff_branch());
			if(("1").equals(examineType)){
			}else if(("2").equals(examineType)){
			}else if(("3").equals(examineType)||("4").equals(examineType)||("5").equals(examineType)){
				   System.out.println(list);
				   System.out.println(p);
				   request.setAttribute("VO", p);  
				   request.setAttribute("registerList", list);
				   request.setAttribute("skip",action);
				   request.setAttribute("pd", examineType);
				   request.getRequestDispatcher("examine.jsp").forward(request, response);
			}else if(("6").equals(examineType)||("7").equals(examineType)){	
				if(("董事长").equals(staffVo.getStaff_position())||("总经理").equals(staffVo.getStaff_position())){
					 System.out.println(list);
					   System.out.println(p);
					   request.setAttribute("VO", p);  
					   request.setAttribute("planList", list);
					   request.setAttribute("skip",action);
					   request.setAttribute("pd", examineType);
					   request.getRequestDispatcher("examine.jsp").forward(request, response);
				}else{
					PrintWriter out = response.getWriter();

					out.print("<script>alert('部长没有该权限！');location='examine.jsp';</script>");

					out.close();
				}
				  
			}			  			   
		}else if(("planExamineRe").equals(action)){
			System.out.println("计划审核操作");
			String id=request.getParameter("plan_id");
			int plan_id=0;
			if(id!=null){
				plan_id=Integer.parseInt(id);
			}			
			System.out.println("要修改的ID:"+plan_id);
			String planT=request.getParameter("planT");//提交的判断  是同意还是拒绝
			System.out.println(planT);
			String yy="没有标注原因";
			String note=request.getParameter("note");//
			if((note != null)||!("").equals(note)){
				yy=note;
			}
			System.out.println(yy);
			if(("同意").equals(planT)){
				System.out.println("进来没有");
				String sql="update plan set plan_result='已通过',plan_assentor='"+staffVo.getStaff_name()+"',plan_note='"+yy+"',plan_releaseTime=now() where plan_id=?;";
				System.out.println(sql);
				esImpl.planTypeRe(sql, plan_id);
				System.out.println("执行完成");
				   request.getRequestDispatcher("examineServlet?action=examineQuery&examineType=6").forward(request, response);
			}else if(("拒绝").equals(planT)){
				String sql="update plan set plan_result='未通过',plan_assentor='"+staffVo.getStaff_name()+"',plan_note='"+yy+"',plan_releaseTime=now() where plan_id=?;";
				System.out.println(sql);
				esImpl.planTypeRe(sql, plan_id);
				   request.getRequestDispatcher("examineServlet?action=examineQuery&examineType=6").forward(request, response);
			}

		}else if(("registerExamineRe").equals(action)){
			System.out.println("考勤审核操作");
			int register_id=Integer.parseInt(request.getParameter("register_id"));
			System.out.println("要修改的ID:"+register_id);
			String registerT=request.getParameter("registerT");//提交的判断  是同意还是拒绝
			System.out.println(registerT);
			String yy="没有标注原因";
			String note=request.getParameter("note");//
			if((note != null)||!("").equals(note)){
				yy=note;
			}
			System.out.println(yy);
			if(("同意").equals(registerT)){
				System.out.println("进来没有");
				String sql="update register set register_result='已通过',register_note='"+yy+"',register_releaseTime=now(),register_assentor='"+staffVo.getStaff_name()+"' where register_id=?;";
				System.out.println(sql);
				esImpl.registerTypeRe(sql, register_id);
				System.out.println("执行完成");
				   request.getRequestDispatcher("examineServlet?action=examineQuery&examineType=3").forward(request, response);
			}else{
				System.out.println("近来没有");
				String sql="update register set register_result='未通过',register_note='"+yy+"',register_releaseTime=now(),register_assentor='"+staffVo.getStaff_name()+"' where register_id=?;";
				System.out.println(sql);
				esImpl.registerTypeRe(sql, register_id);
				System.out.println("执行完成");
				   request.getRequestDispatcher("examineServlet?action=examineQuery&examineType=3").forward(request, response);
			}
		}
	}

}
