package com.padma.webflux.demo.route.handler.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padma.webflux.demo.model.User;
import com.padma.webflux.demo.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserManager {
	
	private UserRepository userRepository;

	
	public UserManager(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	public Flux<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return Flux.fromIterable(allUsers);
	}
	
	public Mono<User> saveUser(User user) {
		User savedUser = userRepository.save(user);
		return Mono.just(savedUser);
	}


	public Mono<User> findById(Long userId) {
		Optional<User> findById = userRepository.findById(userId);
		if(findById.isEmpty()) {
			return Mono.empty();
		}
		return Mono.just(findById.get());
	}


	

}
