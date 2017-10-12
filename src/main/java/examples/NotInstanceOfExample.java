//package examples;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import net.andreinc.jvbe.misc.NotInstanceOf;
//
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
///**
// * Created by andreinicolinciobanu on 12/10/17.
// */
//public class NotInstanceOfExample {
//    public static void main(String[] args) {
//
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
//class Horses {
//    /** This should contain only horses and doesn't contain NULL */
//    List<@NotNull @NotInstanceOf({Dog.class, Cat.class}) Animal> horses;
//}
