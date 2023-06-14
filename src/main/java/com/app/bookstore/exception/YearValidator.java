package com.app.bookstore.exception;

import java.time.LocalDate;
import java.time.Month;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class YearValidator implements ConstraintValidator<ValidYear, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		return value.isAfter(LocalDate.of(2000, Month.JANUARY, 1)) && value.isBefore(LocalDate.now());
	}

}
