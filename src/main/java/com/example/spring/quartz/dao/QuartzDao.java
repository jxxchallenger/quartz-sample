package com.example.spring.quartz.dao;

import java.util.List;

import org.quartz.JobDetail;

public interface QuartzDao {

	List<JobDetail> getAllJobDetails(String schedName);
	
	List<TriggerAndStatus> getAllSimpleTriggers(String schedName);
	
	List<TriggerAndStatus> getAllCronTriggers(String schedName);
}
