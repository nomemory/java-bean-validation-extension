//package examples;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import net.andreinc.jbve.misc.InstanceOf;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//import java.util.Set;
//
//import static java.util.Arrays.asList;
//
//public class InstanceOfExample {
//    public static void main(String[] args) {
//
//        Animal aDog = new Dog();
//        Animal aCat = new Cat();
//        Horses pets = new Horses(asList(aDog, aCat));
//
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//
//        Set<ConstraintViolation<Horses>> validations = validator.validate(pets);
//
//        System.out.println(validations.size());
//    }
//}
//
//@Data class Animal {}
//@Data class Dog extends Animal {}
//@Data class Cat extends Animal {}
//@Data class Horse extends Animal {}
//
//@Data
//@AllArgsConstructor
//class Pets {
//    /** This should contain only Cats and Dogs as pets, and doesn't contain NULL */
//    List<@NotNull @InstanceOf({Dog.class, Cat.class}) Animal> pets;
//}
