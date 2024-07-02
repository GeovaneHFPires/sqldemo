package com.sqlpractice.sqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sqlpractice.*")
@EntityScan(basePackages = "com.sqlpractice.*")
public class SqldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqldemoApplication.class, args);
	}

}
