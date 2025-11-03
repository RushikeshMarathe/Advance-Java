package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
	//depcy
	@Autowired
	private EmployeeService employeeService;
	/*
	 * Add req handling method - to render list of emps from dept
	 * URL - http://host:port/ctx_path/emps/list ,method=POST
	 * payload - departmentId =....
	 */
	@RequestMapping("/list")
	public String listEmpsByDepartment(Model modelAttrMap, 
			@RequestParam(required = false) Long departmentId)
	// @RequestParam - method arg annotation to bind incoming rq param -> rq handling method argument
	{
		System.out.println("in list emps "+modelAttrMap+" "+departmentId);//{}
		modelAttrMap.addAttribute("emp_list", employeeService.getEmpsByDeptId(departmentId));
		return "emps/list";//AVN - /WEB-INF/views/emps/list.jsp
		
		/*
		 * Handler rets explicitly -> LVN -> D.S.
		 * SC sends implicitly - model map
		 * D.S -> LVN -> V.R -> AVN -> D.S
		 * D.S checks for model attributes -> present -> adds it under request scope
		 * -> forwards the client to view layer
		 */
	}
	
	
	
	@GetMapping("/delete")
	public String deleteEmployeeById(Model modelAtrr, @RequestParam Long id,HttpSession session) {
		
		System.out.println("Inside deleteEmployee!...");
		
		session.setAttribute("message",employeeService.deleteEmployeeById(id));
		
		return "redirect:/emps/list";
	}

}
