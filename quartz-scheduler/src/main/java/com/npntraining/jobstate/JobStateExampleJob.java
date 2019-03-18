package com.npntraining.jobstate;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobStateExampleJob implements Job {

	private static Logger logger = LoggerFactory.getLogger(JobStateExampleJob.class);

	public void execute(JobExecutionContext context) throws JobExecutionException {

		logger.info("Welcome to " + context.getJobDetail().getJobDataMap().getString("Name"));
	}
}
