package com.amberved.springmvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amberved.springmvc.dao.StudentDAO;
import com.amberved.springmvc.model.Student;

@RestController
public class StudentRestController {

	
	@Autowired
	private StudentDAO studentDAO;

	
	@GetMapping("/students")
	public List getstudents() {
	    	System.out.println("studentRestController::getstudents");

		return studentDAO.list();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity getstudent(@PathVariable("id") Long id) {
	    	System.out.println("studentRestController::getstudent");

		Student student = studentDAO.get(id);
		if (student == null) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(student, HttpStatus.OK);
	}

	@PostMapping(value = "/students")
	public ResponseEntity createstudent(@RequestBody Student student) {

		studentDAO.create(student);

		return new ResponseEntity(student, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity deletestudent(@PathVariable Long id) {

		if (null == studentDAO.delete(id)) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/students/{id}")
	public ResponseEntity updatestudent(@PathVariable Long id, @RequestBody Student student) {

		student = studentDAO.update(id, student);

		if (null == student) {
			return new ResponseEntity("No student found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(student, HttpStatus.OK);
	}

}