package com.example.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob implements Job {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloJob.class);
	
	/*
	 * private String say;
	 * 
	 * public String getSay() { return say; }
	 * 
	 * public void setSay(String say) { this.say = say; }
	 */

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOGGER.info("hello world");
		context.setResult("ok");
	}

}
