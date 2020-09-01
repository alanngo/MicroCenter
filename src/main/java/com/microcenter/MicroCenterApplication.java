package com.microcenter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MicroCenterApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(MicroCenterApplication.class, args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
