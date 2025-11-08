package com.ems.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = "employees")
public class Department extends BaseEntity {
	@Column(name = "dept_name", length = 40, unique = true)
	private String deptName;
	@Column(length = 30)
	private String location;	
	//Department 1--->* Employee
	@OneToMany(mappedBy = "myDepartment",cascade =CascadeType.ALL,
			orphanRemoval = true)
	private List<Employee> employees=new ArrayList<>();
	

	public Department(String deptName, String location) {
		super();
		this.deptName = deptName;
		this.location = location;
	}

}
