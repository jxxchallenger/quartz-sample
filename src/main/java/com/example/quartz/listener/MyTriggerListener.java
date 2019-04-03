package com.example.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.listeners.TriggerListenerSupport;

public class MyTriggerListener extends TriggerListenerSupport {

	private String name;
	
	@Override
	public String getName() {
		
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		this.getLog().info("trigger fired: {}", trigger.toString());
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
	}

}
