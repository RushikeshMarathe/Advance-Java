//package com.ems.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.ems.service.EmployeeService;
//
//@Controller
//@RequestMapping("/emps")
//public class EmployeeController {
//	//depcy
//	@Autowired
//	private EmployeeService employeeService;
//	/*
//	 * Add req handling method - to render list of emps from dept
//	 * URL - http://host:port/ctx_path/emps/list ,method=POST
//	 * payload - departmentId =....
//	 */
//	@PostMapping("/list")
//	public String listEmpsByDepartment(Model modelAttrMap, 
//			@RequestParam Long departmentId)
//	{
//		System.out.println("in list emps "+modelAttrMap+" "+departmentId);//{}
//		modelAttrMap.addAttribute("emp_list", employeeService.getEmpsByDeptId(null));
//		return "emps/list";//AVN - /WEB-INF/views/emps/list.jsp
//	}
//
//}
