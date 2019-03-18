package com.npntraining.simplescheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleSchedulerJob implements Job {

	private static Logger logger = LoggerFactory.getLogger(SimpleSchedulerJob.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Simple Scheduler Job");
	}
}
