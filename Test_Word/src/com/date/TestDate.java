package com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String dateNowStr = sdf.format(date);
		for (int i = 0000; i <= 9999; i++) {
			String str = dateNowStr + "-" + i;
			if (i % 99 == 0) {
				System.out.println(str);
			}
		}
		System.out.println("格式化后的日期：" + dateNowStr);

		Calendar now = Calendar.getInstance();
		System.out.println("年: " + now.get(Calendar.YEAR));
	}

}
