package com.biz.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // web.xml 과 비슷한 역할
public class SpBootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpBootHelloApplication.class, args);
	}

}
