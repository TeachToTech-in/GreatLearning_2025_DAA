package com.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MentorController {

	@Autowired
	private MentorConfig config;
	
	@GetMapping("/mentors")
	public Mentor getAll() {
		return  new Mentor(config.getId(),config.getName(),config.getContact());
	}
}
