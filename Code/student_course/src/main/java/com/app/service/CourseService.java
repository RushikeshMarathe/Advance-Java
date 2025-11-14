package com.app.service;

import java.util.List;

import com.app.dto.CourseDTO;
import com.app.dto.UpdateCourseDTO;
import com.app.entities.Course;

public interface CourseService {
	
	String createNewCourse(CourseDTO courseToAdd);
	
	String modifyCourse(Long id,UpdateCourseDTO dataTomodify);
	
	List<Course> getAllCourse(String name);
	
}
