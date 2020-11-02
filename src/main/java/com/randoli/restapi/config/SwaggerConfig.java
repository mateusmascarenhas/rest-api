package com.randoli.restapi.config;

import com.randoli.restapi.controller.EventController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
        EventController.class
})
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.randoli.restapi"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfo(
                "API REST Randoli",
                "API REST for executing CRUD operations and data import from JSON file.",
                "1.0",
                "Terms of Service",
                new Contact("Mateus Mascarenhas", "https://www.linkedin.com/in/mateusmascarenhas/en",
                        "mateusmascarenhas3@gmail.com"), null,
                "null", new ArrayList<VendorExtension>()
        );
    }
}
