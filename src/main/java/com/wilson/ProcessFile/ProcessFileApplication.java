package com.wilson.ProcessFile;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.*;

@EnableScheduling
@SpringBootApplication
public class ProcessFileApplication {

	public static void main(String[] args) {
		run(ProcessFileApplication.class, args);
	}

}
