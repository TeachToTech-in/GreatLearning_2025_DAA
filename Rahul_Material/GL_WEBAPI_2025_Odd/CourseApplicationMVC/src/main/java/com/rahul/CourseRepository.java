package com.rahul;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
													//Entity You want to manage 
													//Type of The ID
@Repository
@Transactional
public interface CourseRepository  extends JpaRepository<Course, Integer>{

//extends MongoRepository<Course, Integer>{


}
