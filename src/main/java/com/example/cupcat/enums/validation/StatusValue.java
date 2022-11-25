package com.example.cupcat.enums.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = StatusValueValidator.class)
public @interface StatusValue {
    Class<? extends Enum<?>> enumClass();
    String message() default "Must be any of enum OrderStatus [CANCELLED, DELIVERED, IN_TRANSIT, PAYMENT_DUE, PICK_UP_AVAILABLE, PROBLEM, PROCESSING, RETURNED]";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
