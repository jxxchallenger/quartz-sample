package com.example.spring.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyJob.class);
	
	private String say;
	
	public String getSay() {
		return say;
	}

	public void setSay(String say) {
		this.say = say;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		LOGGER.info(this.say);
		context.setResult(this.say);
	}

}
