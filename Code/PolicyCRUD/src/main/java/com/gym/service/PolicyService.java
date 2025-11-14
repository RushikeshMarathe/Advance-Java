package com.gym.service;

import java.util.List;

import com.gym.dto.PolicyDto;
import com.gym.entity.Policy;

public interface PolicyService {

	Policy addPolicy(PolicyDto policydto);
	String findByCamountGreaterThan(int amt);
	List<Policy> getAll();

}
