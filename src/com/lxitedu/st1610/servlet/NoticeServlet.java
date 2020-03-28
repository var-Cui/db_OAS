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

import com.lxitedu.st1610.dao.Impl.NoticeDaoImpl;
import com.lxitedu.st1610.dao.Impl.NoticeTypeDaoImpl;
import com.lxitedu.st1610.vo.NoticeTypeVO;
import com.lxitedu.st1610.vo.NoticeVo;

/**
 * Servlet implementation class NoticeServlet
 */
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDaoImpl noticeDaoImpl=new NoticeDaoImpl();
		NoticeTypeDaoImpl noticeTypeDaoImpl = new NoticeTypeDaoImpl();
		String action=request.getParameter("action");
		if("add".equals(action)){
			String notice_name=request.getParameter("notice_name");
			String notice_type=request.getParameter("notice_type");
			String notice_promulgator=request.getParameter("notice_promulgator");
			String notice_releaseTime=request.getParameter("notice_releaseTime");
			String notice_content=request.getParameter("notice_content");
			System.out.println("拿到的值："+notice_name+"\t"+notice_promulgator+"\t"+notice_releaseTime+"\t"+notice_content);
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				 time=(Date)sdf.parse(notice_releaseTime);
				 System.out.println();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			try {
				NoticeVo noticeVo =new NoticeVo();
				noticeVo.setNotice_name(notice_name);
				noticeVo.setNotice_type(Integer.valueOf(notice_type));
				noticeVo.setNotice_promulgator(notice_promulgator);
				noticeVo.setNotice_releaseTime(time);
				noticeVo.setNotice_content(notice_content);
				noticeDaoImpl.insertNotice(noticeVo);
				System.out.println("增加成功！");
				response.sendRedirect("noticeServlet?action=query");
			} catch (Exception e) {
			}
		} else if("updateNotice".equals(action)){
			String id=request.getParameter("id");
			NoticeVo noticeVo = noticeDaoImpl.queryNoticeTypeOne(id);
			ArrayList<NoticeTypeVO> queryNoticeType = noticeTypeDaoImpl.queryNoticeType();
			request.setAttribute("typeList", queryNoticeType);
			request.setAttribute("noticeVo", noticeVo);
	 		request.getRequestDispatcher("border_edit.jsp").forward(request, response);
		} else if("update".equals(action)){
			String notice_name=request.getParameter("notice_name");
			String notice_type=request.getParameter("notice_type");
			String notice_promulgator=request.getParameter("notice_promulgator");
			String notice_releaseTime=request.getParameter("notice_releaseTime");
			String notice_content=request.getParameter("notice_content");
			String notice_id=request.getParameter("notice_id");
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				 time=(Date)sdf.parse(notice_releaseTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			NoticeVo noticeVo =new NoticeVo();
			noticeVo.setNotice_id(Integer.valueOf(notice_id));
			noticeVo.setNotice_name(notice_name);
			noticeVo.setNotice_type(Integer.valueOf(notice_type));
			noticeVo.setNotice_promulgator(notice_promulgator);
			noticeVo.setNotice_releaseTime(time);
			noticeVo.setNotice_content(notice_content);
			noticeDaoImpl.updateNotice(noticeVo);
			response.sendRedirect("noticeServlet?action=query");
		} else if("queryNotice".equals(action)){
			String id=request.getParameter("id");
			NoticeVo noticeVo = noticeDaoImpl.queryNoticeTypeOne(id);
			ArrayList<NoticeTypeVO> queryNoticeType = noticeTypeDaoImpl.queryNoticeType();
			request.setAttribute("typeList", queryNoticeType);
			request.setAttribute("noticeVo", noticeVo);
	 		request.getRequestDispatcher("border_query.jsp").forward(request, response);
		} else if("addNotice".equals(action)){
			ArrayList<NoticeTypeVO> queryNoticeType = noticeTypeDaoImpl.queryNoticeType();
			request.setAttribute("typeList", queryNoticeType);
	 		request.getRequestDispatcher("border_add.jsp").forward(request, response);
		} else if("delete".equals(action)){
			noticeDaoImpl.deleteNotice(Integer.valueOf(request.getParameter("id")));
	 		request.getRequestDispatcher("noticeServlet?action=query").forward(request, response);
		} else if("query".equals(action)){
			List<NoticeVo> list=noticeDaoImpl.queryStaff();
			List<NoticeTypeVO> queryNoticeType = noticeTypeDaoImpl.queryNoticeType();
			request.setAttribute("typeList", queryNoticeType);
			list = noticeTypeDaoImpl.getType(list, queryNoticeType);
			request.setAttribute("list", list);
	 		request.getRequestDispatcher("border_list.jsp").forward(request, response);
		}  else if("querySelect".equals(action)){
			String type=request.getParameter("type");
			System.err.println(type);
			List<NoticeVo> list = null;
			if("0".equals(type)) {
				list=noticeDaoImpl.queryStaff();
			} else {
				list=noticeDaoImpl.queryStaff(type);
			}
			ArrayList<NoticeTypeVO> queryNoticeType = noticeTypeDaoImpl.queryNoticeType();
			list = noticeTypeDaoImpl.getType(list, queryNoticeType);
			request.setAttribute("typeList", queryNoticeType);
			request.setAttribute("list", list);
	 		request.getRequestDispatcher("border_list.jsp").forward(request, response);
		} else if("addType".equals(action)){
			String type=request.getParameter("type");
			NoticeTypeVO noticeTypeVO = new NoticeTypeVO();
			noticeTypeVO.setType(type);
			noticeTypeDaoImpl.insertNoticeType(noticeTypeVO);
	 		request.getRequestDispatcher("noticeServlet?action=queryType").forward(request, response);
		} else if("queryType".equals(action)){
			ArrayList<NoticeTypeVO> queryNoticeType = noticeTypeDaoImpl.queryNoticeType();
			request.setAttribute("typeList", queryNoticeType);
	 		request.getRequestDispatcher("border_typede.jsp").forward(request, response);
		} else if("deleteType".equals(action)){
			noticeTypeDaoImpl.deleteNoticeType(Integer.valueOf(request.getParameter("id")));
	 		request.getRequestDispatcher("noticeServlet?action=queryType").forward(request, response);
		}
	}

}
