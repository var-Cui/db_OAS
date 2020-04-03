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
		//����
		if("1".equals(type)) {
			startDate = DateUtils.getWeekStartDate(1,new SimpleDateFormat("yyyy-MM-dd")) + " 00:00:00";
			endDate = DateUtils.getWeekEndDate(1,new SimpleDateFormat("yyyy-MM-dd")) + " 23:59:59";
		//����
		} else if ("2".equals(type)) {
			startDate = DateUtils.getStartMonth() + " 00:00:00";
			endDate = DateUtils.getEndMonth() + " 23:59:59";
		//����
		} else if ("3".equals(type)) {
			startDate = DateUtils.getStartYear() + " 00:00:00";
			endDate = DateUtils.getEndYear() + " 23:59:59";
		}
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    //�ϰ�  �°�  ���  ��� ���� 
	    PunchCardImpl punch = new PunchCardImpl();
	    RegisterImpl regis = new RegisterImpl();
	    if("0".equals(type)) {
	    	dataset.addValue(punch.queryPunch("�ϰ�"),"����","�ϰ�");
	    	dataset.addValue(punch.queryPunch("�°�"),"����","�°�");
	    	dataset.addValue(regis.queryNum("���"),"����","���");
	    	dataset.addValue(regis.queryNum("���"),"����","���");
	    	dataset.addValue(regis.queryNum("����"),"����","����");
	    } else {
	    	dataset.addValue(punch.queryPunch("�ϰ�",startDate,endDate),"����","�ϰ�");
	    	dataset.addValue(punch.queryPunch("�°�",startDate,endDate),"����","�°�");
	    	dataset.addValue(regis.queryNum("���",startDate,endDate),"����","���");
	    	dataset.addValue(regis.queryNum("���",startDate,endDate),"����","���");
	    	dataset.addValue(regis.queryNum("����",startDate,endDate),"����","����");
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
		dataset.setValue("�ٵ�",punch.queryPunchResult("�ٵ�"));
		dataset.setValue("����",punch.queryPunchResult("����"));
		dataset.setValue("����",punch.queryPunchResult("�ϸ�"));
	    return dataset;
	}
}
