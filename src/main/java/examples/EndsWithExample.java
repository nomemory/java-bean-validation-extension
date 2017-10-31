//package examples;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import net.andreinc.jbve.annotations.str.EndsWith;
//
//import java.util.List;
//
//import static java.util.Arrays.asList;
//
//public class EndsWithExample {
//    public static void main(String[] args) {
//        SomeStrings someStrings =
//                new SomeStrings(asList("a1", "a2", "b2", "b3"));
//    }
//}
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class SomeStrings {
//    private List<@EndsWith(value = {"1", "2"}) String> someStrings;
//}
