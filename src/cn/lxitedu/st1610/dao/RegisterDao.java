package cn.lxitedu.st1610.dao;

import java.util.List;

import cn.lxitedu.st1610.bean.RegisterVo;

public interface RegisterDao {
	boolean registerAdd(RegisterVo register);
	boolean registerDelete(int register_id);
	boolean registerUpdate(RegisterVo register);
	List<RegisterVo> registerQuery();

}
