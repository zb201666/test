package com.testSendMail;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SendMailOnTime1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors
				.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				SendMail.sendMail("smtp.qq.com", "1639047465@qq.com",
						"bin2.zhang@changhong.com", "xmcjhfjpsludfddf");
			}

		}, 0, 1000 * 60 * 60, TimeUnit.HOURS);// 按小时计算，每小时发送一次。
	}

}
