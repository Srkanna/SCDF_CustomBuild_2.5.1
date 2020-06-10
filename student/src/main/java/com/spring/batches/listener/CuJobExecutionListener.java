package com.spring.batches.listener;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**************************************************************************
 * Class for
 * @author RSHANMUGAM2:Apr 21, 2020: 5:20:00 PM
 **************************************************************************/
@Component
public class CuJobExecutionListener implements JobExecutionListener {

	Logger logger = LoggerFactory.getLogger(CuJobExecutionListener.class);
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		logger.info("JobExecutionListener: {}",jobExecution.getJobInstance().getJobName());
		logger.info("JobExecutionListener: {}",jobExecution.getJobId());
		logger.info("GetStartTime(): {}",jobExecution.getStartTime());
		logger.info("GetEndTime(): {}",jobExecution.getEndTime());
		logger.info("GetEndTime(): {}",jobExecution.getStatus());
	}
}