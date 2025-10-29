package com.rahul;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

@RestController
public class MyController {
	
	private StudentService service;
	

	public MyController(StudentService service) {
		super();
		this.service = service;
	}
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getById(id);
	}
	@GetMapping("/students")
	public List<Student> getStudents(){
		return service.getAllStudent();
	}
	
	@PostMapping("/student")
	public void saveStudent(@RequestBody Student student) {
		service.saveS(student);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		service.delete(id);
	}
	
	
}
