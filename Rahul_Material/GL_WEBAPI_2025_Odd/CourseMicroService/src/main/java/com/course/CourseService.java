package com.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	private CourseJpa jpa;

	public CourseService(CourseJpa jpa) {
		super();
		this.jpa = jpa;
	}
	

}
