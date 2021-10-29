package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SecondMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondMicroserviceApplication.class, args);
	}

	// @Bean allows spring container to maintain the object, 
	// so that it can be Autowired
	
	  @LoadBalanced
	  @Bean public RestTemplate rest(RestTemplateBuilder builder) { return
	  builder.build(); }
	 
}
