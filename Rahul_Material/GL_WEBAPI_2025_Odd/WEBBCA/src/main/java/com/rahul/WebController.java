package com.rahul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
	
	private StudentService service;
	

	public WebController(StudentService service) {
		super();
		this.service = service;
	}
	@GetMapping("/students/{id}")
	public String getStudentById(@PathVariable int id,Model mav) {
		mav.addAttribute("student",service.getById(id));
		return "demo";
	}
	@GetMapping("/students")
	public String getStudents(Model mav){
		mav.addAttribute("students", service.getAllStudent());
		return "home";
	}
	@GetMapping("/students/add")
	public String addStudentForm(Model model) {
	    model.addAttribute("student", new Student());
	    return "addStudent"; // add-student.html
	}
	@PostMapping("/students/save")
	public String saveStudent(@ModelAttribute Student student) {
	    service.saveS(student);
	    return "redirect:/students";
	}
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
	    service.delete(id);
	    return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {
	    model.addAttribute("student", service.getById(id));
	    return "addStudent"; // reuse same form for update
	}
	
}
