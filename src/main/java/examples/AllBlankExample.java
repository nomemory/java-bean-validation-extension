//package examples;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import net.andreinc.jvbe.str.AllBlank;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import java.util.Set;
//
//public class AllBlankExample {
//    public static void main(String[] args) {
//        Test test = new Test();
//
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//        Set<ConstraintViolation<Test>> validations = validator.validate(test);
//
//        System.out.println(validations.size());
//    }
//}
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class Test {
//
//    @AllBlank
//    String allBlank = "";
//
//    @AllBlank /* A constraint validation will be raised */
//    String notAllBlank = " 1";
//
//}