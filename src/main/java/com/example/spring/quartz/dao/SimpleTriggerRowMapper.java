package com.example.spring.quartz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.jdbcjobstore.Constants;
import org.springframework.jdbc.core.RowMapper;

public class SimpleTriggerRowMapper implements RowMapper<TriggerAndStatus> {

	@Override
	public TriggerAndStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
																  .withIntervalInMilliseconds(rs.getLong(Constants.COL_REPEAT_INTERVAL))
																  .withRepeatCount(rs.getInt(Constants.COL_REPEAT_COUNT));
		
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
