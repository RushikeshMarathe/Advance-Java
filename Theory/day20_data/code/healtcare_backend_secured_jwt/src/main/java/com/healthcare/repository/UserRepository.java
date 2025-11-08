package com.healthcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
//derived query - findBy
	Optional<UserEntity>  findByEmailAndPassword(String em, String pass);
	//check for dup email
	boolean existsByEmail(String email);
	//find by email
	Optional<UserEntity>  findByEmail(String email);
}
