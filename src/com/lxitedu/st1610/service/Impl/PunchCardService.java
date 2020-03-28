package com.lxitedu.st1610.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lxitedu.st1610.dao.Impl.PunchCardImpl;

public class PunchCardService {
	public static String punchCard_morning(int id,String punch_type,Date date){
		SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd");
		String strThree = sdfTwo.format(date); 
		PunchCardImpl punchCardImpl = new PunchCardImpl();
		strThree=punchCardImpl.punchCard_date(id,punch_type,strThree);
		if("今日上班已打卡".equals(strThree)){
			return strThree;
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String str = sdf.format(date);
			Date time = null;
			Date timeTwo = null;
			String strTwo = "";
			try {
				time = (Date) sdf.parse("8:00:00");
				timeTwo = (Date) sdf.parse(str);
				if(time.getTime()<timeTwo.getTime()){
					strTwo="迟到";
				}else{
					strTwo="合格";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return strTwo;
		}
		
		
	}
	public static String punchCard_lateness(int id,String punch_type,Date date){
		SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd");
		String strThree = sdfTwo.format(date); 
		PunchCardImpl punchCardImpl = new PunchCardImpl();
		String strFour=punchCardImpl.punchCard_date(id,"上班",strThree);
		String strTwo = "";
		if("今日上班未打卡".equals(strFour)){
			return strFour;
		}else{
			String strFive = punchCardImpl.punchCard_date(id,punch_type,strThree);
			if("今日下班未打卡".equals(strFive)){
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String str = sdf.format(date);
				Date time = null;
				Date timeTwo = null;
				try {
					time = (Date) sdf.parse("18:00:00");
					timeTwo = (Date) sdf.parse(str);
					if(time.getTime()<timeTwo.getTime()){
						strTwo="合格";
					}else{
						strTwo="早退";
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return strTwo;
			}else{
				return strFive;
			}
		}
	}
}
