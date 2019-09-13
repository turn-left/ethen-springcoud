package com.ethen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EthenSpringcloudKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EthenSpringcloudKafkaProducerApplication.class, args);
	}

}
