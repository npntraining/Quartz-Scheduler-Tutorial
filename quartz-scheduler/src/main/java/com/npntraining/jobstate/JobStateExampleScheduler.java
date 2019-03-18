package com.npntraining.jobstate;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
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

public class JobStateExampleScheduler {

	private static Logger logger = LoggerFactory.getLogger(JobStateExampleScheduler.class);

	public static void main(String[] args) throws SchedulerException, InterruptedException {

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		scheduler.start();
		logger.info("SimpleSchedulerWithJobState Started");

		// Job DataMap
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("Name", "NPN Training");

		// JobDetail
		JobDetail jobDetail = JobBuilder.newJob(JobStateExampleJob.class)
				.withIdentity("Job State Example Job1", "Job State Example Job Group").setJobData(jobDataMap).build();

		// Trigger
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("Job State Example Trigger1", "Job State Example Trigger Group")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(5))
				.build();

		scheduler.scheduleJob(jobDetail, trigger);

		Thread.sleep(30000L);

		scheduler.shutdown(true);
		logger.info("SimpleSchedulerWithJobState Completed");

	}

}
