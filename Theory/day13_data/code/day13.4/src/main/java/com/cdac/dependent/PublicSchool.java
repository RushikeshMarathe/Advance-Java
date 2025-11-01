package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	private Coach sportsCoach;

	private PublicSchool(Teacher myTeacher) {
		System.out.println("In constructor - " + getClass());
		this.subjectTeacher = myTeacher;
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	@Override
	public void organizeSportsEvent() {
		System.out.println("Preapring for sports event -");
		System.out.println("Daily Workout " + sportsCoach.getDailyWorkout());

	}

	// custom init method
	public void myInit() {
		System.out.println("in init of " + getClass());
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy of " + getClass());
	}

	// factory method based D.I
	/*
	 * Concept Explanation Your code works Because Spring matched arguments by type
	 * and order Why names didn’t matter Spring didn’t need them since types were
	 * unique Best practice Still use the correct parameter names (teacher123,
	 * coach123) When it matters If there are multiple beans or overloaded factory
	 * methods
	 */

	/*
	 * Even though the name attributes don’t match, Spring can still resolve
	 * arguments by position and type.
	 */
	public static PublicSchool myFactory(Teacher teacher123, Coach coach123) {
		System.out.println("in factory method");
		PublicSchool school = new PublicSchool(teacher123);
		school.sportsCoach = coach123;
		return school;
	}

}
