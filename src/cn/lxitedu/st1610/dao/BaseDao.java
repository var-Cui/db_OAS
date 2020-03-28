package cn.lxitedu.st1610.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * 操作数据库的工具类
 * 
 * @author Administrator
 *
 */
public class BaseDao {
	private final static String driverUrl = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/db_oa";
	private final static String userName = "root";
	private final static String pwd = "123456";
	
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;

	public Connection getConnection() {
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
	 * 关闭所有资源
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public void closeAll(Connection conn, Statement stat, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 实现增，删，改操作
	 * @param sql
	 * @param parms
	 * @return
	 */
	public int executeUpdate(String sql,Object[] parms){
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if(parms!=null){
				for(int i=0;i<parms.length;i++){
					pstmt.setObject(i + 1, parms[i]);
				}
				return pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return -1;
	}
	
	
	/**
	 * 实现查询操作
	 * @param sql
	 * @param parms
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object[] parms){
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			if(parms!=null){
				for(int i=0;i<parms.length;i++){
					pstmt.setObject(i+1, parms[i]);
				}
			}
			return pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
