package com.padma.swaggerdemo.model.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.padma.swaggerdemo.exception.UserNotFoundException;
import com.padma.swaggerdemo.model.Address;
import com.padma.swaggerdemo.model.User;
import com.padma.swaggerdemo.repository.AddressRepository;
import com.padma.swaggerdemo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> save(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		Optional<User> byId = userRepository.findById(id);
		return ResponseEntity.ok(byId.orElseThrow(() -> new UserNotFoundException("User Not Found with Id "+ id)));
	}
	
	
	@GetMapping("/users/{userId}/address")
	public ResponseEntity<List<Address>> getAllAddresses(@PathVariable Long userId){
		Optional<User> findById = userRepository.findById(userId);
		return ResponseEntity.ok(findById.get().getAddresses());
	}
	
	@PostMapping("/users/{userId}/address")
	public ResponseEntity<Object> save(@PathVariable Long userId, @RequestBody Address address) {
		User findById = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User Not Found with Id " + userId));
		address.setUser(findById);
		Address save = addressRepository.save(address);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/users/{userId}/address/{id}")
	public ResponseEntity<Address> getUser(@PathVariable Long userId,@PathVariable Long id){
		Optional<Address> byId = addressRepository.findById(id);
		return ResponseEntity.ok(byId.orElseThrow(() -> new UserNotFoundException("User Not Found with Id "+ id)));
	}


}
