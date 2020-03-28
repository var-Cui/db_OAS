package com.lxitedu.st1610.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxitedu.st1610.dao.Impl.StaffDaoImpl;
import com.lxitedu.st1610.vo.StaffVo;



/**
 * Servlet implementation class StaffServlet
 */
public class StaffServlet extends HttpServlet {
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
		request.setAttribute("a", "��ͨԱ��");
		request.setAttribute("b", "����");
		request.setAttribute("c", "�ܾ���");
		request.setAttribute("d", "���³�");
		if("add".equals(action)){
			System.out.println("Ա������servlet������û�У�����");
			int staff_num = Integer.parseInt(request.getParameter("staff_num"));
			String staff_name=request.getParameter("staff_name");
			String staff_sex=request.getParameter("staff_sex");
			
			String staff_birthdate=request.getParameter("staff_birthdate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				 time=(Date)sdf.parse(staff_birthdate);
				 System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String staff_branch=request.getParameter("staff_branch");
			String staff_position=request.getParameter("staff_position");
			String staff_enterTime=request.getParameter("staff_enterTime");
			
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			Date time1=null;
			try {
				 time1=(Date)sdf1.parse(staff_enterTime);
				 System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String staff_password=request.getParameter("staff_pwd");
			System.out.println("�õ���ֵ��"+staff_num+"\t�Ա�"+staff_sex+"\t���֣�"+staff_name+"\t���գ�"+time+"\t���ţ�"+staff_branch+"\tְλ:"+staff_position);
		try {
			StaffVo staffVo=new StaffVo();
			staffVo.setStaff_num(staff_num);
			staffVo.setStaff_name(staff_name);
			staffVo.setStaff_sex(staff_sex);
			staffVo.setStaff_birthdate(time);
			staffVo.setStaff_branch(staff_branch);
			staffVo.setStaff_position(staff_position);
			staffVo.setStaff_enterTime(time1);
			staffVo.setStaff_password(staff_password);
			
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			staffDaoImpl.insertStaff(staffVo);
			
			System.out.println("����Ա���ɹ�������");
			 response.sendRedirect("limitServlet?action=staffVo");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		}else if("delete".equals(action)){
			System.out.println("Ա��ɾ��>>>>");
			int id = Integer.parseInt(request.getParameter("staff_id"));
			System.out.println("id="+id);
			
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			staffDaoImpl.deleteStaff(id);;
			
			System.out.println("\nɾ��Ա���ɹ�������");
			response.sendRedirect("limitServlet?action=staffVo");
			
		}else if("update".equals(action)){
			System.out.println("Ա���޸ġ�����");
			int staff_id = Integer.parseInt(request.getParameter("staff_id"));
			int staff_num = Integer.parseInt(request.getParameter("staff_num"));
			String staff_name=request.getParameter("staff_name");
			String staff_sex=request.getParameter("staff_sex");
			
			String staff_birthdate=request.getParameter("staff_birthdate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date time=null;
			try {
				 time=(Date)sdf.parse(staff_birthdate);
				 System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String staff_branch=request.getParameter("staff_branch");
			String staff_position=request.getParameter("staff_position");
			String staff_enterTime=request.getParameter("staff_enterTime");
			
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			Date time1=null;
			try {
				 time1=(Date)sdf1.parse(staff_enterTime);
				 System.out.println();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�õ���ֵ��"+staff_num+"\t�Ա�"+staff_sex+"\t���֣�"+staff_name+"\t���գ�"+time+"\t���ţ�"+staff_branch+"\tְλ:"+staff_position);
		try {
			StaffVo staffVo=new StaffVo();
			staffVo.setStaff_num(staff_num);
			staffVo.setStaff_name(staff_name);
			staffVo.setStaff_sex(staff_sex);
			staffVo.setStaff_birthdate(time);
			staffVo.setStaff_branch(staff_branch);
			staffVo.setStaff_position(staff_position);
			staffVo.setStaff_enterTime(time1);
			staffVo.setStaff_id(staff_id);
			
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			staffDaoImpl.updateStaff(staffVo);;
			
			System.out.println("�޸�Ա���ɹ�������");
			 response.sendRedirect("limitServlet?action=staffVo");
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
		}else if("query".equals(action)){
			System.out.println("����Ա����ѯ������");
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			ArrayList<StaffVo> list=staffDaoImpl.queryStaff();
	 		request.setAttribute("list", list);
	 		
	 		request.getRequestDispatcher("staff_list.jsp").forward(request, response);
		}else if("queryInfo".equals(action)){
			int id=Integer.parseInt(request.getParameter("user_id"));
			
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			StaffVo staffVo=staffDaoImpl.queryStaffName(id);
			request.setAttribute("result", staffVo);
			
			request.getRequestDispatcher("branchServlet?action=staffUpdate").forward(request, response);
		}else if("queryPersonInfo".equals(action)){
			int id=Integer.parseInt(request.getParameter("user_id"));
			
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			StaffVo staffVo=staffDaoImpl.queryStaffName(id);
			request.setAttribute("result", staffVo);
			request.getRequestDispatcher("personInfo.jsp").forward(request, response);
		}else if("updatePwd".equals(action)){
			System.out.println("�����޸ġ�������");
			int staff_num=Integer.parseInt(request.getParameter("user_name"));
			String staff_password=request.getParameter("newpwd");
			PrintWriter out = response.getWriter();
			try {
				StaffVo staffVo=new StaffVo();
				staffVo.setStaff_num(staff_num);
				staffVo.setStaff_password(staff_password);
				
				StaffDaoImpl staffVoImpl=new StaffDaoImpl();
				staffVoImpl.updateStaffPwd(staffVo);
				//request.getSession().invalidate();//��sessionʧЧ����ת����¼���棡
				out.print("<script>alert('�޸ĳɹ��������µ�¼��');location='logout.jsp';</script>");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if("sss".equals(action)){
			System.out.println("��������ѯ������");
			String yiju=request.getParameter("f");//��ȡ����ֵ
			String result=request.getParameter("key");
			System.out.println("f"+yiju+".."+result);
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			
			ArrayList<StaffVo> list=null;
			if("num".equals(yiju)){
				list=staffDaoImpl.queryStaff_num(Integer.parseInt(result));
		 		
		 		
		 		request.setAttribute("lists", list);
		 		request.getRequestDispatcher("staff_list.jsp").forward(request, response);
			}else if("name".equals(yiju)){
				list=staffDaoImpl.queryStaff_name(result);
		 		
		 		
		 		request.setAttribute("lists", list);
		 		request.getRequestDispatcher("staff_list.jsp").forward(request, response);
			}else if("sex".equals(yiju)){
				list=staffDaoImpl.queryStaff_sex(result);
		 		
		 		
		 		request.setAttribute("lists", list);
		 		request.getRequestDispatcher("staff_list.jsp").forward(request, response);
			}else if("branch".equals(yiju)){
				list=staffDaoImpl.queryStaff_branch(result);
		 		
		 		
		 		request.setAttribute("lists", list);
		 		request.getRequestDispatcher("staff_list.jsp").forward(request, response);
			}else if("position".equals(yiju)){
				list=staffDaoImpl.queryStaff_position(result);
		 		
		 		
		 		request.setAttribute("lists", list);
		 		request.getRequestDispatcher("staff_list.jsp").forward(request, response);
			}	
		}else if("doLogin".equals(action)){
			System.out.println("��¼�жϡ�������");
			int yzm=Integer.parseInt((String)request.getSession().getAttribute("rand"));//�����֤��
			int yzm1=Integer.parseInt(request.getParameter("validateCodeImage"));//�������֤��
		PrintWriter out = response.getWriter();
		if(yzm==yzm1){
			System.out.println(yzm+":::"+yzm1);
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		//��ȡ�ύ�ı�Ԫ�ص�ֵ�����ݱ���name
			int staff_num=Integer.parseInt(request.getParameter("user_name"));
			String staff_password=request.getParameter("password");
			System.out.println(staff_num+":::"+staff_password);
			
			try {
				//��д��¼����
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_oa", "root", ""); 
				

				String sql = "select count(1) from staff where staff_num=? and staff_password=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, staff_num);
				pstmt.setString(2, staff_password);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					int count = rs.getInt(1);

					if (count > 0) {
						System.out.println("��¼�ɹ���");
						StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
						StaffVo staffVo=staffDaoImpl.queryStaffVo(staff_num); 
						request.getSession().setAttribute("staffVo", staffVo);
						request.getRequestDispatcher("index.jsp").forward(request, response); //��תһ��
						
					} else {
						System.out.println("��¼ʧ�ܣ�");
						out.print("<script>alert('��¼ʧ��,�˺Ż���������');location='login.jsp';</script>");
						//response.sendRedirect("login.jsp");
						out.close();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}else {
				out.print("<script>alert('��¼ʧ��,��֤����������');location='login.jsp';</script>");
				out.close();
			}
		}else if("branchQuery".equals(action)){
			System.out.println("������Ա��������");
			StaffDaoImpl staffDaoImpl=new StaffDaoImpl();
			ArrayList<StaffVo> list=staffDaoImpl.queryStaff();
	 		request.setAttribute("list", list);
	 		
	 		request.getRequestDispatcher("branch_add.jsp").forward(request, response);
		}
	}

}
