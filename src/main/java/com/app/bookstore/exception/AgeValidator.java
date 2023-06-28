package com.app.bookstore.exception;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<ValidAge, Integer>{

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return value > 18;
	}

}
