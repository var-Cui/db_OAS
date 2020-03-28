package com.lxitedu.st1610.service;

import java.util.ArrayList;

import com.lxitedu.st1610.vo.PageVo;

public interface ExamineService {
	public ArrayList examinePlanQuery(PageVo p,String currPageNo,String examineType,String name);
}
