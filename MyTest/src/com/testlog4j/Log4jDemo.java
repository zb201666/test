package com.testlog4j;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.TTCCLayout;

public class Log4jDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Logger logger = Logger.getLogger(Log4jDemo.class);
		BasicConfigurator.configure();//ʹ��Ĭ��������Ϣ
//		logger.setLevel(Level.INFO);//����������𣬵���INFO����Ĳ����
//		logger.info("=========");
//		logger.warn("=========");
//		logger.error("=========");
//		logger.fatal("=========");
		outLogFile(logger);
		
	}

	public static void outLogFile(Logger logger){
		SimpleLayout layout1 = new SimpleLayout();//��ģʽ������-��Ϣ
		TTCCLayout layout2 = new TTCCLayout();//������־������ʱ�䡢�̡߳����ȵ���Ϣ
		PatternLayout layout3 = new PatternLayout ();//����ָ����ת��ģʽ��ʽ����־������������û��ָ���κ�ת��ģʽ����ʹ��Ĭ�ϵ�ת��ģʽ��ʽ��
		HTMLLayout layout4 = new HTMLLayout ();//��ʽ����־���ΪHTML�����ʽ
		
		//=====================================================
		
		//FileAppender appender = null;//����־��Ϣ�����һ���ļ�
		//appender = new FileAppender(layout4,"C:\\word\\log.html",false);
		//appender = new FileAppender(layout2,"C:\\word\\log.txt",false);
		
		DailyRollingFileAppender appender1 = null;//����־��Ϣ�����һ����־�ļ�������ÿ�������һ���µ���־�ļ�
		DailyRollingFileAppender appender2 = null;//����־��Ϣ�����һ����־�ļ�������ÿ�������һ���µ���־�ļ�
		DailyRollingFileAppender appender3 = null;//����־��Ϣ�����һ����־�ļ�������ÿ�������һ���µ���־�ļ�
		DailyRollingFileAppender appender4 = null;//����־��Ϣ�����һ����־�ļ�������ÿ�������һ���µ���־�ļ�
		try {
			appender1 = new DailyRollingFileAppender(layout1,"C:\\word\\log1.txt","'.'yyyy-MM-dd");
			appender2 = new DailyRollingFileAppender(layout2,"C:\\word\\log2.txt","'.'yyyy-MM-dd");
			appender3 = new DailyRollingFileAppender(layout3,"C:\\word\\log3.txt","'.'yyyy-MM-dd");
			appender4 = new DailyRollingFileAppender(layout4,"C:\\word\\log.html","'.'yyyy-MM-dd");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		ConsoleAppender appender5 = null;//����־��Ϣ���������̨
		appender5 = new ConsoleAppender(layout2);
		
		
		RollingFileAppender appender6 = null;
		try {
			//����־��Ϣ�����һ����־�ļ�������ָ���ļ��ĳߴ磬���ļ���С�ﵽָ���ߴ�ʱ�����Զ����ļ�������ͬʱ����һ���µ��ļ�
			appender6 = new RollingFileAppender(layout4,"C:\\word\\log1.html",true);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		logger.addAppender(appender6);
		logger.addAppender(appender5);
		logger.addAppender(appender1);
		logger.addAppender(appender2);
		logger.addAppender(appender3);
		logger.addAppender(appender4);
		logger.setLevel(Level.DEBUG);
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
	}
}
