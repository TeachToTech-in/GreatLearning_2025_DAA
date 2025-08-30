package com.rahul;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

	private CourseRepository repository;

	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public void saveCourse(Course course) {
		repository.save(course);
	}

	public void removeById(int id) {
		repository.deleteById(id);
		
	}
	
	
	
}
