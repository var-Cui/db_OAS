package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.MaintainDaoImpl;
import com.lxitedu.st1610.dao.Impl.ModelDaoImpl;
import com.lxitedu.st1610.dao.Impl.NoticeDaoImpl;
import com.lxitedu.st1610.vo.MaintainVo;
import com.lxitedu.st1610.vo.ModelVo;
import com.lxitedu.st1610.vo.NoticeVo;

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

			request.getRequestDispatcher("left.jsp").forward(request, response);
		}  else if("queryToday".equals(action)){
			NoticeDaoImpl noticeDaoImpl = new NoticeDaoImpl();
			List<NoticeVo> noticeList = noticeDaoImpl.queryTodayNotice();
			if(noticeList.size() > 0) {
				noticeList = noticeList.subList(0, 3);
			}
			request.setAttribute("noticeList", noticeList);
	 		request.getRequestDispatcher("todayLook.jsp").forward(request, response);
		} 
	}

}
