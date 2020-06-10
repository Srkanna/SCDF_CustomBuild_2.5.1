package com.spring.batches.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig extends DefaultTaskConfigurer 
{

	Logger logger = LoggerFactory.getLogger(TaskConfig.class);
	
	@Autowired
	@Qualifier("facDatasource")
	DataSource facDataSource;

	@Autowired
	public TaskConfig(@Qualifier("facDatasource") DataSource dataSource) {
		super(dataSource);
	}
}