package com.padma.webflux.demo.route.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;

import com.padma.webflux.demo.model.User;
import com.padma.webflux.demo.route.handler.manager.UserManager;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserRouteHandler {
	
	private UserManager userManager;
	
	public UserRouteHandler(UserManager userManager) {
		super();
		this.userManager = userManager;
	}

	public Mono<ServerResponse> getAllUsers(ServerRequest request) {
		Flux<User> users = userManager.getAllUsers();
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(users, User.class)).switchIfEmpty(ServerResponse.notFound().build());
	}
	
	public Mono<ServerResponse> getUser(ServerRequest request) {
		Long userId = Long.valueOf(request.pathVariable("id"));
		Mono<User> user = userManager.findById(userId);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(user, User.class)).switchIfEmpty(ServerResponse.notFound().build());
	}
	
	public Mono<ServerResponse> saveUser(ServerRequest request) {
		Mono<User> inputUserMono = request.bodyToMono(User.class);
		return inputUserMono.flatMap(userManager::saveUser).flatMap(savedUser -> ServerResponse.created(
				UriComponentsBuilder.fromPath(request.path() + "/{id}").buildAndExpand(savedUser.getId()).toUri())
				.build());
				
	}

}
