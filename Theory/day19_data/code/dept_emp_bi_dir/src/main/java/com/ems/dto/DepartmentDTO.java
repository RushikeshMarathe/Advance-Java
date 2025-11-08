package com.ems.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DepartmentDTO {
	private String deptName;
	private String location;
	private List<EmployeeDTO> employees = new ArrayList<>();
}
