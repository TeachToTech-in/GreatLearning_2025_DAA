package com.rahul;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "course")
public class CourseConfiguration {

	private int courseid;
	private String coursename;
	private String courseauthor;
	
	public CourseConfiguration(int courseid, String coursename, String courseauthor) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.courseauthor = courseauthor;
	}
	public CourseConfiguration() {
		super();
		// TODO Auto-generated constructor stub
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
		return "CourseConfiguration [courseid=" + courseid + ", coursename=" + coursename + ", courseauthor="
				+ courseauthor + "]";
	}
	
}
