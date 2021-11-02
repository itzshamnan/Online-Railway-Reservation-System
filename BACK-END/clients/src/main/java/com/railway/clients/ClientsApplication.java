package com.railway.clients;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class ClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
	}
	
	@Bean
	public  Docket swaggerConfiguration()  {
            return new Docket(DocumentationType.SWAGGER_2)  
                .select() 
                .apis(RequestHandlerSelectors.basePackage("com.railway.clients.controller"))
                .paths(PathSelectors.any())                          
                .build()
                .apiInfo(apiDetails());
	}
    private ApiInfo apiDetails() {
	        return  new ApiInfo("Clients Api",
			"Api Collections",
			null,
			null,
			new springfox.documentation.service.Contact("Shamnan", "shamnan@gmail.com", null),
			"Master","Swagger",Collections.emptyList());

}

}
