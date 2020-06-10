package com.spring.batches.jobs;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.batches.domain.DomainObjects;
import com.spring.batches.listener.CuJobExecutionListener;
import com.spring.batches.listener.RowCountStepListener;
import com.spring.batches.reader.SQLQueryConfigurer;
import com.spring.batches.reader.SqlCursorItemReader;

public class BatchJobLoader {

	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	RowCountStepListener listener;

	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	CuJobExecutionListener jobExecutionListener;

	@Autowired
	@Qualifier("secondaryDatasource")
	DataSource secondaryDatasource;

	@Autowired
	@Qualifier("primaryDatasource")
	DataSource primaryDatasource;

	public SqlCursorItemReader<DomainObjects> setUpCursorItemReaderSecondaryDs(SQLQueryConfigurer<DomainObjects> queryConfigurer, String jobName)
	{
		SqlCursorItemReader<DomainObjects> cursorItemReader = new SqlCursorItemReader<DomainObjects>();
		cursorItemReader.setQueryConfigurer(queryConfigurer);
		cursorItemReader.setDataSource(secondaryDatasource);
		cursorItemReader.setPreparedStatementSetter(queryConfigurer.getPreparedStatementSetter());
		cursorItemReader.setRowMapper(queryConfigurer.getRowMapper());
		return cursorItemReader;
	}
	
	public SqlCursorItemReader<DomainObjects> setUpCursorItemReaderPrimaryDs(SQLQueryConfigurer<DomainObjects> queryConfigurer, String jobName)
	{
		SqlCursorItemReader<DomainObjects> cursorItemReader = new SqlCursorItemReader<DomainObjects>();
		cursorItemReader.setQueryConfigurer(queryConfigurer);
		cursorItemReader.setDataSource(primaryDatasource);
		cursorItemReader.setPreparedStatementSetter(queryConfigurer.getPreparedStatementSetter());
		cursorItemReader.setRowMapper(queryConfigurer.getRowMapper());
		return cursorItemReader;
	}
}