package com.lnterceptor.pattern.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.lnterceptor.pattern.example.controller")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Interceptor Design Pattern API Documentation").description("Interceptor Design Pattern API reference for developers")
				.termsOfServiceUrl("http://localhost:9999/home").contact(new Contact("Interceptor Design Pattern Demonstration", "http://localhost:9999/home", "samarthnarula13@gmail.com"))
				.license("MIT License").licenseUrl("samarthnarula13@gmail.com").version("1.0").build();

	}
}
