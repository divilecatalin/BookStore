package com.app.bookstore.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>{
	private final String EMAIL_VALIDATOR = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile(EMAIL_VALIDATOR);
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}
	

}
