package com.spring.batches;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.ConfigurableApplicationContext;

/**************************************************************************
 * Main Class to kick Start the Spring batch jobs with Spring Scheduler.
 * 
 * @author RSHANMUGAM2:Apr 17, 2020: 12:28:39 PM
 **************************************************************************/
@EnableBatchProcessing
@SpringBootApplication
//@EnableScheduling
@EnableTask
public class DataExtractorApplication {

	Logger logger = LoggerFactory.getLogger(DataExtractorApplication.class);

	@Autowired
	JobLauncher jobLauncher;

	public static void main(String[] args) {
		//SpringApplication.run(SeiCuFacExtractorApplication.class, args);
		exitApplication(args);
	}

	private static void exitApplication(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(DataExtractorApplication.class, args);

		int exitCode = SpringApplication.exit(ctx, () -> {
			return 0;
		});

		System.out.println("Exit Spring Boot");

		System.exit(exitCode);
	}
}