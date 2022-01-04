package com.happyness.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ProjectRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ProjectHandler handler) {
        return RouterFunctions
                .route(GET("/project").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/project/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/project").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(GET("/child").and(accept(MediaType.APPLICATION_JSON)), handler::findAllChildren)
                .andRoute(GET("/child/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findChildById)
                .andRoute(POST("/child").and(accept(MediaType.APPLICATION_JSON)), handler::saveChild);
    }
}
