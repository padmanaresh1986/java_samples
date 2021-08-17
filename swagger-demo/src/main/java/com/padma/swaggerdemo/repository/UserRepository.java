package com.padma.swaggerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padma.swaggerdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}

