package com.voter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
@EnableEurekaClient
public class VotingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingManagementApplication.class, args);
	}
	
	@Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();


    }
	

}
