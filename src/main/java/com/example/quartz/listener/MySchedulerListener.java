package com.example.quartz.listener;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.listeners.SchedulerListenerSupport;

public class MySchedulerListener extends SchedulerListenerSupport {

	@Override
	public void jobAdded(JobDetail jobDetail) {
		this.getLog().info("added job: {}", jobDetail.toString());
		
	}

	@Override
	public void jobDeleted(JobKey jobKey) {
		
		
	}

	@Override
	public void jobPaused(JobKey jobKey) {
		
		
	}

	@Override
	public void jobResumed(JobKey jobKey) {
		
		
	}

	@Override
	public void jobScheduled(Trigger trigger) {
		
		
	}

	@Override
	public void jobsPaused(String jobGroup) {
		
		
	}

	@Override
	public void jobsResumed(String jobGroup) {
		
		
	}

	@Override
	public void jobUnscheduled(TriggerKey triggerKey) {
		
		
	}

	@Override
	public void schedulerError(String msg, SchedulerException cause) {
		
	}

	@Override
	public void schedulerInStandbyMode() {
		
		
	}

	@Override
	public void schedulerShutdown() {
		
		
	}

	@Override
	public void schedulerShuttingdown() {
		
		
	}

	@Override
	public void schedulerStarted() {
		
		
	}

	@Override
	public void schedulerStarting() {
		
		
	}

	@Override
	public void triggerFinalized(Trigger trigger) {
		
		
	}

	@Override
	public void triggerPaused(TriggerKey triggerKey) {
		
		
	}

	@Override
	public void triggerResumed(TriggerKey triggerKey) {
		
		
	}

	@Override
	public void triggersPaused(String triggerGroup) {
		
		
	}

	@Override
	public void triggersResumed(String triggerGroup) {
		
		
	}

	@Override
	public void schedulingDataCleared() {
		
		
	}

}
