package com.rahul;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private CourseRepository repository;

	public DemoController(CourseRepository repository) {
		super();
		this.repository = repository;

	}

	@RequestMapping("/courses/{id}")
	public Course getCourse(@PathVariable int id) {

		return repository.findById(id).get();

	}

	@RequestMapping("/courses")
	public List<Course> getAllCourses() {

		return repository.findAll();

	}

}
