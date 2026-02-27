package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

//swagger is used for testing purposes

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI().info(new Info().title("UC API").description("Crud Operations").version("1.0.0"));
	}
	
	
}
