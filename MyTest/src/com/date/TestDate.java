package com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String dateNowStr = sdf.format(date);
		for (int i = 0000; i <= 9999; i++) {
			String str = dateNowStr + "-" + i;
			if (i % 99 == 0) {
				System.out.println(str);
			}
		}
		System.out.println("��ʽ��������ڣ�" + dateNowStr);

		Calendar now = Calendar.getInstance();
		System.out.println("��: " + now.get(Calendar.YEAR));
	}

}
