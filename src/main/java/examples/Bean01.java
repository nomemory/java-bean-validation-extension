//package examples;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import net.andreinc.jbve.exp.JsAssert;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import java.util.Set;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@JsAssert("_.prop1.length > 4 && _.prop2.length <= 3")
//public class Bean01 {
//
//    @JsAssert("_[0] === 'A'")
//    private String prop1;
//    private String prop2;
//
//    public static void main(String[] args) {
//        Bean01 bean01 = new Bean01("Abcde", "abc");
//
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//
//        Set<ConstraintViolation<Bean01>> validations = validator.validate(bean01);
//
//        System.out.println(validations);
//    }
//}
