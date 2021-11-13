package com.benz.zuul.edge.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulEdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulEdgeServiceApplication.class, args);
	}

}
