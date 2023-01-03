package com.example.student.config;


import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private String version;
    private String title;
    private String description;
    private String basePackage;
    private String contactName;
    private String contactEmail;

    public SwaggerConfig() {
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.student.controller"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot APIs")
                .description("Spring Boot APIs description")
                .version("3.0.0")
                .contact(new Contact("supportability", null, "apisupportgroup@abc.com"))
                .build();
    }
}


/**
 * ...
 * ...
 * Getters
 * Setters
 * ...
 * ...
 **//*

   }*/

