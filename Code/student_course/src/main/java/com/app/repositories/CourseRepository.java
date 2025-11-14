package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByCategory(Category category);
}
