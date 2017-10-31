package net.andreinc.jbve.annotations.str;

import net.andreinc.jbve.annotations.str.validators.StartsWithValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = StartsWithValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface   StartsWith {
    String message() default "{string.startswith}";

    String[] value();
    boolean ignoreCase() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
