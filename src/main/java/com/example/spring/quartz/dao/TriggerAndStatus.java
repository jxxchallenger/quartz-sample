package com.example.spring.quartz.dao;

import org.quartz.Trigger;

public class TriggerAndStatus {

	private Trigger trigger;
	
	private String status;

	protected TriggerAndStatus(Trigger trigger, String status) {
		super();
		this.trigger = trigger;
		this.status = status;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
