package com.npntraining.cronschedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CronSchedulerJob implements Job {

	private static Logger logger = LoggerFactory.getLogger(CronSchedulerJob.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Cron Scheduler Job");
	}
}
