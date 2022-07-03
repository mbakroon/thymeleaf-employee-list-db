package com.luv2code.springboot.thymeleafdemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	public static String updloadDirectory = System.getProperty("user.dir")+"/uploads";
	
	private EmployeeService employeeService;
	
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@ResponseBody
	@GetMapping("/test")
	public Employee getTest() {
		return new Employee("", null, null, null);
		
	}



	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		//add to the spring model
		theModel.addAttribute("employees",theEmployees);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	//th:href="@{/employees/showFormForUpdate(employeeId=${tempEmployee.id})}"
	public String shoFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		//get the employee from the service
		Employee theEmployee = employeeService.findByid(theId);
		
		//set employee as a model attribute to pre-populate the form 
		theModel.addAttribute("employee", theEmployee);
		
		//send over to our form
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@RequestParam("file") MultipartFile file,
			@ModelAttribute("employee") Employee theEmployee ) 
	{
		
		//save the employee
		employeeService.save(theEmployee, file);

		
		//use a direct to prevent dublicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		//delete the employee
		employeeService.deleteById(theId);
		
		//redirect to /employees/list
		return "redirect:/employees/list";
	}

	
	@PostMapping("/upload")
	public ResponseEntity<Void> upload(@RequestParam("files") MultipartFile [] files,
										Model theModel) {
		
		StringBuilder fileNames = new StringBuilder();
		for(MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(updloadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		theModel.addAttribute("msg","successfully upload files "+ fileNames.toString());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

}
