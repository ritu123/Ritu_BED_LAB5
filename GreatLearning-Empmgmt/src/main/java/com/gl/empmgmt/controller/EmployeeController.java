package com.gl.empmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.empmgmt.model.Employee;
import com.gl.empmgmt.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	EmployeeService empService;
	
	
	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}


	@GetMapping("/list")
	public String showEmpList(Model model) {
		
		
		
		model.addAttribute("emps", empService.getAllEmployees());
		
		return "employees-list";
		

	}
	
	@GetMapping("/create-emp")
	public String createEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee";
	}

	@PostMapping("/saveEmp")
	public String saveEmp(Model model, @ModelAttribute("employee") Employee employee) {
		empService.saveEmployee(employee);
		return "redirect:/employees/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(Model model, @PathVariable int id) {
		empService.deleteEmployee(id);
		return "redirect:/employees/list";
	}

	@GetMapping("/update/{id}")
	public String updateEmp(Model model, @PathVariable int id) {
		Employee employee = empService.getEmployee(id);
		model.addAttribute("employee", employee);
		
		employee.setId(id);
		employee.setFirstName(employee.getFirstName());
		employee.setLastName(employee.getLastName());
		employee.setEmail(employee.getEmail());
		
		
		empService.updateEmployee(employee);
		return "employee";
	}


}
