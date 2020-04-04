package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.BranchDaoImpl;
import com.lxitedu.st1610.dao.Impl.PlanDaoImpl;
import com.lxitedu.st1610.service.Impl.ExamineServiceImpl;
import com.lxitedu.st1610.vo.BranchVo;
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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		StaffVo staffVo=(StaffVo) request.getSession().getAttribute("staffVo");//登录属性对象
		//String examineType=request.getParameter("examineType");// 审核类型
		System.out.println(action);
		ExamineServiceImpl esImpl=new ExamineServiceImpl();
		PlanDaoImpl planDaoImpl=new PlanDaoImpl();
		BranchDaoImpl branchDaoImpl = new BranchDaoImpl();
		if(("examineQuery").equals(action)){
			System.out.println("进入审核筛选查询");
			String examineType=request.getParameter("examineType");
			System.out.println("审核类型:"+examineType);
			String sql1=esImpl.examinePageQuery(examineType,staffVo.getStaff_branch(),staffVo.getStaff_name());
			System.out.println(sql1);
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);	
			  ArrayList<?> list=esImpl.examinePlanQuery(p,currPageNo,examineType,staffVo.getStaff_branch(),staffVo.getStaff_name());
			  request.setAttribute("VO", p);  
			  request.setAttribute("pd", examineType);
			  request.setAttribute("list", list);
			  request.setAttribute("skip",action);
			if(("1").equals(examineType)){
				ArrayList<BranchVo> branchList = branchDaoImpl.queryBranch();
				request.setAttribute("branchList", branchList);
			}else if(("2").equals(examineType)){
			}else if(("3").equals(examineType)||("4").equals(examineType)||("5").equals(examineType)){
			}else if(("6").equals(examineType)||("7").equals(examineType)){	
//				if(("董事长").equals(staffVo.getStaff_position())||("总经理").equals(staffVo.getStaff_position())){
//					 System.out.println(list);
//					   System.out.println(p);
//					   request.setAttribute("VO", p);  
//					   request.setAttribute("planList", list);
//					   request.setAttribute("skip",action);
//					   request.getRequestDispatcher("examine.jsp").forward(request, response);
//				}else{
//					PrintWriter out = response.getWriter();
//					out.print("<script>alert('部长没有该权限！');location='examine.jsp';</script>");
//					out.close();
//				}
			}		
			request.getRequestDispatcher("examine.jsp").forward(request, response);
		}else if(("planExamineRe").equals(action)){
			String plan_id = request.getParameter("plan_id");
			String status = request.getParameter("status");
			String note = request.getParameter("note");
			String sql = "";
			if(("同意").equals(status)){
				sql="update plan set plan_result='已通过',plan_note='"+ note +"',plan_releaseTime=now() where plan_id= " + plan_id;
			}else if(("拒绝").equals(status)){
				sql="update plan set plan_result='未通过',plan_note='"+ note +"',plan_releaseTime=now() where plan_id= " + plan_id;
			}
			esImpl.audit(sql);
			request.getRequestDispatcher("examineServlet?action=examineQuery&examineType=8").forward(request, response);
		}else if(("registerExamineRe").equals(action)){
			int register_id=Integer.parseInt(request.getParameter("register_id"));
			String status = request.getParameter("status");
			String note = request.getParameter("note");
			String type = request.getParameter("type");
			String sql = "";
			if(("同意").equals(status)){
				sql="update register set register_result='已通过',register_note='"+ note +"',register_releaseTime=now() where register_id=?;";
			}else{
				sql="update register set register_result='未通过',register_note='"+ note +"',register_releaseTime=now() where register_id=?;";
			}
			esImpl.registerTypeRe(sql, register_id);
			//TODO 通知人事
			request.getRequestDispatcher("examineServlet?action=examineQuery&examineType="+type).forward(request, response);
		} else if(("meetingExamineRe").equals(action)) {
			String meet_id = request.getParameter("meet_id");
			String status = request.getParameter("status");
			String note = request.getParameter("note");
			String sql = "";
			if(("同意").equals(status)) {
				sql = "update meeting  set meeting_note = '"+note+"' ,meeting_result = '已通过'  where meeting_id = " + meet_id;
			} else {
				sql = "update meeting  set meeting_note = '"+note+"' ,meeting_result = '未通过'  where meeting_id = " + meet_id;
			}
			esImpl.audit(sql);
			request.getRequestDispatcher("examineServlet?action=examineQuery&examineType=1").forward(request, response);
		} else if(("noticeExamineRe").equals(action)) {
			String meet_id = request.getParameter("notice_id");
			String status = request.getParameter("status");
			String note = request.getParameter("note");
			String sql = "";
			if(("同意").equals(status)) {
				sql = "update notice  set notice_note = '"+note+"' ,notice_result = '已通过'  where notice_id = " + meet_id;
			} else {
				sql = "update notice  set notice_note = '"+note+"' ,notice_result = '未通过'  where notice_id = " + meet_id;
			}
			esImpl.audit(sql);
			request.getRequestDispatcher("examineServlet?action=examineQuery&examineType=2").forward(request, response);
		}
	}

}
