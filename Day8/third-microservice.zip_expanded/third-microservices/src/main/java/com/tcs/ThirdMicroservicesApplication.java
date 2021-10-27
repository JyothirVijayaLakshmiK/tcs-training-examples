package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ThirdMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdMicroservicesApplication.class, args);
	}
	
	 @LoadBalanced
	 @Bean public RestTemplate rest(RestTemplateBuilder builder) { 
		 return builder.build(); 
	 }
	 
}
