package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lxitedu.st1610.dao.Impl.PlanDaoImpl;
import com.lxitedu.st1610.service.Impl.PlanServiceImpl;
import com.lxitedu.st1610.vo.CommentVo;
import com.lxitedu.st1610.vo.PageVo;
import com.lxitedu.st1610.vo.PlanVo;
import com.lxitedu.st1610.vo.StaffVo;

/**
 * Servlet implementation class PlanServlet
 */
public class PlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log=Logger.getLogger(PlanServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanServlet() {
        super();
        log.debug("constructor");
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
		String action=request.getParameter("action");
		StaffVo staffVo=(StaffVo) request.getSession().getAttribute("staffVo");//登录属性对象
		String plan_name=request.getParameter("plan_name");//标题
		String plan_content=request.getParameter("plan_content");//内容
		request.setAttribute("a","总经理");
		request.setAttribute("b","董事长");
		request.setAttribute("c","部长");
		PlanServiceImpl planServiceImpl=new PlanServiceImpl();
		PlanDaoImpl planDaoImpl=new PlanDaoImpl();
		log.warn("进入计划PlanServlet");
		if(("planPersonalList").equals(action)){
			//个人计划首页迭代
			log.warn("进入个人计划PlanLIst");	
			String sql="select * from plan where plan_type='个人' and plan_promulgatorNum="+staffVo.getStaff_num()+" limit ?,?;";
			String sql1 = "select count(1) from plan where plan_type='个人' and plan_promulgatorNum="+staffVo.getStaff_num()+";"; 
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_personal_list.jsp").forward(request, response);
		}else if(("planQuery").equals(action)){
			log.warn("进入个人计划PlanNews");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));
			PlanVo planVo=planServiceImpl.planQuery(plan_id);
			request.setAttribute("planVo", planVo);
			request.getRequestDispatcher("plan_personal_news.jsp").forward(request, response);
		}else if(("planAdd").equals(action)){
			log.warn("进入个人计划Add");
			String plan_type="个人";
			String plan_result="待审核";
			PlanVo planVo=new PlanVo(plan_name,plan_content,plan_type,plan_result,staffVo.getStaff_name(),staffVo.getStaff_num(),staffVo.getStaff_branch());
			planServiceImpl.planAdd(planVo);
			request.getRequestDispatcher("planServlet?action=planPersonalList").forward(request, response);
		}else if(("planDel").equals(action)){
			log.warn("进入计划Del");
			String check=request.getParameter("check");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//计划ID
			planServiceImpl.planDel(plan_id);
			if(("per").equals(check)){
				request.getRequestDispatcher("planServlet?action=planPersonalList").forward(request, response);
			}else if(("bus").equals(check)){
				request.getRequestDispatcher("planServlet?action=planBusinesslist").forward(request, response);
			}else if(("bra").equals(check)){
				request.getRequestDispatcher("planServlet?action=planBranchlist").forward(request, response);
			}
		}else if(("planBranchlist").equals(action)){
			log.warn("进入部门计划List");				
			String sql1="select count(1) from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"';";
			String sql="select * from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"' limit ?,?;";
			if(("董事长").equals(staffVo.getStaff_position())||("总经理").equals(staffVo.getStaff_position())){
				log.warn("进入董事长查看部门计划");
				sql="select * from plan where plan_type='部门' limit ?,?;";
				sql1="select count(1) from plan where plan_type='部门';";
			}
			log.warn(sql);
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_branch_list.jsp").forward(request,response);			
		}else if(("planBranchAdd").equals(action)){
			log.warn("进入部门计划Add");
			String plan_type="部门";
			String plan_result="待审核";
			PlanVo planVo=new PlanVo(plan_name,plan_content,plan_type,plan_result,staffVo.getStaff_name(),staffVo.getStaff_num(),staffVo.getStaff_branch());
			planServiceImpl.planAdd(planVo);
			request.getRequestDispatcher("planServlet?action=planBranchlist").forward(request, response);
		}else if(("planBusinesslist").equals(action)){
			log.warn("进入企业计划List");
			String sql1="select count(1) from plan where plan_type='企业';";
			String sql="select * from plan where plan_type='企业' limit ?,?;";
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_business_list.jsp").forward(request, response);
		}else if(("planBusinessAdd").equals(action)){
			log.warn("进入企业计划Add");
			String plan_type="企业";
			String plan_result="待审核";
			PlanVo planVo=new PlanVo(plan_name,plan_content,plan_type,plan_result,staffVo.getStaff_name(),staffVo.getStaff_num(),staffVo.getStaff_branch());
			planServiceImpl.planAdd(planVo);
			request.getRequestDispatcher("planServlet?action=planBusinesslist").forward(request, response);
		}else if(("planPersonalVerifyQuery").equals(action)){
			log.warn("进入个人计划查询部长");
			String sql="SELECT * FROM plan WHERE plan_type='个人' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='部长') limit ?,?;";
			String sql1 = "SELECT count(1) FROM plan WHERE plan_type='个人' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='部长');"; 
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_personal_list.jsp").forward(request, response);
		}else if(("planPersonalPassQuery").equals(action)){
			log.warn("进入个人计划查询组长");
			String sql="SELECT * FROM plan WHERE plan_type='个人' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='组长') limit ?,?;";
			String sql1 = "SELECT count(1) FROM plan WHERE plan_type='个人' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='组长');"; 
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_personal_list.jsp").forward(request, response);
		}else if(("planPersonalRefuseQuery").equals(action)){
			log.warn("进入个人计划查询普通员工");
			String sql="SELECT * FROM plan WHERE plan_type='个人' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='普通员工') limit ?,?;";
			String sql1 = "SELECT count(1) FROM plan WHERE plan_type='个人' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='普通员工');"; 
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_personal_list.jsp").forward(request, response);
		}else if(("planBusinessVerifyQuery").equals(action)){
			log.warn("进入企业计划查询待审核");
			String sql1="select count(1) from plan where plan_type='企业' and plan_result='待审核';";
			String sql="select * from plan where plan_type='企业' and plan_result='待审核' limit ?,?;";
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_business_list.jsp").forward(request, response);
		}else if(("planBusinessPassQuery").equals(action)){
			log.warn("进入企业计划查询已同意");
			String sql1="select count(1) from plan where plan_type='企业' and plan_result='已通过';";
			String sql="select * from plan where plan_type='企业' and plan_result='已通过' limit ?,?;";
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_business_list.jsp").forward(request, response);
		}else if(("planBusinessRefuseQuery").equals(action)){
			log.warn("进入企业计划查询未同意");
			String sql1="select count(1) from plan where plan_type='企业' and plan_result='未通过';";
			String sql="select * from plan where plan_type='企业' and plan_result='未通过' limit ?,?;";
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_business_list.jsp").forward(request, response);
		}else if(("planBranchVerifyQuery").equals(action)){
			log.warn("进入部门计划查询待审核");
			String sql1="select count(1) from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='待审核';";
			String sql="select * from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='待审核' limit ?,?;";
			if(("董事长").equals(staffVo.getStaff_position())||("总经理").equals(staffVo.getStaff_position())){
				log.warn("进入董事长查看部门计划");
				sql="select * from plan where plan_type='部门' and plan_result='待审核' limit ?,?;";
				sql1="select count(1) from plan where plan_type='部门' and plan_result='待审核';";
			}
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_branch_list.jsp").forward(request, response);
		}else if(("planBranchPassQuery").equals(action)){
			log.warn("进入部门计划查询已同意");
			String sql1="select count(1) from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='已通过';";
			String sql="select * from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='已通过' limit ?,?;";
			if(("董事长").equals(staffVo.getStaff_position())||("总经理").equals(staffVo.getStaff_position())){
				log.warn("进入董事长查看部门计划");
				sql="select * from plan where plan_type='部门' and plan_result='已通过' limit ?,?;";
				sql1="select count(1) from plan where plan_type='部门' and plan_result='已通过';";
			}
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_branch_list.jsp").forward(request, response);
		}else if(("planBranchRefuseQuery").equals(action)){
			log.warn("进入部门计划查询未通过");
			String sql1="select count(1) from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='未通过';";
			String sql="select * from plan where plan_type='部门' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='未通过' limit ?,?;";
			if(("董事长").equals(staffVo.getStaff_position())||("总经理").equals(staffVo.getStaff_position())){
				log.warn("进入董事长查看部门计划");
				sql="select * from plan where plan_type='部门' and plan_result='未通过' limit ?,?;";
				sql1="select count(1) from plan where plan_type='部门' and plan_result='未通过';";
			}
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<PlanVo> list=planServiceImpl.planPersonalList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			request.getRequestDispatcher("plan_branch_list.jsp").forward(request, response);
		}else if(("planComment").equals(action)){
			log.warn("进入领导评论个人计划");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//得到要评论的计划ID
			PlanVo planVo=planServiceImpl.planQuery(plan_id);
			request.setAttribute("planVo", planVo);
			request.getRequestDispatcher("plan_personal_comment.jsp").forward(request, response);
		}else if(("planCommentAdd").equals(action)){
			log.warn("进入领导评论增加");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//评论计划的ID
			String commentName=staffVo.getStaff_name();//评论姓名
			String commentPosition=staffVo.getStaff_position();//评论职位
			String commentText=request.getParameter("comment");//评论内容
			CommentVo commentVo=new CommentVo(plan_id,commentName,commentPosition,commentText);
			planServiceImpl.commentAdd(commentVo);
			request.getRequestDispatcher("planServlet?action=planPersonalList").forward(request, response);
		}else if(("planCommentQuery").equals(action)){
			log.warn("进入评论查询");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//计划ID
			System.out.println("计划ID是多少:"+plan_id);
			String sql1="select count(1) from comment where comment_plan_id="+plan_id+";";
			String sql="select * from comment where comment_plan_id="+plan_id+" limit ?,?;";
			PageVo p = new PageVo();
			   p.setTotalCount(planDaoImpl.getPageCount(sql1));
			  String currPageNo= request.getParameter("currPageNo");
			  System.out.println("currPageNo====="+currPageNo);			  			   
			   ArrayList<CommentVo> list=planServiceImpl.commentList(p,sql,currPageNo);
			   System.out.println(list);
			   System.out.println(p);
			   request.setAttribute("VO", p);  
			   request.setAttribute("planList", list);
			   request.setAttribute("skip",action);
			   request.setAttribute("plan_name",plan_name);
			   request.setAttribute("plan_content",plan_content);
			   request.setAttribute("plan_id",plan_id);
			request.getRequestDispatcher("plan_comment_news.jsp").forward(request, response);
		}
		
	}

}
