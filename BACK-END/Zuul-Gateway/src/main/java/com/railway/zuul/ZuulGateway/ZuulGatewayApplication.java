package com.railway.zuul.ZuulGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableSwagger2
@RestController
public class ZuulGatewayApplication {
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
		System.out.println("Running");
	}

}
