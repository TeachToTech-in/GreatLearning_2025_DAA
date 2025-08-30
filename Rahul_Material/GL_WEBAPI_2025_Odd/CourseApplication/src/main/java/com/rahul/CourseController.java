package com.rahul;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CourseController {

	private CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/courses")
	public List<Course> courses(){
		return service.getAllCourses();
	}
	//Path Variable 
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable int id) {
		return service.getCourseById(id);
	}
	
	@PostMapping("/courses")
	public void store(@RequestBody Course course) {
		service.saveCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable int id) {
		service.removeById(id);
	}
	

	



}
