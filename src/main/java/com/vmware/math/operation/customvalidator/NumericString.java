package com.vmware.math.operation.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { NumericStringValidator.class })
@Documented
public @interface NumericString {
	String message() default "String should be numeric";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}