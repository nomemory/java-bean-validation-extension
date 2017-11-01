package net.andreinc.jbvext.test;

import lombok.Data;
import net.andreinc.jbvext.annotations.str.AlphanumericSpace;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AlphanumericSpaceTest {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testMethods() {
        AlphanumericSpaceBeanGetters alphanumericSpaceBeanGetters = new AlphanumericSpaceBeanGetters();

        Set<ConstraintViolation<AlphanumericSpaceBeanGetters>> violations =
                validator.validate(alphanumericSpaceBeanGetters);

        Assert.assertEquals(2, violations.size());

    }

    @Test
    public void testFields() {
        AlphanumericSpaceFields alphanumericSpaceFields = new AlphanumericSpaceFields();

        Set<ConstraintViolation<AlphanumericSpaceFields>> violations =
                validator.validate(alphanumericSpaceFields);

        Assert.assertEquals(2, violations.size());

    }

    @Test
    public void testType() {
        AlphanumericSpaceType alphanumericSpaceType = new AlphanumericSpaceType();

        Set<ConstraintViolation<AlphanumericSpaceType>> violations =
                validator.validate(alphanumericSpaceType);

        Assert.assertEquals(2, violations.size());
    }
}

@Data
class AlphanumericSpaceFields {

    @AlphanumericSpace
    private String alphanumericSpace = " aA12 21 zz";

    @AlphanumericSpace
    private String alphanumericSpaceEmpty = "";

    @AlphanumericSpace
    private String alphanumericSpaceNull = null;

    @AlphanumericSpace
    private String alphanumericSpaceWrong = "; adsds 11 ZZZ AA";
}

@Data
class AlphanumericSpaceBeanGetters {

    @AlphanumericSpace
    public String getAlphanumericSpace() {
        return " aA12 21 zz";
    }

    @AlphanumericSpace
    public String getAlphanumericSpaceEmpty() {
        return "";
    }

    @AlphanumericSpace
    public String getAlphanumericSpaceNull() {
        return null;
    }

    @AlphanumericSpace
    public String getAlphanumericSpaceWrong() {
        return "; adsds 11 ZZZ AA";
    }
}

@Data
class AlphanumericSpaceType {
    private List<@AlphanumericSpace String> list = Arrays.asList(" aA12 21 zz", "", null, "; adsds 11 ZZZ AA");
}
