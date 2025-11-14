package com.gym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.entities.Trainer;
import java.util.List;


public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
