package com.healthcare.service;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.DoctorRegDTO;

public interface DoctorService {
//method to sign up
	ApiResponse registerNewDoctor(DoctorRegDTO reqDTO);
}
