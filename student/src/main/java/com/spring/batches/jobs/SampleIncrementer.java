package com.spring.batches.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.stereotype.Component;

@Component
public class SampleIncrementer implements JobParametersIncrementer {
	Logger logger = LoggerFactory.getLogger(SampleIncrementer.class);
	public JobParameters getNext(JobParameters parameters) {
		logger.info("In sample incrementer");
		JobParametersBuilder param = new JobParametersBuilder();
		param.addString("JobID", String.valueOf(System.currentTimeMillis()));
		return new JobParametersBuilder().toJobParameters();
	}

}