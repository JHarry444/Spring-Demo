package com.qa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext beanBag = SpringApplication.run(SpringDemoApplication.class, args);
		boolean found = beanBag.containsBean("demoComponent");
		System.out.println(found); // wrong package
	}

}
