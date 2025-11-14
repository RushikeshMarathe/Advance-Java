package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CourseDTO;
import com.app.dto.UpdateCourseDTO;
import com.app.entities.Course;
import com.app.repositories.CourseRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
	
	private final CourseRepository courseRepository;
	private final ModelMapper modelMapper;

	@Override
	public String createNewCourse(CourseDTO courseToAdd) {
		
		Course newCourseToAdd = modelMapper.map(courseToAdd, Course.class);
		System.out.println("new in service "+ newCourseToAdd);
		courseRepository.save(newCourseToAdd);
		System.out.println("after save");
		return "New Course Successfully Added";
	}

	@Override
	public String modifyCourse(Long id, UpdateCourseDTO dataTomodify) {
		Course courseToUpdate = courseRepository.findById(id).orElseThrow();
		
		courseToUpdate.setStartDate(dataTomodify.getStartDate());
		courseToUpdate.setEndDate(dataTomodify.getEndDate());
		courseToUpdate.setFees(dataTomodify.getFees());
		
		return "Data modified Successfully";
	}

	@Override
	public List<Course> getAllCourse(String name) {
		
		return courseRepository.findByCategory(com.app.entities.Category.valueOf(name.toUpperCase()));
	}

}
