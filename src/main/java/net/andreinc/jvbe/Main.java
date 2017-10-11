package net.andreinc.jvbe;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Test t = new Test();
        t.expr = "abc";

        TestWrapper tw = new TestWrapper();
        tw.setTest(t);

        for (int i = 0; i < 1000; i++) {
            Set<ConstraintViolation<TestWrapper>> cv = validator.validate(tw);
            System.out.println(cv);
        }
    }
}

