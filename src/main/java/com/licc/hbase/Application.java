package com.licc.hbase;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootConfiguration
@ComponentScan("com.licc.hbase")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
