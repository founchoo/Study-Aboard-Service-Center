package com.wt6.sasc;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("com.wt6.sasc")
@MapperScan("com.wt6.sasc.mapper")
public class SascApplication {

	public static void main(String[] args) {
		SpringApplication.run(SascApplication.class, args);
	}

	@Bean(destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
}
