package com.ecars.microcars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class MicrocarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocarsApplication.class, args);
	}

}
