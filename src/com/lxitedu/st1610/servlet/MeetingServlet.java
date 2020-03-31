package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.BranchDaoImpl;
import com.lxitedu.st1610.dao.Impl.MeetingDaoImpl;
import com.lxitedu.st1610.vo.BranchVo;

import cn.lxitedu.st1610.bean.MeetingVo;

/**
 * Servlet implementation class NoticeServlet
 */
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingServlet() {
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
		BranchDaoImpl branchDaoImpl = new BranchDaoImpl();
		MeetingDaoImpl meetingDaoImpl = new MeetingDaoImpl();
		String action=request.getParameter("action");
		if("addMeeting".equals(action)){
			ArrayList<BranchVo> branchList = branchDaoImpl.queryBranch();
			request.setAttribute("branchList", branchList);
	 		request.getRequestDispatcher("meeting_add.jsp").forward(request, response);
		}else if("add".equals(action)){
			String meet_theme=request.getParameter("meet_theme");
			String is_open=request.getParameter("is_open");
			String join_people=request.getParameter("join_people");
			String meet_date=request.getParameter("meet_date");
			String branch_id=request.getParameter("branch_id");
			String meeting_place=request.getParameter("meetingroom_name");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date time=null;
			try {
				time=(Date)sdf.parse(meet_date);
				MeetingVo meetingVo =new MeetingVo();
				meetingVo.setMeeting_name(meet_theme);
				meetingVo.setMeeting_staff(join_people);
				meetingVo.setMeeting_releaseTime(time);
				meetingVo.setIs_open(is_open);
				meetingVo.setMeeting_place(meeting_place);
				meetingVo.setBranch_id(Integer.valueOf(branch_id));
				meetingDaoImpl.insertMeeting(meetingVo);
				response.sendRedirect("meeting_list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if("updateMeeting".equals(action)){
			String id = request.getParameter("id");
			MeetingVo meetingVo = meetingDaoImpl.queryMeetingOne(id);
			ArrayList<BranchVo> branchList = branchDaoImpl.queryBranch();
			request.setAttribute("branchList", branchList);
			request.setAttribute("meetingVo", meetingVo);
	 		request.getRequestDispatcher("meeting_edit.jsp").forward(request, response);
		} else if("update".equals(action)){
			String meeting_name=request.getParameter("meet_theme");
			String branch_id=request.getParameter("branch_id");
			String is_open=request.getParameter("is_open");
			String meeting_place=request.getParameter("meeting_place");
			String meeting_staff=request.getParameter("meeting_staff");
			String meeting_releaseTime=request.getParameter("meet_date");
			String meeting_id=request.getParameter("meeting_id");
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date time=null;
			try {
				time=(Date)sdf.parse(meeting_releaseTime);
				MeetingVo meetingVo =new MeetingVo();
				meetingVo.setMeeting_name(meeting_name);
				meetingVo.setMeeting_staff(meeting_staff);
				meetingVo.setMeeting_releaseTime(time);
				meetingVo.setIs_open(is_open);
				meetingVo.setMeeting_place(meeting_place);
				meetingVo.setBranch_id(Integer.valueOf(branch_id));
				meetingVo.setMeeting_id(Integer.valueOf(meeting_id));
				meetingDaoImpl.updateMeeting(meetingVo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("MeetingServlet?action=query");
		} else if("query".equals(action)){
			ArrayList<MeetingVo> list = meetingDaoImpl.queryMeeting();
			ArrayList<BranchVo> branchList = branchDaoImpl.queryBranch();
			list = meetingDaoImpl.getBranchName(list, branchList);
			request.setAttribute("list", list);
	 		request.getRequestDispatcher("meeting_list.jsp").forward(request, response);
		}  else if("delete".equals(action)){
			meetingDaoImpl.deleteMeeting(Integer.valueOf(request.getParameter("id")));
			request.getRequestDispatcher("MeetingServlet?action=query").forward(request, response);
		}
	}
}
