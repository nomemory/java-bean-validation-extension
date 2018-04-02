package net.andreinc.jbvext.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.andreinc.jbvext.annotations.str.Password;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class PasswordTest {

    private Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void nullPasswordTest() {
        PassBean1 passBean1 = new PassBean1(null);
        Set<ConstraintViolation<PassBean1>> violations = validator.validate(passBean1);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void minSizeTest() {
        PassBean2 p = new PassBean2();
        Set<ConstraintViolation<PassBean2>> violations = validator.validate(p);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void badPass() {
        PassBean3 p = new PassBean3();
        Set<ConstraintViolation<PassBean3>> violations = validator.validate(p);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void goodPass() {
        PassBean4 p = new PassBean4();
        Set<ConstraintViolation<PassBean4>> violations = validator.validate(p);
        Assert.assertEquals(0, violations.size());
    }
}

@AllArgsConstructor
@Data
class PassBean1 {
    @Password()
    private String pass1 = null;
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class PassBean2 {
    @Password(minSize = 3, containsDigits = false)
    private String pass1 = "aA@";

    @Password(minSize = 3, containsDigits = false, containsSpecialChar = false, containsUpperCase = false)
    private String pass2 = "ab";
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class PassBean3 {
    @Password
    private String badPass = "AAbbCCddEE1";
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class PassBean4 {
    @Password
    private String goodPass = "Ab1_abcde";
}