package com.padma.webflux.demo.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.padma.webflux.demo.route.handler.UserRouteHandler;

@Configuration
public class Routes {
	
	@Bean
	public RouterFunction<ServerResponse> userRoutes(UserRouteHandler userRouteHandler){
		return RouterFunctions
				.route(RequestPredicates.GET("/users"),userRouteHandler::getAllUsers)
				.andRoute(RequestPredicates.GET("/users/{id}"),userRouteHandler::getUser)
				.andRoute(RequestPredicates.POST("/users").and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
						.and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), userRouteHandler::saveUser);
	}

}
