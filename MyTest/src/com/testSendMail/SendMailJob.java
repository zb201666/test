package com.testSendMail;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SendMailJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO �Զ����ɵķ������
		SendMail.sendMail("smtp.qq.com", "1639047465@qq.com",
				"bin2.zhang@changhong.com", "xmcjhfjpsludfddf");
	}

}
