package com.StudentErp.project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI openAPISwagger(){
        return new OpenAPI().info(
                new Info().title("Optimized Springboot Project")
                        .version("0.0.3")
                        .summary("this is springboot project with well optimized and Looger,OpenAi doc is used..")
        );
    }
}
