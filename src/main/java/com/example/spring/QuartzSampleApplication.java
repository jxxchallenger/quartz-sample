package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Import;

//import com.example.spring.quartz.config.QuartzConfig;

@SpringBootApplication
//@Import(value = { QuartzConfig.class })
public class QuartzSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzSampleApplication.class, args);
	}

}
