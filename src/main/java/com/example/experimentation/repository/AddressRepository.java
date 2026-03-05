package com.example.experimentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.experimentation.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
