package net.andreinc.jbvext.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.andreinc.jbvext.annotations.str.Parseable;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static net.andreinc.jbvext.annotations.str.ParseableType.*;

public class ParseableTest {

    private Validator validator =
            Validation.buildDefaultValidatorFactory().getValidator();


    @Test
    public void testFields() {
        ParseableBeanFields startsWithBeanFields = ParseableBeanFields
                .builder()
                .parseInt("12")
                .parseDouble("12.21")
                .parseFloat("12.2")
                .parseLong("22121")
                .parseShort("121")
                .build();

        Set<ConstraintViolation<ParseableBeanFields>> violations =
                validator.validate(startsWithBeanFields);

        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void testFieldsAllNull() {
        ParseableBeanFields startsWithBeanFields = new ParseableBeanFields();

        Set<ConstraintViolation<ParseableBeanFields>> violations =
                validator.validate(startsWithBeanFields);

        Assert.assertEquals(5, violations.size());
    }
}


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class ParseableBeanFields {

    @Parseable(TO_INT)
    private String parseInt;

    @Parseable(TO_DOUBLE)
    private String parseDouble;

    @Parseable(TO_LONG)
    private String parseLong;

    @Parseable(TO_FLOAT)
    private String parseFloat;

    @Parseable(TO_SHORT)
    private String parseShort;

}