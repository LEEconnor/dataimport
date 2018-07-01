package com.test.dataimport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan("com.test.dataimport.dao")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DataimportApplication {






	public static void main(String[] args) {
		SpringApplication.run(DataimportApplication.class, args);
	}
}
