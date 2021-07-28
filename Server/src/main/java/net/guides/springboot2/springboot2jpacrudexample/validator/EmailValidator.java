package net.guides.springboot2.springboot2jpacrudexample.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailVal, String> {

    String extensiveEmailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        // TODO Auto-generated method stub
        if(email == null) {
            return false;
        }

        //Validate phone numbers of format "1234567890"
        if (email.matches("\\^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) return true;
        else if(email.matches("\\^(.+)@(.+)$")) return true;
        else if(email.matches("\\^[A-Za-z0-9+_.-]+@(.+)$")) return true;
        else return email.matches(extensiveEmailRegex);
    }
}
