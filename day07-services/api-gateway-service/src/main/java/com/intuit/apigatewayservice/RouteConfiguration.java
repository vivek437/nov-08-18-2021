package com.intuit.apigatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    //http://localhost:8081/square/{num}  -> Original Mapping
    //http://localhost:7000/math/sq/{num} -> Gateway Mapping

    @Bean
    public RouteLocator configureRoutes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("route-square-service",
                        route ->
                            route
                                    .path("/math/sq/**")
                                    .filters(f -> f.stripPrefix(2).prefixPath("/square"))
                                    .uri("lb://square-service"))
                                    //.uri("http://localhost:8081"))
                .build();
    }
}
