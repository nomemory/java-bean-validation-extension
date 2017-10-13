package net.andreinc.jvbe.annotations.str;

import net.andreinc.jvbe.annotations.str.validators.EndsWithValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = EndsWithValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface EndsWith {
    String message() default "{string.endswith}";
    String[] value();
    boolean ignoreCase() default false;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
