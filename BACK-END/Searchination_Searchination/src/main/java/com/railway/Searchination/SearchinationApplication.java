package com.railway.Searchination;

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
public class SearchinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchinationApplication.class, args);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Bean
	public  Docket swaggerConfiguration()  {
            return new Docket(DocumentationType.SWAGGER_2)  
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.railway.Searchination.Controller"))
                .paths(PathSelectors.any())                          
                .build()
                .apiInfo(apiDetails());
	}
    private ApiInfo apiDetails() {
	        return  new ApiInfo("Search Api",
			"Api Collections",
			null,
			null,
			new springfox.documentation.service.Contact(null, null, null),
			null,null,Collections.emptyList());
			
}

}
