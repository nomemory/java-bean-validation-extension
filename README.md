# java-bean-validation-extension (JVBE)

*JVBE* (aka Java Bean Validation Extension) is a small utils library that extends the [Java Bean Validation Specification](http://beanvalidation.org) with additional @Annotations. This is not a JSR-380 implementation.

For the moment the only way to use the library (which is an draft stage) is to build it from the source. 

At runtime you will need an implementation for [JSR-380](https://www.jcp.org/en/jsr/detail?id=380) in order to work. At this moment there is only one implementation: [hibernate-validator](http://hibernate.org/validator/). You might also need an additional .jar (`group: 'org.glassfish', name: 'javax.el', version: '3.0.1-b08'`).

Check out the `build.gradle` to better understand the requirements.

## Additional supported annotations

*Note:* 

*All the examples are using [project's lombok](https://projectlombok.org) annotations like `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, etc.*
*Those annotations are used make the examples more compact, but their use is optional.*

### `@Alpha`

Check if the String contains only unicode letters.

### Example
```java 
@Data
class TestAlpha {
    @Alpha
    private String alpha = "abc";

    @Alpha /** Will fail */
    private String nonAlpha = "pr�s-*";
}
```

### `@Alphanumeric`

Checks if the String contains only unicode letters or digits.

### `@AlphanumericSpace`

Checks if the String contains only unicode letters, digits or spaces.

### `@AlphaSpace`

Checks if the String contains only unicode letters or spaces.
 
### `@AsciiPrintable`
 
Checks if the String is printable.

### `@Blank`

Checks if the String is empty or NULL.

### `@CC`

Checks if the String is a valid credit card number. Supported types are: 
- AMEX;
- DINERS;
- DISCOVER;
- MASTERCARD;
- VISA;
- VPAY;
- ALL.

#### Example

```java
@Data
class Account {
    @CC({ AMEX, VISA })
    private String ccNumber;
}
```

Multiple credit card types can be used.

### `@EndsWith`

Checks if the String endsWith a list of given suffixes.

#### Example

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
class SomeStrings {
    private List<@EndsWith({"1", "2"}) String> someStrings;
}
```

In the above example we validate all the contents of `someStrings` so that they end with either `1` or `2`.

### `@InstanceOf`

Tests if an object is instance of the supplied classes.

#### Examples

```java
@Data class Animal {}
@Data class Dog extends Animal {}
@Data class Cat extends Animal {}
@Data class Horse extends Animal {}

@Data
@AllArgsConstructor
class Pets {
    /** This should contain only Cats and Dogs as pets, and doesn't contain null */
    List<@NotNull @InstanceOf({Dog.class, Cat.class}) Animal> pets;
}
```

In order to test the above code we need something like this:

```java
Animal aDog = new Dog();
Animal aCat = new Cat();
Pets pets = new Pets(asList(aDog, aCat));

ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();

Set<ConstraintViolation<Pets>> validations = validator.validate(pets);

// Should return 0 because the Pets class doesn't have any validation issues.
System.out.println(validations.size());
```

### `@IPv4`

Checks if the given string is a valid IPv4 address.

### `@IPv6`

Checks if the given string is a valid IPv6 address.

### `@JsAssert` 

Tests if a Java Script expression is validating the target (class level, field level, method level).

*Note: The implementation uses nashorn that ships by default with Java. After the first run, all the expressions are pre-compiled and cached for improved performance.*

#### Example(s)

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
/* Validation at class level, tests if prop1 length is bigger than 4 
and prop2 length is smaller or equal with 3 */
@JsAssert("_.prop1.length > 4 && _.prop2.length <= 3")
public class Bean01 {

    /** Tests if the value starts with 'A' */
    @JsAssert("_[0] === 'A'")
    private String prop1;
    private String prop2;
}
```

The above code validates for `new Bean01("Abcde", "abc")`, but is not validating for `new Bean01("Bbcde", "abc")` because `prop1`  starts with `'B'` instead of `'A'`.

*Note: If you prefer other variable name for the bind value (by default it's `'_'` you can use the annotation property called `'attributeName'`)*

*Note: Multiple `@JsAssert` annotations are supported on the same field, method or class.*


### `@LowerCase`
 
Test if the given string contains only lower case characters.

### `@NotInstanceOf`

Test if an object is not an instance of any of the supplied classes.


#### Example

```java
@Data class Animal {}
@Data class Dog extends Animal {}
@Data class Cat extends Animal {}
@Data class Horse extends Animal {}

@Data
@AllArgsConstructor
class Horses {
    /** This should contain only horses and doesn't contain NULL */
    List<@NotNull @NotInstanceOf({Dog.class, Cat.class}) Animal> horses;
}
```

### `@Numeric`

Test if a given String can be transformed into a number.

### `@OneOfChars`

Test if the annotated `Character` is present in the supplied array. 

### `@OneOfDoubles`

Test if the annotated `Double` is present in the supplied array.

### `@OneOfInts`

Test if the annotated `Integer` is present in the supplied array.

### `@OneOfLongs`

Test if the annotated `Long` is present in the supplied array.

### `@OneOfStrs`

Test if the annotated `String` is present in the supplied array.

### `@StartsWith`

Test if a given String starts with a one the elements of a given list of prefixes.

```java
@Data
class Starters {
    private List< @StartsWith("1", "2") String> starts;
} 
```
