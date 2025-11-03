package com.ems.controller;
import com.ems.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.ems.service.DepartmentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/department")
public class DepartmentController {

	
	@Autowired 
	private DepartmentService departmentService;
	
	public DepartmentController() {
		System.out.println("inside ctor of "+getClass());
	}
	// http://host:port/ctx_path/department/list 

	@GetMapping("/list")
	public ModelAndView getDepartmentList() {
		System.out.println("in list all depts");
		return new ModelAndView("dept/list", "department_list", departmentService.getAllDepartments());
	}

}
