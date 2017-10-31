package net.andreinc.jbve.annotations.str;

import net.andreinc.jbve.annotations.str.validators.IPv6Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = IPv6Validator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface IPv6 {
    String message() default "{string.ipv6}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}