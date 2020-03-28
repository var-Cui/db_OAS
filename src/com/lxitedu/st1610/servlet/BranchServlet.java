package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.BranchDaoImpl;
import com.lxitedu.st1610.vo.BranchVo;


/**
 * Servlet implementation class BranchServlet
 */
public class BranchServlet extends HttpServlet {
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
		if("add".equals(action)){
			
			String branch_name = request.getParameter("branch_name");
			String branch_minister=request.getParameter("branch_minister");
			String branch_summarize=request.getParameter("branch_summarize");
			
			String branch_time=request.getParameter("branch_time");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				 time=(Date)sdf.parse(branch_time);
				 System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("拿到的值："+branch_name+"\t部长："+branch_minister+"\t描述："+branch_summarize+"\t时间："+branch_time);
		try {
			BranchVo branchVo=new BranchVo();
			branchVo.setBranch_name(branch_name);
			branchVo.setBranch_minister(branch_minister);
			branchVo.setBranch_summarize(branch_summarize);
			branchVo.setBranch_time(time);
			
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			branchDaoImpl.insertBranch(branchVo);
			
			System.out.println("增加部门成功！！！");
			 response.sendRedirect("branchServlet?action=query");
		} catch (Exception e) {
			// TODO: handle exception
		}
		}else if("delete".equals(action)){
			System.out.println("部门删除>>>>");
			int id = Integer.parseInt(request.getParameter("branch_id"));
			System.out.println("id="+id);
			
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			branchDaoImpl.deleteBranch(id);
			
			System.out.println("\n删除部门成功！！！");
			response.sendRedirect("branchServlet?action=query");
		}else if("update".equals(action)){
			System.out.println("部门修改servlet，进来没有？？？");
			int branch_id=Integer.parseInt(request.getParameter("branch_id"));
			String branch_name = request.getParameter("branch_name");
			String branch_minister=request.getParameter("branch_minister");
			String branch_summarize=request.getParameter("branch_summarize");
			
			String branch_time=request.getParameter("branch_time");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				 time=(Date)sdf.parse(branch_time);
				 System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("拿到的值："+branch_name+"\t部长："+branch_minister+"\t描述："+branch_summarize+"\t时间："+branch_time);
		try {
			BranchVo branchVo=new BranchVo();
			branchVo.setBranch_name(branch_name);
			branchVo.setBranch_minister(branch_minister);
			branchVo.setBranch_summarize(branch_summarize);
			branchVo.setBranch_time(time);
			branchVo.setBranch_id(branch_id);
			
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			branchDaoImpl.updateBranch(branchVo);;
			
			System.out.println("修改部门成功！！！");
			 response.sendRedirect("branchServlet?action=query");
		} catch (Exception e) {
			// TODO: handle exception
		}
		}else if("query".equals(action)){
			System.out.println("进入部门查询》》》");
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			ArrayList<BranchVo> list=branchDaoImpl.queryBranch();
	 		request.setAttribute("list", list);
	 		request.getRequestDispatcher("branch_list.jsp").forward(request, response);
		}else if("staffAdd".equals(action)){
			System.out.println("进入员工增加查询》》》");
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			ArrayList<BranchVo> list=branchDaoImpl.queryBranch();
	 		request.setAttribute("list", list);
	 		request.getRequestDispatcher("staff_add.jsp").forward(request, response);
		}else if("staffUpdate".equals(action)){
			System.out.println("进入员工修改查询》》》");
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			ArrayList<BranchVo> list=branchDaoImpl.queryBranch();
	 		request.setAttribute("lists", list);
	 		request.getRequestDispatcher("staff_edit.jsp").forward(request, response);
		}else if("queryName".equals(action)){
			
			byte [] bytes=request.getParameter("branch_name").getBytes("ISO-8859-1");
			String result=new String(bytes,"UTF-8");
			
			System.out.println("看看这是什么：："+result);
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			BranchVo branchVo=branchDaoImpl.queryBranchName(result);
			request.setAttribute("result", branchVo);
			request.getRequestDispatcher("branch_edit.jsp").forward(request, response);
		}
	}

}
