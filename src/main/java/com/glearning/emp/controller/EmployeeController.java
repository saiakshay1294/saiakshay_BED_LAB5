package com.glearning.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.glearning.emp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public String listemployees(Model model) {
		model.addAttribute("employees", this.employeeService.getAllEmployees());
		return "employees";
	}

}
