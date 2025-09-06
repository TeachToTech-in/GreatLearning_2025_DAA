package com.rahul;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class CourseController {

	private CourseService service;

	public CourseController(CourseService service) {
		super();
		this.service = service;
	}
	

	@GetMapping("/courses/{id}")
	public String getCourse(Model model,@PathVariable int id) {
		Course object = service.getCourseById(id);
		model.addAttribute("course", object);
		return "demo";
	}
	
	@GetMapping(path = {"/courses","/"})
	public String getAllCourse(Model model) {
		List<Course> courses = service.getAllCourses();
		model.addAttribute("courses", courses);
		return "demo";
	}
	//courses/add
	@GetMapping("/courses/add")
	public String modelPage(Model model) {
		Course course = new Course();
		model.addAttribute("course",course);
		return "modelPage";
	}
	
	//course/save
	@PostMapping("/course/save")
	public String saveCourse(@ModelAttribute Course course) {
		service.saveCourse(course);
		return "redirect:/";
		
	}
	//courses/delete/0
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable int id) {
		service.removeById(id);
		return "redirect:/";
	}
	//http://localhost:8080/students/update/2
	@GetMapping("/students/update/{id}")
	public String updateCourse(Model model,@PathVariable int id) {
		Course course = service.getCourseById(id);
		model.addAttribute("course",course);
		return "modelPage";
	}
	



}
