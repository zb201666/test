package com.testSendMail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.HolidayCalendar;

public class SendMailOnTime2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			Date date = null;
			String startDate = "2018-8-9 16:45:00";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(startDate);

			// 排除特定的节假日
			HolidayCalendar hocal = new HolidayCalendar();
			Calendar cal = Calendar.getInstance();
			cal.set(2018, 9, 24);
			Date hodate1 = cal.getTime();
			cal.set(2018, 10, 1);
			Date hodate2 = cal.getTime();
			cal.set(Calendar.DAY_OF_YEAR, 1);
			Date hodate3 = cal.getTime();
			hocal.addExcludedDate(hodate1);
			hocal.addExcludedDate(hodate2);
			hocal.addExcludedDate(hodate3);
			Scheduler sched = new StdSchedulerFactory().getScheduler();
			sched.start();
			sched.addCalendar("myHolidays", hocal, false, false);
			JobDetail job = JobBuilder.newJob(SendMailJob.class)
					.withIdentity("sendMailJob").build();
			SimpleScheduleBuilder.simpleSchedule();
			// 按小时计算，每小时发送一次
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("sendMailTrigger")
					.startAt(date)
					.withSchedule(
							SimpleScheduleBuilder.repeatMinutelyForever(60))
					.modifiedByCalendar("myHolidays").build();

			sched.scheduleJob(job, trigger);
		} catch (SchedulerException | ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
