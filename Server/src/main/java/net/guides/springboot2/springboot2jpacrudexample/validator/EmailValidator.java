package net.guides.springboot2.springboot2jpacrudexample.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class EmailValidator implements ConstraintValidator<EmailVal, String> {


    List<String> emails = Arrays.asList("John.papa@gmail.com", "rambo.lars@gmail.com", "bamboo.tree@gmail.com", "abc@gmail.com");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return emails.contains(value);

    }
}
