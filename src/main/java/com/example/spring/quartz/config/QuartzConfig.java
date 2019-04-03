package com.example.spring.quartz.config;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import com.example.spring.quartz.constant.QuartzConstant;
import com.example.spring.quartz.job.MyJob;

//@Configuration
public class QuartzConfig {

	//@Bean(name = "exampleJob")
	public JobDetailFactoryBean exampleJob() {
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(MyJob.class);
		jobDetailFactoryBean.setName("myJob1");
		jobDetailFactoryBean.setGroup("group1");
		jobDetailFactoryBean.setDescription("this is my first job");
		jobDetailFactoryBean.setDurability(true);
		jobDetailFactoryBean.setApplicationContextJobDataKey(QuartzConstant.QUARTZ_SPRING_CONTEXT_KEY);
		JobDataMap dataMap = new JobDataMap();
		dataMap.put("say", "Hello World");
		jobDetailFactoryBean.setJobDataMap(dataMap);
		return jobDetailFactoryBean;
	}
	
	//@Bean(value = "exampleJobTrigger")
	public CronTriggerFactoryBean exampleJobTrigger(@Qualifier(value = "exampleJob") JobDetail jobDetail) {
		CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
		triggerFactoryBean.setName("task1");
		triggerFactoryBean.setGroup("group1");
		triggerFactoryBean.setCronExpression("0 0/1 * * * ?");
		//triggerFactoryBean.setMisfireInstruction(misfireInstruction);
		triggerFactoryBean.setPriority(5);
		triggerFactoryBean.setDescription("this is my ...");
		triggerFactoryBean.setJobDetail(jobDetail);
		return triggerFactoryBean;
	}
}
