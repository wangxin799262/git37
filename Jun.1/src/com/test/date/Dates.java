package com.test.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dates {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat s = new SimpleDateFormat("yy年MM月dd日  hh时mm分ss秒  EEEE");
		System.out.println(s.format(d));
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.DAY_OF_WEEK,calendar.FRIDAY);
		System.out.println(s.format(calendar.getTime()));
		System.out.println("加一个");
		
		
		
	}
	
	

}
