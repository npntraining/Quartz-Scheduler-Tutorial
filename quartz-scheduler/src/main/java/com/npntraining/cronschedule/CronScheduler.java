package com.npntraining.cronschedule;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CronScheduler {

	private static Logger logger = LoggerFactory.getLogger(CronScheduler.class);

	public static void main(String[] args) throws SchedulerException {

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		JobDetail jobDetail = JobBuilder.newJob(CronSchedulerJob.class).withIdentity("Cron Job1", "Cron Job Group")
				.build();

		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Cron Trigger1", "Cron Trigger Group").startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

		scheduler.scheduleJob(jobDetail, trigger);

		scheduler.start();
		logger.info("Cron Scheduler started");

		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scheduler.shutdown(true);
		logger.info("Cron Scheduler Completed");
	}

}
