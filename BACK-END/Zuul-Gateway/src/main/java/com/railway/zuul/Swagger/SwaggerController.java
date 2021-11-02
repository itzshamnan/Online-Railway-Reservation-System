package com.railway.zuul.Swagger;
import java.util.ArrayList;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;


@Component
@Primary
@EnableAutoConfiguration
public class SwaggerController implements SwaggerResourcesProvider{
	
	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		
		resources.add(swaggerResource("Mainadmin-Service","/MAINADMIN-SERVICE/v2/api-docs","2.0"));
		
		resources.add(swaggerResource("Passenger-service", "/PASSENGER-SERVICE/v2/api-docs", "2.0"));
		
		resources.add(swaggerResource("Payment-Service", "/PAYMENT-SERVICE/v2/api-docs", "2.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
