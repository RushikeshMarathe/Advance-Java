package com.ems.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.custom_exceptions.ResourceNotFoundException;
import com.ems.dao.DepartmentDao;
import com.ems.dto.DepartmentDTO;
import com.ems.entities.Department;

import lombok.AllArgsConstructor;

@Service //mandatory class level annotation to declare a spring bean containing B.L
@Transactional //mandatory annotation fot auto tx management
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	//dependency - dao layer i/f	
	private final DepartmentDao departmentDao;
	private ModelMapper modelMapper;
	
//TO DO - modify below method to replace List<Entity> -> List<DTO> later
	@Override
	public List<Department> getAllDepartments() {
		//invoke dao's method
		return departmentDao.findAll();
	}

	@Override
	public DepartmentDTO getDepartmentAndEmps(Long deptId) {
		//get dept details by id
		Department departmentEntity=departmentDao.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Invalid dept id !!!!!!!!!!"));
		//map entity -> DTO & return it to the caller
		
		return modelMapper.map(departmentEntity, DepartmentDTO.class);
	}
	
	@Override
	public Department getDepartmentAndEmps2(Long deptId) {
		//get dept details by id
		Department departmentEntity=departmentDao.findById(deptId).orElseThrow(() -> new ResourceNotFoundException("Invalid dept id !!!!!!!!!!"));
		
		
		return departmentEntity;
	}
	

}
