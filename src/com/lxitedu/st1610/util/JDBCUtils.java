package com.lxitedu.st1610.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



	



	

	/**
	 * �������ݿ�Ĺ�����
	 * 
	 * @author Administrator
	 *
	 */
	public class JDBCUtils {

		private final static String driverUrl = "com.mysql.jdbc.Driver";
		private final static String url = "jdbc:mysql://localhost:3306/db_oa";
		private final static String userName = "root";
		private final static String pwd = "";

		public Connection conn = null;
		public PreparedStatement pstmt = null;
		public ResultSet rs = null;

		/**
		 * ��ȡ���Ӷ���
		 * 
		 * @return �õ������Ӷ���
		 */
		public static  Connection getConnection() {
			Connection conn = null;
			try {
				Class.forName(driverUrl);
				conn = DriverManager.getConnection(url, userName, pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return conn;
		}

		/**
		 * �ر�������Դ
		 * 
		 * @param conn
		 * @param stmt
		 * @param rs
		 */
		public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
