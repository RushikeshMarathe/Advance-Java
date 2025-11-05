package com.healthcare.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
//derived query - findBy
	Optional<User>  findByEmailAndPassword(String em, String pass);


	
}
