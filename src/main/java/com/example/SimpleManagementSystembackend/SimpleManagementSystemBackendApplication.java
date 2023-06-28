package com.example.SimpleManagementSystembackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.SimpleManagementSystembackend.*.mapper")
public class SimpleManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleManagementSystemBackendApplication.class, args);
	}

}
