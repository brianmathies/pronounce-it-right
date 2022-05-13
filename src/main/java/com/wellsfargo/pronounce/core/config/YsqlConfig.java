package com.wellsfargo.pronounce.core.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.TransactionManager;

import com.wellsfargo.pronounce.core.data.dao.EmployeeInfoRepo;
import com.yugabyte.data.jdbc.datasource.YugabyteTransactionManager;
import com.yugabyte.data.jdbc.repository.config.AbstractYugabyteJdbcConfiguration;
import com.yugabyte.data.jdbc.repository.config.EnableYsqlRepositories;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableYsqlRepositories(basePackageClasses = EmployeeInfoRepo.class)
public class YsqlConfig extends AbstractYugabyteJdbcConfiguration {

	@Bean
	DataSource dataSource() {
		
		String hostName = "20.121.116.250";
		String port = "5433";

		Properties poolProperties = new Properties();
		poolProperties.setProperty("dataSourceClassName", "com.yugabyte.ysql.YBClusterAwareDataSource");
	    poolProperties.setProperty("dataSource.serverName", hostName);
	    poolProperties.setProperty("dataSource.portNumber", port);
	    poolProperties.setProperty("dataSource.user", "yugabyte");
	    poolProperties.setProperty("dataSource.password", "Hackathon22!");

	    HikariConfig hikariConfig = new HikariConfig(poolProperties);
      	DataSource ybClusterAwareDataSource = new HikariDataSource(hikariConfig);
      	return ybClusterAwareDataSource;
	}

	@Bean
	JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) { 
        return new NamedParameterJdbcTemplate(dataSource);
    }
    
    @Bean
    TransactionManager transactionManager(DataSource dataSource) {                     
        return new YugabyteTransactionManager(dataSource);
    }

}