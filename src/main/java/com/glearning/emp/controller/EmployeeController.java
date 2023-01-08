package com.glearning.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.glearning.emp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public String listemployees(Model model) {
		//hash map. key will be "employees" and value will be a list of all the employees
		model.addAttribute("employees", this.employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editemployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteemployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
