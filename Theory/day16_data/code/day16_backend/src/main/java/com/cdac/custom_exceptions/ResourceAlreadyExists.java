package com.cdac.custom_exceptions;

public class ResourceAlreadyExists extends RuntimeException {

	public ResourceAlreadyExists(String err)
	{
		super(err);
	}
}
