package com.spring.batches.writer;

import java.util.List;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spring.batches.domain.Students;
import com.spring.batches.repository.StudentsRepository;

/**************************************************************************
 * Class for
 * @author RSHANMUGAM2:Apr 3, 2020: 12:31:51 PM
 **************************************************************************/
@Component
public class StudentsWriter implements ItemWriter<Students>{

	@Autowired
	DataSource dataSource;

	@Autowired
	StudentsRepository studentRepository;

	Logger logger = LoggerFactory.getLogger(StudentsWriter.class);
 
	private String writeSQL= "INSERT INTO student_load(ROW_CREATOR,ROW_CREATED_TIME,ROW_MODIFIER,ROW_MODIFIED_TIME)" + 
			" VALUES(?,?,?,?,?,?)";

	/**************************************************************************
	 *@return the writesql
	 **************************************************************************/
	public String getWritesql() {
		return writeSQL;
	}

	@Override
	public void write(List<? extends Students> items) throws Exception {
		studentRepository.saveAll(items);
	}

}