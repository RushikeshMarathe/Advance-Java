package com.app.custom_cexception;

public class StudentCourseException extends RuntimeException {

	public StudentCourseException(String errMessage)
	{
		super(errMessage);
	}
}
