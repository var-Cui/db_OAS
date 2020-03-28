package com.lxitedu.st1610.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxitedu.st1610.util.JDBCUtils;
import com.lxitedu.st1610.vo.ModelVo;

public class ModelDaoImpl {
	//²éÑ¯Ä£¿é
		public ArrayList<ModelVo> queryModel() {
			// TODO Auto-generated method stub
			Connection conn  = JDBCUtils.getConnection();
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
			return list;
		}
}
