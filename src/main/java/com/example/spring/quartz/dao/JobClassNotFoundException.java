package com.example.spring.quartz.dao;

import java.sql.SQLException;

public class JobClassNotFoundException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2321900907819277202L;

	protected JobClassNotFoundException(String reason, Throwable cause) {
		super(reason, cause);
		
	}

}
