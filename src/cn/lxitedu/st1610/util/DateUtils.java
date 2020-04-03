package cn.lxitedu.st1610.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	/**
     * ��ȡ��ֹ����
     * @param sdf ��Ҫ��ʾ�����ڸ�ʽ
     * @param date ��Ҫ���յ�����
     * @param n ���n��
     * @param option 0 ��ʼ���ڣ�1 ��������
     * @param k 0 �������� 1 ����������
     * @return
     */
    public static String getFromToDate(SimpleDateFormat sdf, Date date, int n, int option, int k) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 0 == option ? 1 - dayOfWeek : 7 - dayOfWeek;
        int amount = 0 == option ? offset - (n - 1  + k) * 7 : offset - k * 7;
        calendar.add(Calendar.DATE, amount);
        return sdf.format(calendar.getTime());
    }
    
    public static String getWeekStartDate(int n, SimpleDateFormat sdf) {
        String beginDate = getFromToDate(sdf, new Date(), n, 0, 0);
        return beginDate;
    }
    
    public static String getWeekEndDate(int n, SimpleDateFormat sdf) {
        String endDate = getFromToDate(sdf, new Date(), n, 1, 0);
        return endDate;
    }
    
    public static String getStartMonth() {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
    
    public static String getEndMonth() {
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
    
    public static String getStartYear() {
    	Calendar currCal = Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR,currentYear);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
    
    public static String getEndYear() {
    	Calendar currCal = Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
}
