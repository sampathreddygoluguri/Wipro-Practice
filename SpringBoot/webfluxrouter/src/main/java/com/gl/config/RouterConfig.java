package com.gl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gl.handler.PersonHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(PersonHandler personHandler) {
        return RouterFunctions
                .route(GET("/persons/{id}"), personHandler::getPerson)
                .andRoute(GET("/persons"), personHandler::getAllPersons)
                .andRoute(POST("/persons"), personHandler::createPerson)
                .andRoute(PUT("/persons/{id}"), personHandler::updatePerson)
                .andRoute(DELETE("/persons/{id}"), personHandler::deletePerson);
    }
}
