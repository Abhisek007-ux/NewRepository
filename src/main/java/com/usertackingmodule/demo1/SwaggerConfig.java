package com.usertackingmodule.demo1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket swaggerPersonApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("SCA-v1")
            .select()
                .apis(RequestHandlerSelectors.basePackage("com.usertackingmodule.demo1"))
                .paths(PathSelectors.any())
            .build()
            .apiInfo(new ApiInfoBuilder().version("v1").title("simplecrudApplication")
            		.description("simplecrudApplication").build());
    }
}