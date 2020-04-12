package com.vmware.math.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.vmware.math.operation")
@SpringBootApplication
public class SpringMathOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMathOperationApplication.class, args);
	}
}
