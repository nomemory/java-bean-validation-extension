package net.andreinc.jvbe.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.andreinc.jvbe.annotations.misc.NotInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static javax.validation.Validation.buildDefaultValidatorFactory;

@Data
@EqualsAndHashCode(callSuper = false)
class NIofEveAndAdam {
}

@Data
@EqualsAndHashCode(callSuper = false)
class NIofCain extends NIofEveAndAdam {
}

@Data
@EqualsAndHashCode(callSuper = false)
class NIofAbel extends NIofEveAndAdam {
}

@Data
@EqualsAndHashCode(callSuper = false)
class NIofSeth extends NIofEveAndAdam {
}

public class NotInstanceOfTest {

    private Validator validator =
            buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        NotInstanceOfBeanFields notInstanceOfBeanFields = new NotInstanceOfBeanFields();

        Set<ConstraintViolation<NotInstanceOfBeanFields>> violations =
                validator.validate(notInstanceOfBeanFields);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testMethods() {
        InstanceOfBeanMethods instanceOfBeanMethods = new InstanceOfBeanMethods();

        Set<ConstraintViolation<InstanceOfBeanMethods>> violations =
                validator.validate(instanceOfBeanMethods);

        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void testType() {
        NotInstanceOfType notInstanceOfType = new NotInstanceOfType();

        Set<ConstraintViolation<NotInstanceOfType>> violations =
                validator.validate(notInstanceOfType);

        Assert.assertEquals(0, violations.size());
    }
}

@Data
class NotInstanceOfBeanFields {

    @NotInstanceOf({NIofSeth.class, NIofCain.class})
    private NIofEveAndAdam correct = new NIofAbel();

    @NotInstanceOf({NIofSeth.class, NIofCain.class})
    private NIofEveAndAdam incorrect = new NIofCain();

}

@Data
class NotInstanceOfBeanMethods {

    @NotInstanceOf({NIofSeth.class, NIofCain.class})
    private NIofEveAndAdam getCorrect() {
        return new NIofAbel();
    }

    @NotInstanceOf({NIofSeth.class, NIofCain.class})
    private NIofEveAndAdam getIncorrect() {
        return new NIofCain();
    }

}

@Data
class NotInstanceOfType {
    @NotInstanceOf({NIofSeth.class, NIofCain.class})
    private List<NIofEveAndAdam> sons = Arrays.asList(new NIofAbel());
}