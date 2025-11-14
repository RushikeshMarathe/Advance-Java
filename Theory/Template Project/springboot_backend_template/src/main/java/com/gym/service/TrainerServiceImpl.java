package com.gym.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gym.dto.TrainerDTO;
import com.gym.entities.Trainer;
import com.gym.repositories.TrainerRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {
	
	private TrainerRepository trainerRepository;
	private ModelMapper modelMapper;
	
	@Override
	public String createNewTrainer(TrainerDTO trainerToAdd) {
		
		Trainer trainer = modelMapper.map(trainerToAdd, Trainer.class);
		
		trainerRepository.save(trainer);
		
		return "Trainer successfully created!...";
	}

}
