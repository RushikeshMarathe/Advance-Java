package com.ems.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	public TestController() {
		super();
		System.out.println("constructor"+getClass());
	}
	
	@GetMapping("/")
	public ModelAndView getData() {
		System.out.println("in test model n view");
		LocalDateTime today = LocalDateTime.now();
		return new ModelAndView("index", "today_date", today);
		//AVN - /WEB-INF/views/index.jsp
	}
	
	

}
