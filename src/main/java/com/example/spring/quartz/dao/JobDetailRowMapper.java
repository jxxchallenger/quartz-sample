package com.example.spring.quartz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.impl.jdbcjobstore.Constants;
import org.quartz.simpl.SimpleClassLoadHelper;
import org.quartz.spi.ClassLoadHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

public class JobDetailRowMapper implements RowMapper<JobDetail> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JobDetailRowMapper.class);

	private static ClassLoadHelper loadHelper = new SimpleClassLoadHelper();
	
	@Override
	public JobDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		try {
			return JobBuilder.newJob(loadHelper.loadClass(rs.getString(Constants.COL_JOB_CLASS), Job.class))
					.withIdentity(rs.getString(Constants.COL_JOB_NAME), rs.getString(Constants.COL_JOB_GROUP))
					.withDescription(rs.getString(Constants.COL_DESCRIPTION))
					.storeDurably()
					.requestRecovery()
					.build();
		} catch (ClassNotFoundException e) {
			LOGGER.error("Can't find Class for job: {}", rs.getString(Constants.COL_JOB_CLASS));
			throw new JobClassNotFoundException("Can't find the class of " + rs.getString(Constants.COL_JOB_CLASS), e);
		}
		
	}

}
