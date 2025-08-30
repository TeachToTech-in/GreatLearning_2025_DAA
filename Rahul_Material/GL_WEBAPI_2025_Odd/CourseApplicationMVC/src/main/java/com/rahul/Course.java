package com.rahul;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//Specifies that the class is an entity. 
//This annotation is applied to the entity class
@Entity
//@Document
public class Course {
	//Specifies the primary key of an entity. 
	//The field or property to which the Id annotation is 
	//applied should be one of the following types
	@Id
	private int courseid;
	private String coursename;
	private String courseauthor;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseid, String coursename, String courseauthor) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.courseauthor = courseauthor;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCourseauthor() {
		return courseauthor;
	}
	public void setCourseauthor(String courseauthor) {
		this.courseauthor = courseauthor;
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", courseauthor=" + courseauthor + "]";
	}

}
