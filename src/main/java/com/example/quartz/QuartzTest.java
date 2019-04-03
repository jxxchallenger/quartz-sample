package com.example.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import com.example.quartz.listener.MySchedulerListener;


public class QuartzTest {

    public static void main(String[] args) {

        try {
            // Grab the Scheduler instance from the Factory
        	StdSchedulerFactory schedulerFactory = new StdSchedulerFactory("quartz.properties");
            Scheduler scheduler = schedulerFactory.getScheduler();
            
            scheduler.getListenerManager().addSchedulerListener(new MySchedulerListener());

            // and start it off
            scheduler.start();
			/*
			 * JobDetail job = JobBuilder.newJob(HelloJob.class) .withIdentity("job1",
			 * "group1") .usingJobData("say", "Hello world!") .build();
			 */
            
            
            //ScheduleBuilder<CronTrigger> scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * * * ?");
            
			/*
			 * Trigger trigger = TriggerBuilder.newTrigger() .withIdentity("trigger1",
			 * "group1") .startAt(DateBuilder.futureDate(5, IntervalUnit.SECOND))
			 * .withSchedule(scheduleBuilder) .build();
			 */
            //添加listener方式一：
            //scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());
            
            
            //scheduler.scheduleJob(job, trigger);
            
            
            try {
				Thread.sleep(80000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
