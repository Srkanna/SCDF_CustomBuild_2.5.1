package com.spring.batches.reader;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.batches.domain.DomainObjects;
import com.spring.batches.domain.Students;

/**************************************************************************
 * Reader class to be invoked to read the records for BBSession table 
 * population.
 * @author RSHANMUGAM2:Apr 3, 2020: 12:04:36 PM
 **************************************************************************/
@Component
public class StudentsConfigurer extends SQLQueryConfigurer<DomainObjects>
{
	Logger logger = LoggerFactory.getLogger(StudentsConfigurer.class);
	
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
		Students student = new Students();

		student.setStartDt(rs.getDate("SESS_BEGIN_DT"));
		student.setRowCreator("FAC_BATCH");
		student.setRowCreatedTime(new Date(System.currentTimeMillis()));
		student.setRowModifier("FAC_BATCH");
		student.setRowModifiedTime(new Date(System.currentTimeMillis()));
		return student;
	}
	
}