package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.MaintainDaoImpl;
import com.lxitedu.st1610.dao.Impl.ModelDaoImpl;
import com.lxitedu.st1610.dao.Impl.NoticeDaoImpl;
import com.lxitedu.st1610.vo.BranchVo;
import com.lxitedu.st1610.vo.MaintainVo;
import com.lxitedu.st1610.vo.ModelVo;
import com.lxitedu.st1610.vo.NoticeVo;
import com.lxitedu.st1610.vo.StaffVo;

/**
 * Servlet implementation class MaintainServlet
 */
public class MaintainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");// 获取操作符
		if ("add".equals(action)) {
			System.out.println("菜单增加");
			int maintain_model=Integer.parseInt(request.getParameter("model_name"));
			String maintain_menu = request.getParameter("maintain_menu");
			String maintain_url = request.getParameter("maintain_url");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date());// 获取当前系统时间
			Date maintain_time = null;
			try {
				maintain_time = (Date) sdf.parse(time);
				System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("拿到的值:" + "\tModel::"+maintain_model+"\t菜单::"+maintain_menu + "\turl:::"
					+ maintain_url + "\t时间：" + time);
			
			try {
				MaintainVo maintainVo=new MaintainVo();
				maintainVo.setMaintain_model(maintain_model);
				maintainVo.setMaintain_menu(maintain_menu);
				maintainVo.setMaintain_url(maintain_url);
				maintainVo.setMaintain_time(maintain_time);
				
				MaintainDaoImpl maintainDaoImpl=new MaintainDaoImpl();
				maintainDaoImpl.insertMaintain(maintainVo);
				System.out.println("增加菜单成功！！！");
				response.sendRedirect("maintainServlet?action=query");
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if ("delete".equals(action)) {
			System.out.println("删除菜单");
			String maintain_id=request.getParameter("maintain_id");
			
			MaintainDaoImpl maintainDaoImpl=new MaintainDaoImpl();
			maintainDaoImpl.deleteMaintain(Integer.parseInt(maintain_id));
			System.out.println("删除成功菜单！！！");
			response.sendRedirect("maintainServlet?action=query");
		} else if ("update".equals(action)) {
			int maintain_id=Integer.parseInt(request.getParameter("maintain_id"));
			int maintain_model=Integer.parseInt(request.getParameter("maintain_model"));
			String maintain_menu = request.getParameter("maintain_menu");
			String maintain_url = request.getParameter("maintain_url");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date());// 获取当前系统时间
			Date maintain_time = null;
			try {
				maintain_time = (Date) sdf.parse(time);
				System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("拿到的值:" + "\tModel::"+maintain_model+"\t菜单::"+maintain_menu + "\turl:::"
					+ maintain_url + "\t时间：" + time+"\tId:"+maintain_id);
			
			try {
				MaintainVo maintainVo=new MaintainVo();
				maintainVo.setMaintain_model(maintain_model);
				maintainVo.setMaintain_menu(maintain_menu);
				maintainVo.setMaintain_url(maintain_url);
				maintainVo.setMaintain_time(maintain_time);
				maintainVo.setMaintain_id(maintain_id);
				
				MaintainDaoImpl maintainDaoImpl=new MaintainDaoImpl();
				maintainDaoImpl.updateMaintain(maintainVo);;
				System.out.println("修改菜单成功！！！");
				response.sendRedirect("maintainServlet?action=query");
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if ("query".equals(action)) {
			MaintainDaoImpl maintainDaoImpl = new MaintainDaoImpl();
			ArrayList<MaintainVo> list = maintainDaoImpl.queryMaintain();
			request.setAttribute("list", list);

			ModelDaoImpl modelDaoImpl = new ModelDaoImpl();
			ArrayList<ModelVo> lists = modelDaoImpl.queryModel();
			request.setAttribute("lists", lists);

			request.getRequestDispatcher("maintain.jsp").forward(request, response);
		}else if("model".equals(action)){
			ModelDaoImpl modelDaoImpl = new ModelDaoImpl();
			ArrayList<ModelVo> lists = modelDaoImpl.queryModel();
			request.setAttribute("lists", lists);
			System.out.println("进来没有？？");
			request.getRequestDispatcher("maintain_add.jsp").forward(request, response);
		}else if("modelUpdate".equals(action)){
			ModelDaoImpl modelDaoImpl = new ModelDaoImpl();
			ArrayList<ModelVo> lists = modelDaoImpl.queryModel();
			request.setAttribute("lists", lists);
			System.out.println("修改菜单界面，查询模块和菜单信息！！！");
			
			int id=Integer.parseInt(request.getParameter("maintain_id"));
			MaintainDaoImpl maintainDaoImpl=new MaintainDaoImpl();
			MaintainVo maintainVo=maintainDaoImpl.queryInfo(id);
			request.setAttribute("result", maintainVo);
			
			request.getRequestDispatcher("maintain_edit.jsp").forward(request, response);
			
		}else if("sss".equals(action)){
			MaintainDaoImpl maintainDaoImpl = new MaintainDaoImpl();
			ArrayList<MaintainVo> list = maintainDaoImpl.queryMaintain();
			request.setAttribute("list", list);

			ModelDaoImpl modelDaoImpl = new ModelDaoImpl();
			ArrayList<ModelVo> lists = modelDaoImpl.queryModel();
			request.setAttribute("lists", lists);
			StaffVo staffVo = (StaffVo) request.getSession().getAttribute("staffVo");//登录属性对象
			//员工 今日看板、日常管理、考勤管理、计划制定、系统管理(系统管理只要"退出登录")
			//部门主管 今日看板、日常管理、考勤管理、计划制定、审核管理、人事管理、系统管理(系统管理只要"退出登录") 
			//人事 今日看板、日常管理、考勤管理、计划制定、人事管理、系统管理(系统管理只要"退出登录")
			if(lists != null) {
				Iterator<ModelVo> iterator = lists.iterator();
				while(iterator.hasNext()) {
					ModelVo next = iterator.next();
					if(next != null) {
						if("普通员工".equals(staffVo.getStaff_position())) {
							if(("审核管理".equals(next.getMaintain_name())) || ("人事管理".equals(next.getMaintain_name()))) {
								iterator.remove();
							}
						} else if ("人事".equals(staffVo.getStaff_position())) {
							if(("审核管理".equals(next.getMaintain_name()))) {
								iterator.remove();
							}
						}
					}
				}
			}
			if(list != null) {
				Iterator<MaintainVo> iterator2 = list.iterator();
				while(iterator2.hasNext()) {
					MaintainVo next = iterator2.next();
					if(next != null) {
						if(("普通员工".equals(staffVo.getStaff_position()))  ||  ("人事".equals(staffVo.getStaff_position())) ||  ("部门主管".equals(staffVo.getStaff_position()))) {
							if(("网站维护".equals(next.getMaintain_menu()))) {
								iterator2.remove();
							}
						}
					}
				}
			}
			request.getRequestDispatcher("left.jsp").forward(request, response);
		}  else if("queryToday".equals(action)){
			NoticeDaoImpl noticeDaoImpl = new NoticeDaoImpl();
			List<NoticeVo> noticeList = noticeDaoImpl.queryTodayNotice();
			if(noticeList.size() != 0) {
				if(noticeList.size() >= 3) {
					noticeList = noticeList.subList(0, 3);
				} else {
					noticeList = noticeList.subList(0,noticeList.size());
				}
			}
			request.setAttribute("noticeList", noticeList);
			//第二个框
			StaffVo staffVo = (StaffVo) request.getSession().getAttribute("staffVo");//登录属性对象
			MaintainDaoImpl maintainDaoImpl = new MaintainDaoImpl();
			List<MaintainVo> list = maintainDaoImpl.getList(staffVo.getStaff_name());
			request.setAttribute("auditList", list);
			//第三个框
			//普通员工
			List<BranchVo> auditList = new ArrayList<BranchVo>();
			if("普通员工".equals(staffVo.getStaff_position())) {
				auditList = maintainDaoImpl.getAuditList(staffVo.getStaff_name());
			} else if("人事".equals(staffVo.getStaff_position())) {
				auditList = maintainDaoImpl.getAuditList();
			}
			//人事
			request.setAttribute("resultList",auditList);
	 		request.getRequestDispatcher("todayLook.jsp").forward(request, response);
		} 
	}

}
