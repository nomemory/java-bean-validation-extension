package net.andreinc.jvbe.annotations.misc;

import net.andreinc.jvbe.annotations.misc.validators.InstanceOfValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = InstanceOfValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface InstanceOf {
    String message() default "{misc.instanceof}";
    Class<?>[] value();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


