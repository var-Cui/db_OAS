package cn.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.lxitedu.st1610.util.JDBCUtils;
import cn.lxitedu.st1610.bean.MaintainVo;
import cn.lxitedu.st1610.bean.ModelVo;
import cn.lxitedu.st1610.dao.BaseDao;
import cn.lxitedu.st1610.dao.ModelVoDao;

public class ModelDaoImpl extends BaseDao implements ModelVoDao{
	//²éÑ¯Ä£¿é
		public List<ModelVo> queryModel() {
			// TODO Auto-generated method stub
			/*Connection conn  = JDBCUtils.getConnection();
			PreparedStatement pre=null;
			ResultSet res=null;
			ModelVo modelVo=null;
			ArrayList<ModelVo> list=new ArrayList<ModelVo>();
			try {
				pre=conn.prepareStatement("select * from model;");
				res=pre.executeQuery();
				while(res.next()){
					modelVo =new ModelVo();
					modelVo.setMaintain_model(res.getInt("maintain_model"));
					modelVo.setMaintain_name(res.getString("maintain_name"));
					list.add(modelVo);
					modelVo=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtils.closeAll(conn, pre, res);
			}
			return list;*/
			List<ModelVo> list = new ArrayList<>();
			String sql = "select * from model;";
			try {
				this.rs = executeQuery(sql, null);
				while (this.rs.next()) {
					ModelVo modelVo =new ModelVo();
					modelVo.setMaintain_model(rs.getInt("maintain_model"));
					modelVo.setMaintain_name(rs.getString("maintain_name"));
					list.add(modelVo);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, pstmt, rs);
			}
			return null;
		}
}
