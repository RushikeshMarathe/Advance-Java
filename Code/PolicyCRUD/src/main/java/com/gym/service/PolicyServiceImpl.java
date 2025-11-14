package com.gym.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gym.dao.PolicyDao;
import com.gym.dto.PolicyDto;
import com.gym.entity.Policy;
import com.gym.exception.CustomException;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PolicyServiceImpl implements PolicyService {
	private final ModelMapper modelMapper;
	private final PolicyDao policyDao;
	
	@Override
	public Policy addPolicy(PolicyDto policydto) {
		Policy policy = modelMapper.map(policydto, Policy.class);
		if(!policyDao.existsByName(policydto.getName())) {
			
			if(!policy.getStartdate().isBefore(policy.getEnddate())) {
				throw new CustomException("s-date is greater!s");
			}
			
			return policyDao.save(policy);
		}else {
			throw new CustomException("Duplicate Entry!");
		}
	}

	@Override
	public String findByCamountGreaterThan(int amt) {
		List<Policy> policies = policyDao.findByCamountGreaterThan(amt);
		if(policies.size()>0) {
			policies.stream().forEach(p->p.setCamount(p.getCamount()*1.15));
			return "Updated";
		}else {
			throw new CustomException("No Record! - findByCamountGreaterThan!");
		}
	}

	@Override
	public List<Policy> getAll() {
		List<Policy> policies = policyDao.findAll();
		if(policies.size()>0) {
			return policies;
		}else {
			throw new CustomException("No Record! - findByCamountGreaterThan!");
		}
	}
	
}
