package net.andreinc.jbve.annotations.misc;

import net.andreinc.jbve.annotations.misc.validators.NotInstanceOfValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = NotInstanceOfValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface NotInstanceOf {
    String message() default "{misc.notinstanceof}";
    Class<?>[] value();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
