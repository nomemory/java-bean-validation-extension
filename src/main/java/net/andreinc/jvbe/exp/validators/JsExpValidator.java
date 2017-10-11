package net.andreinc.jvbe.exp.validators;

import net.andreinc.jvbe.exp.JsAssert;

import javax.validation.ConstraintValidatorContext;

public class JsExpValidator extends ExpValidator<JsAssert> {

    public JsExpValidator() {
        super();
        this.engineType = ExpEngine.JAVASCRIPT;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return super.isValid(annotation.attributeName(), value, annotation.value(), context);
    }
}
