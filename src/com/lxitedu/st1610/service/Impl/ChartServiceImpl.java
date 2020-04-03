package com.lxitedu.st1610.service.Impl;

import java.text.SimpleDateFormat;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.lxitedu.st1610.dao.Impl.RegisterImpl;
import com.lxitedu.st1610.service.ChartService;

import cn.lxitedu.st1610.dao.Impl.PunchCardImpl;
import cn.lxitedu.st1610.util.ColumnUtils;
import cn.lxitedu.st1610.util.DateUtils;

public class ChartServiceImpl implements ChartService {

	@Override
	public JFreeChart column(String type) {
		JFreeChart createCoColumnar = ColumnUtils.createCoColumnar(getDataSet(type));
		return createCoColumnar;
	}
	
	private static CategoryDataset getDataSet(String type) {
		String startDate = "";
		String endDate = "";
		//本周
		if("1".equals(type)) {
			startDate = DateUtils.getWeekStartDate(1,new SimpleDateFormat("yyyy-MM-dd")) + " 00:00:00";
			endDate = DateUtils.getWeekEndDate(1,new SimpleDateFormat("yyyy-MM-dd")) + " 23:59:59";
		//本月
		} else if ("2".equals(type)) {
			startDate = DateUtils.getStartMonth() + " 00:00:00";
			endDate = DateUtils.getEndMonth() + " 23:59:59";
		//本年
		} else if ("3".equals(type)) {
			startDate = DateUtils.getStartYear() + " 00:00:00";
			endDate = DateUtils.getEndYear() + " 23:59:59";
		}
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    //上班  下班  外出  请假 出差 
	    PunchCardImpl punch = new PunchCardImpl();
	    RegisterImpl regis = new RegisterImpl();
	    if("0".equals(type)) {
	    	dataset.addValue(punch.queryPunch("上班"),"数量","上班");
	    	dataset.addValue(punch.queryPunch("下班"),"数量","下班");
	    	dataset.addValue(regis.queryNum("外出"),"数量","外出");
	    	dataset.addValue(regis.queryNum("请假"),"数量","请假");
	    	dataset.addValue(regis.queryNum("出差"),"数量","出差");
	    } else {
	    	dataset.addValue(punch.queryPunch("上班",startDate,endDate),"数量","上班");
	    	dataset.addValue(punch.queryPunch("下班",startDate,endDate),"数量","下班");
	    	dataset.addValue(regis.queryNum("外出",startDate,endDate),"数量","外出");
	    	dataset.addValue(regis.queryNum("请假",startDate,endDate),"数量","请假");
	    	dataset.addValue(regis.queryNum("出差",startDate,endDate),"数量","出差");
	    }
	    return dataset;
	}
	
	@Override
	public JFreeChart pie() {
		return ColumnUtils.createPie(getDataSet());
	}
	
	private static DefaultPieDataset getDataSet() {
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    PunchCardImpl punch = new PunchCardImpl();
		dataset.setValue("迟到",punch.queryPunchResult("迟到"));
		dataset.setValue("早退",punch.queryPunchResult("早退"));
		dataset.setValue("正常",punch.queryPunchResult("合格"));
	    return dataset;
	}
}
