package com.spring.batches.reader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public abstract class SQLQueryConfigurer<DomainObjects> implements PreparedStatementSetter, RowMapper<DomainObjects> {

	private String sqlStatement;
	//private DataSource dataSource;

	@Override
	public abstract DomainObjects mapRow(ResultSet rs, int rowNum) throws SQLException;

	@Override
	public abstract void setValues(PreparedStatement ps) throws SQLException;

	/**************************************************************************
	 * Method to return PreparedStatementSetter instance wherever needed. For
	 * example this method can be used to inject PreparedStatementSetter dependancy
	 * into JDBCCursorItemReader class.
	 * 
	 * @return {@link RowMapper}
	 **************************************************************************/
	public RowMapper<DomainObjects> getRowMapper() {
		return this;
	}

	/**************************************************************************
	 * Method to return PreparedStatementSetter instance wherever needed. For
	 * example this method can be used to inject PreparedStatementSetter dependancy
	 * into JDBCCursorItemReader class.
	 * 
	 * @return {@link PreparedStatementSetter}
	 **************************************************************************/
	public PreparedStatementSetter getPreparedStatementSetter() {
		return this;
	}

	/**************************************************************************
	 * Method to handle the Reader SQL statements to be executed. This method can be
	 * overriden to provide custom implementation.
	 * @param sqlStatement the actual sql reader query to be executed
	 * @param courseRoom   The courseroom where the query should be executed
	 **************************************************************************/
	public void setSqlQuery(StringBuilder sqlStatement, String courseRoom) {
		this.sqlStatement = sqlStatement.toString();
	}

	/**************************************************************************
	 * Method to return the SqlQuery to the JdbcCursorItemReader class.
	 * @return String Sql query with replaced CRSE_ROOM_NAME value.
	 **************************************************************************/
	public String getSqlQuery() {
		return sqlStatement;
	}
}