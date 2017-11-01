package net.andreinc.jbvext.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.andreinc.jbvext.annotations.misc.InstanceOf;
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
class IofEveAndAdam {
}

@Data
@EqualsAndHashCode(callSuper = false)
class IofCain extends IofEveAndAdam {
}

@Data
@EqualsAndHashCode(callSuper = false)
class IofAbel extends IofEveAndAdam {
}

@Data
@EqualsAndHashCode(callSuper = false)
class IofSeth extends IofEveAndAdam {
}

public class InstanceOfTest {

    private Validator validator =
            buildDefaultValidatorFactory().getValidator();

    @Test
    public void testFields() {
        InstanceOfBeanFields instanceOfBeanFields = new InstanceOfBeanFields();

        Set<ConstraintViolation<InstanceOfBeanFields>> violations =
                validator.validate(instanceOfBeanFields);

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
        InstanceOfBeanType instanceOfBeanType = new InstanceOfBeanType();

        Set<ConstraintViolation<InstanceOfBeanType>> violations =
                validator.validate(instanceOfBeanType);

        Assert.assertEquals(0, violations.size());
    }
}


@Data
class InstanceOfBeanFields {

    @InstanceOf({IofCain.class, IofAbel.class})
    private IofEveAndAdam correct = new IofCain();

    @InstanceOf({IofSeth.class})
    private IofEveAndAdam incorrect = new IofAbel();

}

@Data
class InstanceOfBeanMethods {

    @InstanceOf({IofCain.class, IofAbel.class})
    private IofEveAndAdam getCorrect() {
        return new IofCain();
    }

    @InstanceOf({IofSeth.class})
    private IofEveAndAdam getIncorrect() {
        return new IofAbel();
    }

}

@Data
class InstanceOfBeanType {
    private List<@InstanceOf({IofCain.class, IofAbel.class, IofSeth.class}) IofEveAndAdam> list =
            Arrays.asList(new IofCain(), new IofAbel(), new IofSeth());
}