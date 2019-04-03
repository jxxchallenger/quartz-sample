package com.example.spring.quartz.service;

import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.jdbcjobstore.Constants;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.quartz.dao.QuartzDao;
import com.example.spring.quartz.dao.TriggerAndStatus;

@Service
public class JobInitServiceImpl implements InitializingBean{

	@Autowired
	private Scheduler scheduler;
	
	@Autowired
	private QuartzDao quartzDao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		List<JobDetail> jobDetails = quartzDao.getAllJobDetails(scheduler.getSchedulerName());
		
		List<TriggerAndStatus> simpleTriggerAndStatus = quartzDao.getAllSimpleTriggers(scheduler.getSchedulerName());
		
		List<TriggerAndStatus> cronTriggerAndStatus = quartzDao.getAllCronTriggers(scheduler.getSchedulerName());
		
		for(JobDetail jobDetail : jobDetails) {
			scheduler.addJob(jobDetail, false);
		}
		
		for(TriggerAndStatus triggerAndStatus : simpleTriggerAndStatus) {
			scheduler.scheduleJob(triggerAndStatus.getTrigger());
			if(Constants.STATE_PAUSED.equals(triggerAndStatus.getStatus())) {
				scheduler.pauseTrigger(triggerAndStatus.getTrigger().getKey());
			}
		}
		
		for(TriggerAndStatus triggerAndStatus : cronTriggerAndStatus) {
			scheduler.scheduleJob(triggerAndStatus.getTrigger());
			if(Constants.STATE_PAUSED.equals(triggerAndStatus.getStatus())) {
				scheduler.pauseTrigger(triggerAndStatus.getTrigger().getKey());
			}
		}
	}

}
