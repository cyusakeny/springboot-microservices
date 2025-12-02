package com.rw.cok.tax_period_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Value("${openapi.service.url}")
    private String url;
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .servers(List.of(new Server().url(url)))
                .info(new Info()
                        .title("Tax Period API")
                        .version("1.0.0")
                        .description("APIs for managing tax periods"));
    }
}
