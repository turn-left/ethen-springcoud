package com.ethen.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableEurekaClient	//启用服务发现
@EnableFeignClients //启用feign客户端
@SpringBootApplication(scanBasePackages = "com.ethen.consumer")
public class EthenSpringcloudConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EthenSpringcloudConsumerApplication.class, args);
	}

}
