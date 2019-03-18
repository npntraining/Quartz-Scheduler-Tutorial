package com.npntraining.simplescheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleScheduler {

	private static Logger logger = LoggerFactory.getLogger(SimpleScheduler.class);

	public static void main(String[] args) throws SchedulerException {

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		// Create Job
		JobDetail jobDetail = JobBuilder.newJob(SimpleSchedulerJob.class)
				.withIdentity("Simple Scheduler Job1", "Simple Scheduler Job Group").build();

		// Create Trigger
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Simple Trigger1", "Simple Trigger Group")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(5))
				.build();

		scheduler.scheduleJob(jobDetail, trigger);

		logger.info("Simple Scheduler Started");

		scheduler.start();

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		scheduler.shutdown(true);
		logger.info("Simple Scheduler Completed");
	}

}
