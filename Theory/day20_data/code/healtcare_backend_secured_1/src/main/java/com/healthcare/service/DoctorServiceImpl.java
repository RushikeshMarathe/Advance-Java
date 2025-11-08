package com.healthcare.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceAlreadyExists;
import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.DoctorRegDTO;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.UserRole;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
	private final DoctorRepository patientRepository;
	private final UserRepository userRepository;
	private final ModelMapper mapper;
	private final PasswordEncoder encoder;

	@Override
	public ApiResponse registerNewDoctor(DoctorRegDTO reqDTO) {
		// 1. validate for dup email
		if(userRepository.existsByEmail(reqDTO.getUserDetails().getEmail()))
			throw new ResourceAlreadyExists("Email alread Exists !!!!!");
		// 2. in case of no dup -> dto -> entity (deep copy)
		Doctor entity = mapper.map(reqDTO, Doctor.class);
		//3 assign doctor role
		entity.getUserDetails().setRole(UserRole.ROLE_DOCTOR);
		//3. encode pwd
		entity.getUserDetails().setPassword(encoder.encode(entity.getUserDetails().getPassword()));
		//4. save doctor entity (highlight - JPA cascade)
		Doctor persistentEntity=patientRepository.save(entity);	
		//5. ret api resp dto
		return new ApiResponse("New Doctor registered with ID="+persistentEntity.getId(), "Success");
	}

}
