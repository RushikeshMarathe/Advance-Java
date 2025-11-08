package com.ems.service;

import java.util.List;

import com.ems.dto.DepartmentDTO;
import com.ems.entities.Department;

public interface DepartmentService {
	List<Department> getAllDepartments();

	DepartmentDTO getDepartmentAndEmps(Long deptId);
	Department getDepartmentAndEmps2(Long deptId);
}
