package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee>findAll();
	
	public Employee findByid(int theId);
	
	public void save(Employee theEmployee , MultipartFile file);

	public void deleteById( int theId);

}
