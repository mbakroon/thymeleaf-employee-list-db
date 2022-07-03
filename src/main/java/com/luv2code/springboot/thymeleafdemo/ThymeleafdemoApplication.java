package com.luv2code.springboot.thymeleafdemo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luv2code.springboot.thymeleafdemo.controller.EmployeeController;

@SpringBootApplication
//@ComponentScan({"com.luv2code.springboot.thymeleafdemo", "com.luv2code.springboot.thymeleafdemo.controller"})
public class ThymeleafdemoApplication {

	public static void main(String[] args) {
		
		//Create file to upload the file in Local Desk with Program start
		new File(EmployeeController.updloadDirectory).mkdir();
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

}
