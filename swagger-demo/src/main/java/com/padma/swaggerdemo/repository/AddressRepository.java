package com.padma.swaggerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.padma.swaggerdemo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {}
