package com.example.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.listeners.JobListenerSupport;

public class MyJobListener extends JobListenerSupport {

	private String name; 
	
	@Override
	public String getName() {
		
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		
		super.jobToBeExecuted(context);
		getLog().info("before job executed");
	}

	
}
