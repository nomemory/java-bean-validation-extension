package net.andreinc.jbvext.annotations.exp;

import net.andreinc.jbvext.annotations.exp.validators.JsAssertValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(JsAsserts.class)
@Documented
@Constraint(validatedBy = JsAssertValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface JsAssert {
    String message() default "{exp.js}";
    String value() default "true";
    String attributeName() default "_";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


