package com.lxitedu.st1610.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import com.lxitedu.st1610.service.Impl.ChartServiceImpl;


/**
 * Servlet implementation class ChartServlet
 */
public class ChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		ChartServiceImpl chartServiceImpl = new ChartServiceImpl();
		JFreeChart column = chartServiceImpl.column(type);
		String fileName = ServletUtilities.saveChartAsJPEG(column, 800, 600,request.getSession());
		String chartURL = request.getContextPath() + "/chart?filename="+ fileName;
		request.setAttribute("type",type);
		request.setAttribute("chartURL",chartURL);
		JFreeChart pie = chartServiceImpl.pie();
		String pieName = ServletUtilities.saveChartAsJPEG(pie, 800, 600,request.getSession());
		String pieURL = request.getContextPath() + "/chart?filename="+ pieName;
		request.setAttribute("pieURL",pieURL);
		request.getRequestDispatcher("chart.jsp").forward(request, response);
	}

}
