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
		// TODO 自动生成的方法存根
		Logger logger = Logger.getLogger(Log4jDemo.class);
		BasicConfigurator.configure();//使用默认配置信息
//		logger.setLevel(Level.INFO);//设置输出级别，低于INFO级别的不输出
//		logger.info("=========");
//		logger.warn("=========");
//		logger.error("=========");
//		logger.fatal("=========");
		outLogFile(logger);
		
	}

	public static void outLogFile(Logger logger){
		SimpleLayout layout1 = new SimpleLayout();//简单模式，级别-信息
		TTCCLayout layout2 = new TTCCLayout();//包含日志产生的时间、线程、类别等等信息
		PatternLayout layout3 = new PatternLayout ();//根据指定的转换模式格式化日志输出，或者如果没有指定任何转换模式，就使用默认的转化模式格式。
		HTMLLayout layout4 = new HTMLLayout ();//格式化日志输出为HTML表格形式
		
		//=====================================================
		
		//FileAppender appender = null;//将日志信息输出到一个文件
		//appender = new FileAppender(layout4,"C:\\word\\log.html",false);
		//appender = new FileAppender(layout2,"C:\\word\\log.txt",false);
		
		DailyRollingFileAppender appender1 = null;//将日志信息输出到一个日志文件，并且每天输出到一个新的日志文件
		DailyRollingFileAppender appender2 = null;//将日志信息输出到一个日志文件，并且每天输出到一个新的日志文件
		DailyRollingFileAppender appender3 = null;//将日志信息输出到一个日志文件，并且每天输出到一个新的日志文件
		DailyRollingFileAppender appender4 = null;//将日志信息输出到一个日志文件，并且每天输出到一个新的日志文件
		try {
			appender1 = new DailyRollingFileAppender(layout1,"C:\\word\\log1.txt","'.'yyyy-MM-dd");
			appender2 = new DailyRollingFileAppender(layout2,"C:\\word\\log2.txt","'.'yyyy-MM-dd");
			appender3 = new DailyRollingFileAppender(layout3,"C:\\word\\log3.txt","'.'yyyy-MM-dd");
			appender4 = new DailyRollingFileAppender(layout4,"C:\\word\\log.html","'.'yyyy-MM-dd");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		ConsoleAppender appender5 = null;//将日志信息输出到控制台
		appender5 = new ConsoleAppender(layout2);
		
		
		RollingFileAppender appender6 = null;
		try {
			//将日志信息输出到一个日志文件，并且指定文件的尺寸，当文件大小达到指定尺寸时，会自动把文件改名，同时产生一个新的文件
			appender6 = new RollingFileAppender(layout4,"C:\\word\\log1.html",true);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
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
