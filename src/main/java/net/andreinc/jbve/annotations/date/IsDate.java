package net.andreinc.jbve.annotations.date;

import net.andreinc.jbve.annotations.date.validator.IsDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = IsDateValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface IsDate {
    String value();

    String message() default "{date.isdate}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
