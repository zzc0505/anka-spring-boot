package com.anka.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.anka.apps.mapper")
@ComponentScan(basePackages={"com.anka"})
public class AppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsApplication.class, args);
	}
}

