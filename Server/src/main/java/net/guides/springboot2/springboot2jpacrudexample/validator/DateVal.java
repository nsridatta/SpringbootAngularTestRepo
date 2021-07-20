package net.guides.springboot2.springboot2jpacrudexample.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DateValidator.class)
public @interface DateVal {
    String message() default "Date is not Valid.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
