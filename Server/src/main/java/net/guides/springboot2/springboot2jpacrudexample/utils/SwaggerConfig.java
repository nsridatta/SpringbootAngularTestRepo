package net.guides.springboot2.springboot2jpacrudexample.utils;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                /*.paths(regex("/api/v1/employees/*"))*/
                .build()
                .apiInfo(apiInformation());
    }

    private ApiInfo apiInformation() {
        return new ApiInfo(
                "Employee Dashboard Portal",
                "Employees related APIs",
                "API V2",
                "Terms of service",
                new Contact("Sri Datta Nellutla", "https://github.com/nsridatta", "nsridatta@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
