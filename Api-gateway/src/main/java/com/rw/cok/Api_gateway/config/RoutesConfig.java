package com.rw.cok.Api_gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
    @Value("${userService.url}")
    private String userRoute;
    @Value("${taxService.url}")
    private String taxRoute;

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r
                        .path("/user/**")
                        .filters(f -> f.rewritePath("/user/(?<path>.*)", "/${path}"))
                        .uri(userRoute))
                .route("user-docs", r -> r
                        .path("/user/v3/api-docs")
                        .filters(f -> f
                                .removeRequestHeader("Origin")  // ADD THIS
                                .addResponseHeader("Access-Control-Allow-Origin", "*")  // ADD THIS
                        )
                        .uri(userRoute+"/v3/api-docs"))
                .route("tax-service", r -> r
                        .path("/tax/**")
                        .filters(f -> f.rewritePath("/tax/(?<path>.*)", "/${path}"))
                        .uri(taxRoute))
                .route("tax-docs", r -> r
                        .path("/tax/v3/api-docs")
                        .filters(f -> f
                                .removeRequestHeader("Origin")  // ADD THIS
                                .addResponseHeader("Access-Control-Allow-Origin", "*")  // ADD THIS
                        )
                        .uri(taxRoute+"/v3/api-docs"))

                .build();
    }
}
