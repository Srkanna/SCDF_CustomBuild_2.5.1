package com.spring.batches.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**************************************************************************
 * Class to load Database properties 
 * @author RSHANMUGAM2:Mar 19, 2020: 4:13:02 AM
 **************************************************************************/
@Configuration
public class DatabaseConfig {
	
	/**************************************************************************
	 * Provides a primary Datasource dependencies to write into FAC tables and 
	 * Batch Job tables.
	 * @return
	 **************************************************************************/
	@Bean(name = "facDatasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.fac")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/**************************************************************************
	 * Provides a secondary Datasource dependencies to read from HODS tables.
	 * @return
	 **************************************************************************/
	@ConfigurationProperties(prefix = "spring.datasource.hods")
    @Bean(name= "hodsDatasource")
    public DataSource sourceDataSource() {
        return DataSourceBuilder.create().build();
    }

}