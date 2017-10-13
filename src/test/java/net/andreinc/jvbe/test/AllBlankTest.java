package net.andreinc.jvbe.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.andreinc.jvbe.annotations.str.AllBlank;
import net.andreinc.jvbe.utils.BeanValidationException;
import net.andreinc.jvbe.utils.SimpleValidation;
import org.junit.Test;

public class AllBlankTest {

    @Test
    public void testEmptyStringField() {
        AllBlankBeanField bean = new AllBlankBeanField("");
        SimpleValidation.validate(bean);
    }

    @Test
    public void testNullStringField() {
        AllBlankBeanField bean = new AllBlankBeanField(null);
        SimpleValidation.validate(bean);
    }

    @Test(expected = BeanValidationException.class)
    public void testNotEmptyOrNullField() {
        AllBlankBeanField bean = new AllBlankBeanField("1");
        SimpleValidation.validate(bean);
    }

    @Test
    public void testEmptyAndNullMethods() {
        AllBlankMethodField allBlankMethodField = new AllBlankMethodField();
        SimpleValidation.validate(allBlankMethodField);
    }

    @Test(expected = BeanValidationException.class)
    public void testNotEmptyOrNullMethod() {
        AllBlankMethodFieldIncorrect allBlankMethodFieldIncorrect = new AllBlankMethodFieldIncorrect();
        SimpleValidation.validate(allBlankMethodFieldIncorrect);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AllBlankBeanField {
    @AllBlank
    private String allBlank;
}

@NoArgsConstructor
class AllBlankMethodField {
    @AllBlank
    public String getNullString() {
        return null;
    }

    @AllBlank
    public String getEmptyString() {
        return "";
    }
}

@NoArgsConstructor
class AllBlankMethodFieldIncorrect {
    @AllBlank
    public String getNullStringIncorrect() {
        return "1";
    }
}
