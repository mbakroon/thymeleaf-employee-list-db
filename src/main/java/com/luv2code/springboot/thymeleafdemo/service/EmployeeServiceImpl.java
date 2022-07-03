package com.luv2code.springboot.thymeleafdemo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	// remove @Transactional since JpaRepository provides this functionality
	@Override
	public List<Employee> findAll() {
		// return employeeRepository.findAll();
		return employeeRepository.findAllByOrderByLastNameAsc();

	}

	@Override
	public Employee findByid(int theId) {

		// Optional Different pattern instead of having to check for nulls
		// Feature introduced in Java 8
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee, MultipartFile file) {

		/*
		 * String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		 * 
		 * if(fileName.contains("..")) { System.out.println("not a a valid file"); } try
		 * { theEmployee.setImg(Base64.getEncoder().encodeToString(file.getBytes())); }
		 * catch (IOException e) { e.printStackTrace(); }
		 */
		

		try {
			theEmployee.setImg(Base64.encodeBase64String(file.getBytes()));
			//theEmployee.setImg(file.getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
