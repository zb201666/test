package com.testSendMail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class SendMailOnTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Timer t = new Timer();
		String startDate = "2018-8-9 00:00:00";// 指定开始时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 指定时间格式
		Date d;
		try {
			d = format.parse(startDate);
			t.scheduleAtFixedRate(new SendMailTask(), d, 1000 * 60 * 60 * 8);// 指定从开始时间起每隔8小时执行一次
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
