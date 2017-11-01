package net.andreinc.jbvext.annotations.misc;

import net.andreinc.jbvext.annotations.misc.validators.OneOfDoublesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = OneOfDoublesValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
public @interface OneOfDoubles {
    String message() default "{misc.oneof.doubles}";

    double[] value() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}