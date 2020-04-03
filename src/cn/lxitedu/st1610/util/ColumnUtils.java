package cn.lxitedu.st1610.util;

import java.awt.Font;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ColumnUtils {

	
	//����һ����״ͼ

	 //@param dataset
//	          ��״ͼ����
	 // @return

	public static JFreeChart createCoColumnar(CategoryDataset dataset) {
	    // ������״ͼ
		
	    JFreeChart chart = ChartFactory.createBarChart("����ͳ��", // ͼ�����
	            "��������", // x�����ʾ��ǩ
	            "����", // y�����ʾ��ǩ
	            dataset, // ����
	            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
	            true, // ��ʾͼ��
	            true, // ���ɹ���
	            true // URL����
	            );
	    // ������ͼ������������״ͼ����ɫ��������
	    chart.setBackgroundPaint(ChartColor.WHITE); // �����ܵı�����ɫ
	    // ���ͼ�ζ��󣬲�ͨ���˶����ͼ�ε���ɫ���ֽ�������
	    CategoryPlot polt = chart.getCategoryPlot();// ���ͼ�����
	    polt.setBackgroundPaint(ChartColor.lightGray);// ͼ�α�����ɫ
	    polt.setRangeGridlinePaint(ChartColor.WHITE);// ͼ�α����ɫ
	    // ���������
	    BarRenderer renderer = (BarRenderer) polt.getRenderer();
	    renderer.setMaximumBarWidth(0.06);
	    
//	    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//	    renderer.setBaseItemLabelsVisible(true);
//	    renderer.setBaseItemLabelFont(new Font("����", Font.BOLD, 15));
	    // ��������
	    getChartByFont(chart);

	    return chart;

	}


	//��״ͼ����������ʽ
	//
	// @param chart

	private static void getChartByFont(JFreeChart chart) {
	    // ͼ�����ñ�������
	    TextTitle textTitle = chart.getTitle();
	    textTitle.setFont(new Font("����", Font.BOLD, 20));

	    // ����ͼ��X����������
	    CategoryPlot plot = (CategoryPlot) chart.getPlot();
	    CategoryAxis axis = plot.getDomainAxis();
	    axis.setLabelFont(new Font("����", Font.BOLD, 22)); // ����X�������ϱ��������
	    axis.setTickLabelFont(new Font("����", Font.BOLD, 15)); // ����X�������ϵ�����

	    // ����ͼ��Y����������
	    ValueAxis valueAxis = plot.getRangeAxis();
	    valueAxis.setLabelFont(new Font("����", Font.BOLD, 12)); // ����Y�������ϱ��������
	    valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));// ����Y�������ϵ�����
	    // ������ʾ���ݵ�����
	    chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
	}
	
	
	public static JFreeChart createPie(DefaultPieDataset  dataset){
	    //������״ͼ
	    JFreeChart chart =ChartFactory.createPieChart3D("ռ�ȷ���", dataset, true, true, true);
	    //Ϊ��״ͼ��������
	    getChartByFontPie(chart);      
	    return chart;
	}
	/**
	 * �����״ͼ������
	 * @param chart
	 */
	private static void getChartByFontPie(JFreeChart chart){
	    //����ͼ���ϵ�����
        //���������������
        chart.getTitle().setFont(new Font("����",Font.BOLD,18));
        //�����ӱ�������
        chart.getLegend().setItemFont(new Font("����",Font.BOLD,15));
        //��ȡͼ���������
        PiePlot3D categoryPlot = (PiePlot3D)chart.getPlot();
        //����ͼ���ϵ�����
        categoryPlot.setLabelFont(new Font("����",Font.BOLD,15));
        //����ͼ�ε����ɸ�ʽΪ������  23 ��10%���������� ֵ �ٷֱȣ�
        String fm = "{0} {1} ({2})";
        categoryPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(fm));
	}
}
