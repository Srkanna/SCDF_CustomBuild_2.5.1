package com.spring.batches.reader;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.database.JdbcCursorItemReader;

public class SqlCursorItemReader<DomainObjects> extends JdbcCursorItemReader<DomainObjects> {

	Logger logger = LoggerFactory.getLogger(SqlCursorItemReader.class);
	
	SQLQueryConfigurer<DomainObjects> queryConfigurer;

	@Override
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		logger.info(" In After Properties set");
		super.setSql(queryConfigurer.getSqlQuery());
		super.setRowMapper(queryConfigurer.getRowMapper());
		super.setPreparedStatementSetter(queryConfigurer.getPreparedStatementSetter());
		super.setDataSource(getDataSource());
		super.afterPropertiesSet();
	}

	/**************************************************************************
	 *@return the queryConfigurer
	 **************************************************************************/
	public SQLQueryConfigurer<DomainObjects> getQueryConfigurer() {
		return queryConfigurer;
	}

	/**************************************************************************
	 *@param queryConfigurer the queryConfigurer to set
	 **************************************************************************/
	public void setQueryConfigurer(SQLQueryConfigurer<DomainObjects> queryConfigurer) {
		logger.info(" In setQueryConfigurer method");
		this.queryConfigurer = queryConfigurer;
	}
}