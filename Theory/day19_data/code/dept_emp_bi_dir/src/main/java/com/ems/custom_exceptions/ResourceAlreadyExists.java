package com.ems.custom_exceptions;

public class ResourceAlreadyExists extends RuntimeException {
	public ResourceAlreadyExists(String errMesg) {
		super(errMesg);
	}
}
