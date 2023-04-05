package com.gl.empmgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.empmgmt.dao.EmployeeDao;
import com.gl.empmgmt.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao empDao;
	
	
	
	

	public EmployeeServiceImpl(EmployeeDao empDao) {
		super();
		this.empDao = empDao;
	}

	
	public List<Employee> getAllEmployees() {
		
		return empDao.findAll();
	}

	
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return empDao.findById(id).get();
	}

	
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.save(employee);
	}

	
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.save(employee);
	}

	
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		empDao.deleteById(id);

	}

}
