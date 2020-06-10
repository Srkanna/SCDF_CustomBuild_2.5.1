/**************************************************************************
 * RowCountStepListener.java class for
 **************************************************************************/
package com.spring.batches.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

/**************************************************************************
 * Class for
 * @author RSHANMUGAM2:Mar 18, 2020: 7:47:18 PM
 **************************************************************************/
@Component
public class RowCountStepListener implements StepExecutionListener{

	Logger logger = LoggerFactory.getLogger(RowCountStepListener.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		int readCount = stepExecution.getReadCount();
		int writeCount = stepExecution.getWriteCount();
		int commitCount = stepExecution.getCommitCount();
		int rollBackcount = stepExecution.getRollbackCount();
		int skipCount = stepExecution.getSkipCount();

		logger.info("Row Processing Counts");
		logger.info("Total Read Count :{}", readCount);
		logger.info("Total write Count :{}", writeCount);
		logger.info("Total commit Count :{}", commitCount);
		logger.info("Total Rollback Count :{}", rollBackcount);
		logger.info("Total Skip Count :{}", skipCount);

		return stepExecution.getExitStatus();
	}

}
