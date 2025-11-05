package com.healthcare.service;

import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResp;

public interface UserService {

	AuthResp signIn(AuthRequest reqDTO);

//	List<AppointmentDTO> getAllAppointmentsById(Long userId);

}
