package com.lxitedu.st1610.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lxitedu.st1610.dao.Impl.NoticeDaoImpl;
import com.lxitedu.st1610.dao.Impl.NoticeTypeDaoImpl;
import com.lxitedu.st1610.vo.NoticeTypeVO;
import com.lxitedu.st1610.vo.NoticeVo;

import cn.lxitedu.st1610.util.FileUtils;

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
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);//outputStream
		upload.setHeaderEncoding("UTF-8");
		String savePath = this.getServletContext().getRealPath("/uploadFile");
		
		if("add".equals(action)){
			try {
				List<FileItem> items = upload.parseRequest(request);
				String notice_name = "";
				String notice_type = "";
				String notice_promulgator = "";
				String notice_releaseTime = "";
				String notice_content = "";
				String fileName = "";
				FileItem f = null;
				if(items != null) {
					for (FileItem fileItem : items) {
						if(fileItem.isFormField()) {
						    if ("notice_name".equals(fileItem.getFieldName())) {
						    	notice_name = fileItem.getString("UTF-8");
							} else if ("notice_type".equals(fileItem.getFieldName())) {
								notice_type = fileItem.getString("UTF-8");
							} else if ("notice_promulgator".equals(fileItem.getFieldName())) {
								notice_promulgator = fileItem.getString("UTF-8");
							} else if ("notice_releaseTime".equals(fileItem.getFieldName())) {
								notice_releaseTime = fileItem.getString("UTF-8");
							} else if ("notice_content".equals(fileItem.getFieldName())) {
								notice_content = fileItem.getString("UTF-8");
							}
						} else {
							fileName = new File(fileItem.getName()).getName();
							f = fileItem;
						}
					}
				} 
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date time=null;
				time=(Date)sdf.parse(notice_releaseTime);
				NoticeVo noticeVo =new NoticeVo();
				noticeVo.setNotice_name(notice_name);
				noticeVo.setNotice_type(Integer.valueOf(notice_type));
				noticeVo.setNotice_promulgator(notice_promulgator);
				noticeVo.setNotice_releaseTime(time);
				noticeVo.setNotice_content(notice_content);
				noticeVo.setFile_name(fileName);
				int insertNotice = noticeDaoImpl.insertNotice(noticeVo);
				savePath += File.separator +insertNotice;
				FileUtils.uploadFile(savePath, fileName,f);
				response.sendRedirect("noticeServlet?action=query");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if("updateNotice".equals(action)){
			String id=request.getParameter("id");
			NoticeVo noticeVo = noticeDaoImpl.queryNoticeTypeOne(id);
			ArrayList<NoticeTypeVO> queryNoticeType = noticeTypeDaoImpl.queryNoticeType();
			request.setAttribute("typeList", queryNoticeType);
			request.setAttribute("noticeVo", noticeVo);
	 		request.getRequestDispatcher("border_edit.jsp").forward(request, response);
		} else if("update".equals(action)){
			try {
				List<FileItem> items = upload.parseRequest(request);
				String notice_name = "";
				String notice_type = "";
				String notice_promulgator = "";
				String notice_releaseTime = "";
				String notice_content = "";
				String fileName = "";
				String notice_id = "";
				FileItem f = null;
				if(items != null) {
					for (FileItem fileItem : items) {
						if(fileItem.isFormField()) {
						    if ("notice_name".equals(fileItem.getFieldName())) {
						    	notice_name = fileItem.getString("UTF-8");
							} else if ("notice_type".equals(fileItem.getFieldName())) {
								notice_type = fileItem.getString("UTF-8");
							} else if ("notice_promulgator".equals(fileItem.getFieldName())) {
								notice_promulgator = fileItem.getString("UTF-8");
							} else if ("notice_releaseTime".equals(fileItem.getFieldName())) {
								notice_releaseTime = fileItem.getString("UTF-8");
							} else if ("notice_content".equals(fileItem.getFieldName())) {
								notice_content = fileItem.getString("UTF-8");
							} else if ("notice_id".equals(fileItem.getFieldName())) {
								notice_id = fileItem.getString("UTF-8");
							}
						} else {
							fileName = new File(fileItem.getName()).getName();
							f = fileItem;
						}
					}
				} 
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				Date time=null;
				time=(Date)sdf.parse(notice_releaseTime);
				NoticeVo noticeVo =new NoticeVo();
				noticeVo.setNotice_id(Integer.valueOf(notice_id));
				noticeVo.setNotice_name(notice_name);
				noticeVo.setNotice_type(Integer.valueOf(notice_type));
				noticeVo.setNotice_promulgator(notice_promulgator);
				noticeVo.setNotice_releaseTime(time);
				noticeVo.setNotice_content(notice_content);
				noticeVo.setFile_name(fileName);
				NoticeVo old = noticeDaoImpl.queryNoticeTypeOne(notice_id);
				noticeVo.setOldFileName(old.getFile_name());
				noticeDaoImpl.updateNotice(noticeVo);
				if(!"".equals(fileName) && (fileName != null)) {
					savePath += File.separator +notice_id;
					FileUtils.uploadFile(savePath, fileName,f);
				}
				response.sendRedirect("noticeServlet?action=query");
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			String id = request.getParameter("id");
			NoticeVo noticeVo = noticeDaoImpl.queryNoticeTypeOne(id);
			String name = noticeVo.getFile_name();
			if((!"".equals(name)) && name != null) {
				String path = request.getServletContext().getRealPath("/uploadFile");
				path += File.separator + id;
				File file = new File(path);
				if(file.exists()) {
					File[] listFiles = file.listFiles();
					if(listFiles != null) {
						for (File file2 : listFiles) {
							if(file2.isFile()) {
								file2.delete();
							}
						}
					}
					file.delete();
				}
			}
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
