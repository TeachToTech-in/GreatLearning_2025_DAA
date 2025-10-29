package com.rahul;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private StudentRepository repository;

	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Student getById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public void saveS(Student student) {
		repository.save(student);
		
	}

	public void delete(int id) {
		repository.deleteById(id);
		
	}

}
