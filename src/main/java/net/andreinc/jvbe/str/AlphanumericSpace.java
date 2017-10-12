package net.andreinc.jvbe.str;


import net.andreinc.jvbe.str.validators.AlphanumericSpaceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Checks if the String contains only unicode letters, digits or space (' ')
 */
@Documented
@Constraint(validatedBy = AlphanumericSpaceValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface AlphanumericSpace {
    String message() default "{str.alphanumericspace}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
