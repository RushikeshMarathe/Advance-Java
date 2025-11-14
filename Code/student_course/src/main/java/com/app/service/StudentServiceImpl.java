package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.custom_cexception.StudentCourseException;
import com.app.dto.StudentDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repositories.CourseRepository;
import com.app.repositories.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final ModelMapper modelMapper;

	@Override
	public String createNewStudent(Long id, StudentDTO student) {
		
		Course course = courseRepository.findById(id).orElseThrow();
		
		Student newStudent = modelMapper.map(student, Student.class);
		
		
		if(newStudent.getMarks()>=course.getMarks())
		{
		newStudent.setCourse(course);
		studentRepository.save(newStudent);
		}else {
			throw new StudentCourseException("Minimum "+course.getMarks()+"required for Admission");
		}
		
		return "Student added Successfully!...";
	}

}
