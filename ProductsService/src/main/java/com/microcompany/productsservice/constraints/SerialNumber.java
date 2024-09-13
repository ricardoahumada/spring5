package com.microcompany.productsservice.constraints;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SerialNumber.Validator.class})
public @interface SerialNumber {

    String message()
            default "Debe tener un esquema 111-222-3333";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<SerialNumber, String> {
        @Override
        public void initialize(final SerialNumber serial) {
        }

        @Override
        public boolean isValid(final String serial, final ConstraintValidatorContext constraintValidatorContext) {
            // conetarnos a una api para solicitar validez más amplia
            // valiudar la estructura del valor 111-222-3333
            final String serialNumRegex = "^\\d{3}-\\d{3}-\\d{4}$";
            if(serial!=null) return Pattern.matches(serialNumRegex, serial);
            else return false;
        }
    }
}