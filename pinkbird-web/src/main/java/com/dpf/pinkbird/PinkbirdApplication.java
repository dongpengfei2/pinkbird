package com.dpf.pinkbird;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dpf.pinkbird.mapper")
public class PinkbirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinkbirdApplication.class, args);
	}

}
