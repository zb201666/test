package com.testlog4j;

import org.apache.log4j.Logger;

public class testLog4jProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Logger logger = Logger.getLogger(testLog4jProperties.class);
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
	}

}
