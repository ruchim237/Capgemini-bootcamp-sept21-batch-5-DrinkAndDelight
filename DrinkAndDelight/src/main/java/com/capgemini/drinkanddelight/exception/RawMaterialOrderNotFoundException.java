package com.capgemini.drinkanddelight.exception;

public class RawMaterialOrderNotFoundException extends RuntimeException{

	public RawMaterialOrderNotFoundException(String string)
	{
		super(string);
		System.out.println(string);
	}
}
