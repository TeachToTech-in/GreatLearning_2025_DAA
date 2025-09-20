package com.course;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

@Transactional
public interface CourseJpa extends JpaRepository<Course, Integer> {

}
