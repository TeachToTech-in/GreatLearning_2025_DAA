package com.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseConfig config;
	
	@GetMapping("/course")
	public Course getCourse() {
		return new Course(config.getId(),config.getCname(),config.getAuthor());
	}
}
