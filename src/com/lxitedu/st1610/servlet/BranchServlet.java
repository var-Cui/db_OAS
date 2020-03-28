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
		String action=request.getParameter("action");//��ȡ������
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
			
			System.out.println("�õ���ֵ��"+branch_name+"\t������"+branch_minister+"\t������"+branch_summarize+"\tʱ�䣺"+branch_time);
		try {
			BranchVo branchVo=new BranchVo();
			branchVo.setBranch_name(branch_name);
			branchVo.setBranch_minister(branch_minister);
			branchVo.setBranch_summarize(branch_summarize);
			branchVo.setBranch_time(time);
			
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			branchDaoImpl.insertBranch(branchVo);
			
			System.out.println("���Ӳ��ųɹ�������");
			 response.sendRedirect("branchServlet?action=query");
		} catch (Exception e) {
			// TODO: handle exception
		}
		}else if("delete".equals(action)){
			System.out.println("����ɾ��>>>>");
			int id = Integer.parseInt(request.getParameter("branch_id"));
			System.out.println("id="+id);
			
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			branchDaoImpl.deleteBranch(id);
			
			System.out.println("\nɾ�����ųɹ�������");
			response.sendRedirect("branchServlet?action=query");
		}else if("update".equals(action)){
			System.out.println("�����޸�servlet������û�У�����");
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
			
			System.out.println("�õ���ֵ��"+branch_name+"\t������"+branch_minister+"\t������"+branch_summarize+"\tʱ�䣺"+branch_time);
		try {
			BranchVo branchVo=new BranchVo();
			branchVo.setBranch_name(branch_name);
			branchVo.setBranch_minister(branch_minister);
			branchVo.setBranch_summarize(branch_summarize);
			branchVo.setBranch_time(time);
			branchVo.setBranch_id(branch_id);
			
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			branchDaoImpl.updateBranch(branchVo);;
			
			System.out.println("�޸Ĳ��ųɹ�������");
			 response.sendRedirect("branchServlet?action=query");
		} catch (Exception e) {
			// TODO: handle exception
		}
		}else if("query".equals(action)){
			System.out.println("���벿�Ų�ѯ������");
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			ArrayList<BranchVo> list=branchDaoImpl.queryBranch();
	 		request.setAttribute("list", list);
	 		request.getRequestDispatcher("branch_list.jsp").forward(request, response);
		}else if("staffAdd".equals(action)){
			System.out.println("����Ա�����Ӳ�ѯ������");
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			ArrayList<BranchVo> list=branchDaoImpl.queryBranch();
	 		request.setAttribute("list", list);
	 		request.getRequestDispatcher("staff_add.jsp").forward(request, response);
		}else if("staffUpdate".equals(action)){
			System.out.println("����Ա���޸Ĳ�ѯ������");
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			ArrayList<BranchVo> list=branchDaoImpl.queryBranch();
	 		request.setAttribute("lists", list);
	 		request.getRequestDispatcher("staff_edit.jsp").forward(request, response);
		}else if("queryName".equals(action)){
			
			byte [] bytes=request.getParameter("branch_name").getBytes("ISO-8859-1");
			String result=new String(bytes,"UTF-8");
			
			System.out.println("��������ʲô����"+result);
			BranchDaoImpl branchDaoImpl=new BranchDaoImpl();
			BranchVo branchVo=branchDaoImpl.queryBranchName(result);
			request.setAttribute("result", branchVo);
			request.getRequestDispatcher("branch_edit.jsp").forward(request, response);
		}
	}

}
