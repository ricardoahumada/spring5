package com.microcompany.productsservice.constraints;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IpAddress.IpAddressValidator.class)
@Documented
public @interface IpAddress {

    String message() default "{IpAddress.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class IpAddressValidator implements ConstraintValidator<IpAddress, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            Pattern pattern =
                    Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
            Matcher matcher = pattern.matcher(value);
            try {
                if (!matcher.matches()) {
                    return false;
                } else {
                    for (int i = 1; i <= 4; i++) {
                        int octet = Integer.valueOf(matcher.group(i));
                        if (octet > 255) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

}
