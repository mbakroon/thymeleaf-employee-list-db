package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//that's it ... no need to write any code LOL!


	//add a method to sort by last name
	//spring Data JPA will parse the method name
	//Looks for a specific format and pattern
	//Creates appropriate query ... behind the scenes
	//details www.luv2code.com/query-methods
	public List<Employee> findAllByOrderByLastNameAsc();
}
