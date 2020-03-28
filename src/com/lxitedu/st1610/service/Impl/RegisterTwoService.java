package com.lxitedu.st1610.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.lxitedu.st1610.dao.Impl.PunchCardImpl;
import com.lxitedu.st1610.dao.Impl.RegisterImpl;
import com.lxitedu.st1610.vo.PunchVo;

public class RegisterTwoService {

	public List personage(int id ){
		RegisterImpl registerImpl=new RegisterImpl();
		String sql = "SELECT * FROM register WHERE register_staffNum="+id+"" ;
		List list = registerImpl.registerQuery_Personage(sql);
		return list;
	}
	public List personage_all(){//�鿴ȫ����ѯ��ٵȼ�¼
		RegisterImpl registerImpl=new RegisterImpl();
		String sql = "SELECT * FROM register" ;
		List list = registerImpl.registerQuery_Personage(sql);
		return list;
	}
	public Object personage_particular(String str ){//��Ա�������ϸ��ѯ��ٵȼ�¼
		RegisterImpl registerImpl=new RegisterImpl();
		String sql = "SELECT * FROM register WHERE register_id='"+str+"'" ;
		Object list = registerImpl.registerQuery_particular(sql);
		return list;
	}
	public List personage_num(String str ){//��Ա����Ų�ѯ��ٵȼ�¼
		RegisterImpl registerImpl=new RegisterImpl();
		String sql = "SELECT * FROM register WHERE register_staffNum='"+str+"'" ;
		List list = registerImpl.registerQuery_Personage(sql);
		return list;
	}
	public List personage_branch(String str ){//��Ա�����Ų�ѯ��ٵȼ�¼
		RegisterImpl registerImpl=new RegisterImpl();
		String sql = "SELECT * FROM register WHERE register_branch='"+str+"'" ;
		List list = registerImpl.registerQuery_Personage(sql);
		return list;
	}
	public List personage_name(String str ){//��Ա�����ֲ�ѯ��ٵȼ�¼
		RegisterImpl registerImpl=new RegisterImpl();
		String sql = "SELECT * FROM register WHERE register_name='"+str+"'" ;
		List list = registerImpl.registerQuery_Personage(sql);
		return list;
	}
	
	public List punchQuery(){//�鿴ȫ���򿨼�¼
		PunchCardImpl punchCardImpl = new PunchCardImpl();
		return (List) punchCardImpl.punchCard_Query();
	}
	public List punchQuery_Num(String str){//ѡ��Ա����Ų鿴�򿨼�¼
		PunchCardImpl punchCardImpl = new PunchCardImpl();
		String sql = "SELECT * FROM punch where punch_staffID='"+str+"'";
		return (List) punchCardImpl.punchCard_QuerySelect(sql);
	}
	public List punchQuery_Name(String str){//ѡ��Ա�������鿴�򿨼�¼
		PunchCardImpl punchCardImpl = new PunchCardImpl();
		String sql = "SELECT * FROM punch where punch_staffName='"+str+"'";
		return (List) punchCardImpl.punchCard_QuerySelect(sql);
	}
	public List punchQuery_branch(String str){//ѡ��Ա�����Ų鿴�򿨼�¼
		PunchCardImpl punchCardImpl = new PunchCardImpl();
		String sql = "SELECT * FROM punch WHERE punch_staffId IN (SELECT staff.staff_num FROM staff WHERE staff_branch='"+str+"');";
		return (List) punchCardImpl.punchCard_QuerySelect(sql);
	}
	public List personage_Punch(int id ){
		RegisterImpl registerImpl=new RegisterImpl();
		List list = registerImpl.registerQuery_PersonagePunch(id);
		return list;
	}
}
