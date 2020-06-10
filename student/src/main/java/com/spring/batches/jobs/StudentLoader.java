package com.spring.batches.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.configuration.EnableTask;
//import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.batches.domain.DomainObjects;
import com.spring.batches.domain.Students;
import com.spring.batches.reader.StudentsConfigurer;
import com.spring.batches.utility.ApplicationQueryConstants;
import com.spring.batches.writer.StudentsWriter;

@Configuration
@EnableBatchProcessing
@EnableTask
public class StudentLoader extends BatchJobLoader{

	@Autowired
	StudentsConfigurer studentConfigurer;
	
	@Autowired
	StudentsWriter studentWriter;

	private static final String JOB_NAME = "StudentJob";

	Logger logger = LoggerFactory.getLogger(StudentLoader.class);


	/**************************************************************************
	 * JDBC reader to read data from the HODS_FAC_COURSES_VW
	 * @return JdbcCursorItemReader object contains data read from the view.
	 **************************************************************************/
	@Bean
	public JdbcCursorItemReader<DomainObjects> studentReader()
	{
		studentConfigurer.setSqlQuery(ApplicationQueryConstants.SQL_STUDENT_READER, null);
		return setUpCursorItemReaderSecondaryDs(studentConfigurer, JOB_NAME);
	}

	/**************************************************************************
	 * First step of the job contains reader & writer with chunk limit of 100
	 * <li> allowStartIfComplete - false
	 * <li> startLimit - 2
	 * @return Step reference to binded with Job
	 **************************************************************************/
	@Bean
	public Step step01()
	{
		return stepBuilderFactory
				.get("S1-StudentLoad")
				.<DomainObjects, Students> chunk(100)
				.reader(studentReader())
				//.reader(reader()).faultTolerant().retryLimit(2).retry(Instance of throwable .class)
				.writer(studentWriter)
				//.writer(writer()).faultTolerant().retryLimit(2).retry(Instance of throwable .class)
				.listener(listener).allowStartIfComplete(false)
				.startLimit(2)
				.build();
	}

	/**************************************************************************
	 * Method that contains job definitions and bound with step definitions
	 * @return
	 **************************************************************************/
	@Bean
	public Job loadStudents()
	{
		return jobBuilderFactory
				.get(JOB_NAME)
				.incrementer(new SampleIncrementer())
				.start(step01())
				.listener(jobExecutionListener)
				.build();
	}
	
}