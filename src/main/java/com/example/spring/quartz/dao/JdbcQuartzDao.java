package com.example.spring.quartz.dao;

import java.util.List;

import org.quartz.JobDetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcQuartzDao implements QuartzDao {

	//private static final Logger LOGGER = LoggerFactory.getLogger(JdbcQuartzDao.class);
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final String JOB_DETAILS_SQL = "SELECT JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME FROM QRTZ_JOB_DETAILS WHERE SCHED_NAME = :schedName";
	
	private static final String SIMPLE_TRIGGERS_SQL = "SELECT t.TRIGGER_NAME, t.TRIGGER_GROUP, t.DESCRIPTION, t.JOB_NAME, t.JOB_GROUP, t.PRIORITY, t.START_TIME, t.END_TIME, t.TRIGGER_STATE, st.REPEAT_INTERVAL, st.REPEAT_COUNT FROM QRTZ_TRIGGERS t INNER JOIN QRTZ_SIMPLE_TRIGGERS st ON t.SCHED_NAME = st.SCHED_NAME AND t.TRIGGER_NAME = st.TRIGGER_NAME AND t.TRIGGER_GROUP = st.TRIGGER_GROUP WHERE t.SCHED_NAME = :schedName";
	
	private static final String CRON_TRIGGERS_SQL = "SELECT t.TRIGGER_NAME, t.TRIGGER_GROUP, t.DESCRIPTION, t.JOB_NAME, t.JOB_GROUP, t.PRIORITY, t.START_TIME, t.END_TIME, t.TRIGGER_STATE, ct.CRON_EXPRESSION, ct.TIME_ZONE_ID FROM QRTZ_TRIGGERS t INNER JOIN QRTZ_CRON_TRIGGERS ct ON t.SCHED_NAME = ct.SCHED_NAME AND t.TRIGGER_NAME = ct.TRIGGER_NAME AND t.TRIGGER_GROUP = ct.TRIGGER_GROUP WHERE t.SCHED_NAME = :schedName";
	
	@Override
	public List<JobDetail> getAllJobDetails(String schedName) {
		
		return this.namedParameterJdbcTemplate.query(JOB_DETAILS_SQL, new MapSqlParameterSource("schedName", schedName), new JobDetailRowMapper());
	}

	@Override
	public List<TriggerAndStatus> getAllSimpleTriggers(String schedName) {
		
		return this.namedParameterJdbcTemplate.query(SIMPLE_TRIGGERS_SQL, new MapSqlParameterSource("schedName", schedName), new SimpleTriggerRowMapper());
	}

	@Override
	public List<TriggerAndStatus> getAllCronTriggers(String schedName) {
		
		return this.namedParameterJdbcTemplate.query(CRON_TRIGGERS_SQL, new MapSqlParameterSource("schedName", schedName), new CronTriggerRowMapper());
	}

}
