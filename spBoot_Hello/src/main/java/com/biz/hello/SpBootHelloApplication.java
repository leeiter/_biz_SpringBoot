package com.biz.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 내장형 Tomcat

/*
 * 현재 이 클래스는 제일 상위 package에 위치해 있어야 한다.
 * 그래야 하위 package에 있는 읽고 실행이 가능하다.
 */
@SpringBootApplication // web.xml 과 비슷한 역할
public class SpBootHelloApplication {

	// 다시 자기자신을 주입
	public static void main(String[] args) {
		SpringApplication.run(SpBootHelloApplication.class, args);
	}

}
