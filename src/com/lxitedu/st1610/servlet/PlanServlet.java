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
		StaffVo staffVo=(StaffVo) request.getSession().getAttribute("staffVo");//��¼���Զ���
		String plan_name=request.getParameter("plan_name");//����
		String plan_content=request.getParameter("plan_content");//����
		request.setAttribute("a","�ܾ���");
		request.setAttribute("b","���³�");
		request.setAttribute("c","����");
		PlanServiceImpl planServiceImpl=new PlanServiceImpl();
		PlanDaoImpl planDaoImpl=new PlanDaoImpl();
		log.warn("����ƻ�PlanServlet");
		if(("planPersonalList").equals(action)){
			//���˼ƻ���ҳ����
			log.warn("������˼ƻ�PlanLIst");	
			String sql="select * from plan where plan_type='����' and plan_promulgatorNum="+staffVo.getStaff_num()+" limit ?,?;";
			String sql1 = "select count(1) from plan where plan_type='����' and plan_promulgatorNum="+staffVo.getStaff_num()+";"; 
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
			log.warn("������˼ƻ�PlanNews");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));
			PlanVo planVo=planServiceImpl.planQuery(plan_id);
			request.setAttribute("planVo", planVo);
			request.getRequestDispatcher("plan_personal_news.jsp").forward(request, response);
		}else if(("planAdd").equals(action)){
			log.warn("������˼ƻ�Add");
			String plan_type="����";
			String plan_result="�����";
			PlanVo planVo=new PlanVo(plan_name,plan_content,plan_type,plan_result,staffVo.getStaff_name(),staffVo.getStaff_num(),staffVo.getStaff_branch());
			planServiceImpl.planAdd(planVo);
			request.getRequestDispatcher("planServlet?action=planPersonalList").forward(request, response);
		}else if(("planDel").equals(action)){
			log.warn("����ƻ�Del");
			String check=request.getParameter("check");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//�ƻ�ID
			planServiceImpl.planDel(plan_id);
			if(("per").equals(check)){
				request.getRequestDispatcher("planServlet?action=planPersonalList").forward(request, response);
			}else if(("bus").equals(check)){
				request.getRequestDispatcher("planServlet?action=planBusinesslist").forward(request, response);
			}else if(("bra").equals(check)){
				request.getRequestDispatcher("planServlet?action=planBranchlist").forward(request, response);
			}
		}else if(("planBranchlist").equals(action)){
			log.warn("���벿�żƻ�List");				
			String sql1="select count(1) from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"';";
			String sql="select * from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"' limit ?,?;";
			if(("���³�").equals(staffVo.getStaff_position())||("�ܾ���").equals(staffVo.getStaff_position())){
				log.warn("���붭�³��鿴���żƻ�");
				sql="select * from plan where plan_type='����' limit ?,?;";
				sql1="select count(1) from plan where plan_type='����';";
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
			log.warn("���벿�żƻ�Add");
			String plan_type="����";
			String plan_result="�����";
			PlanVo planVo=new PlanVo(plan_name,plan_content,plan_type,plan_result,staffVo.getStaff_name(),staffVo.getStaff_num(),staffVo.getStaff_branch());
			planServiceImpl.planAdd(planVo);
			request.getRequestDispatcher("planServlet?action=planBranchlist").forward(request, response);
		}else if(("planBusinesslist").equals(action)){
			log.warn("������ҵ�ƻ�List");
			String sql1="select count(1) from plan where plan_type='��ҵ';";
			String sql="select * from plan where plan_type='��ҵ' limit ?,?;";
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
			log.warn("������ҵ�ƻ�Add");
			String plan_type="��ҵ";
			String plan_result="�����";
			PlanVo planVo=new PlanVo(plan_name,plan_content,plan_type,plan_result,staffVo.getStaff_name(),staffVo.getStaff_num(),staffVo.getStaff_branch());
			planServiceImpl.planAdd(planVo);
			request.getRequestDispatcher("planServlet?action=planBusinesslist").forward(request, response);
		}else if(("planPersonalVerifyQuery").equals(action)){
			log.warn("������˼ƻ���ѯ����");
			String sql="SELECT * FROM plan WHERE plan_type='����' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='����') limit ?,?;";
			String sql1 = "SELECT count(1) FROM plan WHERE plan_type='����' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='����');"; 
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
			log.warn("������˼ƻ���ѯ�鳤");
			String sql="SELECT * FROM plan WHERE plan_type='����' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='�鳤') limit ?,?;";
			String sql1 = "SELECT count(1) FROM plan WHERE plan_type='����' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='�鳤');"; 
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
			log.warn("������˼ƻ���ѯ��ͨԱ��");
			String sql="SELECT * FROM plan WHERE plan_type='����' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='��ͨԱ��') limit ?,?;";
			String sql1 = "SELECT count(1) FROM plan WHERE plan_type='����' AND plan_promulgatorNum IN(SELECT staff_num FROM staff WHERE staff_position='��ͨԱ��');"; 
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
			log.warn("������ҵ�ƻ���ѯ�����");
			String sql1="select count(1) from plan where plan_type='��ҵ' and plan_result='�����';";
			String sql="select * from plan where plan_type='��ҵ' and plan_result='�����' limit ?,?;";
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
			log.warn("������ҵ�ƻ���ѯ��ͬ��");
			String sql1="select count(1) from plan where plan_type='��ҵ' and plan_result='��ͨ��';";
			String sql="select * from plan where plan_type='��ҵ' and plan_result='��ͨ��' limit ?,?;";
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
			log.warn("������ҵ�ƻ���ѯδͬ��");
			String sql1="select count(1) from plan where plan_type='��ҵ' and plan_result='δͨ��';";
			String sql="select * from plan where plan_type='��ҵ' and plan_result='δͨ��' limit ?,?;";
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
			log.warn("���벿�żƻ���ѯ�����");
			String sql1="select count(1) from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='�����';";
			String sql="select * from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='�����' limit ?,?;";
			if(("���³�").equals(staffVo.getStaff_position())||("�ܾ���").equals(staffVo.getStaff_position())){
				log.warn("���붭�³��鿴���żƻ�");
				sql="select * from plan where plan_type='����' and plan_result='�����' limit ?,?;";
				sql1="select count(1) from plan where plan_type='����' and plan_result='�����';";
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
			log.warn("���벿�żƻ���ѯ��ͬ��");
			String sql1="select count(1) from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='��ͨ��';";
			String sql="select * from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='��ͨ��' limit ?,?;";
			if(("���³�").equals(staffVo.getStaff_position())||("�ܾ���").equals(staffVo.getStaff_position())){
				log.warn("���붭�³��鿴���żƻ�");
				sql="select * from plan where plan_type='����' and plan_result='��ͨ��' limit ?,?;";
				sql1="select count(1) from plan where plan_type='����' and plan_result='��ͨ��';";
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
			log.warn("���벿�żƻ���ѯδͨ��");
			String sql1="select count(1) from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='δͨ��';";
			String sql="select * from plan where plan_type='����' and plan_branch='"+staffVo.getStaff_branch()+"' and plan_result='δͨ��' limit ?,?;";
			if(("���³�").equals(staffVo.getStaff_position())||("�ܾ���").equals(staffVo.getStaff_position())){
				log.warn("���붭�³��鿴���żƻ�");
				sql="select * from plan where plan_type='����' and plan_result='δͨ��' limit ?,?;";
				sql1="select count(1) from plan where plan_type='����' and plan_result='δͨ��';";
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
			log.warn("�����쵼���۸��˼ƻ�");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//�õ�Ҫ���۵ļƻ�ID
			PlanVo planVo=planServiceImpl.planQuery(plan_id);
			request.setAttribute("planVo", planVo);
			request.getRequestDispatcher("plan_personal_comment.jsp").forward(request, response);
		}else if(("planCommentAdd").equals(action)){
			log.warn("�����쵼��������");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//���ۼƻ���ID
			String commentName=staffVo.getStaff_name();//��������
			String commentPosition=staffVo.getStaff_position();//����ְλ
			String commentText=request.getParameter("comment");//��������
			CommentVo commentVo=new CommentVo(plan_id,commentName,commentPosition,commentText);
			planServiceImpl.commentAdd(commentVo);
			request.getRequestDispatcher("planServlet?action=planPersonalList").forward(request, response);
		}else if(("planCommentQuery").equals(action)){
			log.warn("�������۲�ѯ");
			int plan_id=Integer.parseInt(request.getParameter("plan_id"));//�ƻ�ID
			System.out.println("�ƻ�ID�Ƕ���:"+plan_id);
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
