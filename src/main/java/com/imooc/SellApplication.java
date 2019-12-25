package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.imooc.*"})
public class SellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
	}
}