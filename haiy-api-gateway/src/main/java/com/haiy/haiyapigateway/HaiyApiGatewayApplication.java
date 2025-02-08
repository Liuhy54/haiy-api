package com.haiy.haiyapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HaiyApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaiyApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("to360", r -> r.path("/360")
                        .uri("https://www.360.cn/"))
                .route("tohaiy", r -> r.path("/name/")
                        .uri("http://localhost:8123/api/"))
                .build();
    }
}
