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
		// TODO �Զ����ɵķ������
		Timer t = new Timer();
		String startDate = "2018-8-9 00:00:00";// ָ����ʼʱ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ָ��ʱ���ʽ
		Date d;
		try {
			d = format.parse(startDate);
			t.scheduleAtFixedRate(new SendMailTask(), d, 1000 * 60 * 60 * 8);// ָ���ӿ�ʼʱ����ÿ��8Сʱִ��һ��
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}

}
