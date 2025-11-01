package com.cdac.dependent;

import com.cdac.dependency.MathsTeacher;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;
	
	/*
	 * If we directly write subjectTeacher = new EnglishTeacher(), then the dependent class
	 * (PublicSchool) is creating its own dependency, which leads to tight coupling.
	 * This means whenever the dependency changes (for example, from EnglishTeacher to MathsTeacher),
	 * the dependent class itself must be modified.
	 *
	 * To achieve loose coupling, the dependent class should not create its own dependency.
	 * Instead, a third party (in this case, the tester or framework) should inject the dependency
	 * through the constructor — this is called Constructor-Based Dependency Injection.
	 */


	// Constructor based D.I - reco.
	public PublicSchool(Teacher myTeacher) {
		System.out.println("In constructor - " + getClass());
		this.subjectTeacher = myTeacher;
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	// custom init method
	public void myInit() {
		System.out.println("in init of " + getClass());
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy of " + getClass());
	}

}
