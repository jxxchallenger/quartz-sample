package com.example.spring.quartz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.jdbcjobstore.Constants;
import org.springframework.jdbc.core.RowMapper;

public class CronTriggerRowMapper implements RowMapper<TriggerAndStatus> {

	@Override
	public TriggerAndStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CronScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule(rs.getString(Constants.COL_CRON_EXPRESSION)).inTimeZone(TimeZone.getTimeZone(rs.getString(Constants.COL_TIME_ZONE_ID)));
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP))
				 .withDescription(rs.getString(Constants.COL_DESCRIPTION))
				 .forJob(rs.getString(Constants.COL_JOB_NAME), rs.getString(Constants.COL_JOB_GROUP))
				 .withPriority(rs.getInt(Constants.COL_PRIORITY))
				 .startAt(new Date(rs.getLong(Constants.COL_START_TIME)))
				 .endAt(rs.getLong(Constants.COL_END_TIME) > 0 ? new Date(rs.getLong(Constants.COL_END_TIME)) : null)
				 .withSchedule(schedBuilder)
				 .build();

		String status = rs.getString(Constants.COL_TRIGGER_STATE);
						 
		
		return new TriggerAndStatus(trigger, status);
	}

}