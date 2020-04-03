package com.lxitedu.st1610.service;

import org.jfree.chart.JFreeChart;

public interface ChartService {

	public JFreeChart column(String type);
	
	public JFreeChart pie();
	
}
