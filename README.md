# java-bean-validation-extension (JVBE)

*JVBE* (aka Java Bean Validation Extension) is a small utils library that extends the [Java Bean Validation Specification](http://beanvalidation.org) with additional @Annotations. This is not a JSR-380 implementation, and should be used togheter with one (eg.: [hibernate-validator](http://hibernate.org/validator/)).

Check out the `build.gradle` to better understand the requirements. Integrating the repo with Maven Central and JCenter is still an work in progress. 

## Addiotnal supported annotations

| @Annotation | Supported Types | Description |
| --- | --- | --- |
| [`@Alpha`](#alpha) | `String` | Checks if the String contains only unicode letters. |
| [`@Alphanumeric`](#alphanumeric) | `String` | Checks if the String contains unly unicode letters or digits |
| [`@AlphanumericSpace`](#alphanumericspace) | `String` | Checks if the String contains only unicode letters, digits, empty strings or spaces. |
| [`@AlphaSpace`](#alphaspace) | `String` | Checks if the String contains only Unicode letters and space `" "`. |
| [`@AsciiPrintable`](#asciiprintable) | `String` | Checks if the String contains only ASCII printable characters. |
| [`@Blank`](#blank) | `String` | Checks if the String is empty `""`, null or whitespace(s) `"  "` only. |
| [`@CC`](#cc) | `String` | Checks if the String is a valid credit card number. |
| [`@EndsWith`](#endswith) | `String` | Checks if the Strings ends with a specified suffix(es). |
| [`@IPv4`](#ipv4) | `String` | Checks if the String is a valid IPv4 address. |
| [`@IPv6`](#ipv6) | `String` | Checks if the String is a valid IPv6 address. |
| [`@LowerCase`](#lowercase) | `String` | Checks if the String contains only lowercase letters. |
| [`@Numeric`](#numeric) | `String` | Checks if the String contains only unicode digits. *Note: A decimal point is not considered a digit and the validation fails. Use `@Parseable` instead for more advanced validations*. |
| [`@Parseable`](#parseable) | `String` | Check if the String can be parsed to a number (`Short`, `Integer`, `Long`, `Double`, etc.). |
| ...more | ...more | ...more to be documented. |

*Note:* 

*All the examples are using [project's lombok](https://projectlombok.org) annotations like `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, etc.*
*Those annotations are used make the examples more compact, but their use is optional.*

### `@Alpha`

Check if the String contains only unicode letters. 

Behavior:

| Value | Result |
| --- | ---
| `null` | :x: Fails |
| `""` | :x: Fails |
| `" "` | :x: Fails |
| `"abc"` | :white_check_mark: Passes |
| `"ab2c"` | :x: Fails |
| `"ab-c"` | :x: Fails |


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

Behavior:

| Value | Result |
| --- | --- |
| `null` | :x: Fails |
| `""` | :x: Fails |
| `" "` | :x: Fails |
| `"abc"` | :white_check_mark: Passes |
| `"ab c"` | :x: Fails |
| `"ab2c"` | :white_check_mark: Passes |
| `"ab-c"` | :x: Fails |

### `@AlphanumericSpace`

Checks if the String contains only unicode letters, digits, empty strings or spaces.

Behavior:

| Value | Result |
| --- | --- |
| `null` | :x: Fails |
| `""` | :white_check_mark: Passes |
| `" "` | :white_check_mark: Passes |
| `"abc"` | :white_check_mark: Passes |
| `"ab c"` | :white_check_mark: Passes |
| `"ab2c"` | :white_check_mark: Passes |
| `"ab-c"` | :x: Fails |

### `@AlphaSpace`

Checks if the String contains only Unicode letters and space (" ").

Behavior:

| Value | Result |
| --- | --- |
| `null` | :x: Fails |
| `""` | :white_check_mark: Passes |
| `" "` | :white_check_mark: Passes |
| `"abc"` | :white_check_mark: Passes |
| `"ab c"` | :white_check_mark: Passes |
| `"ab1c"` | :x: Fails |
| `"ab-c"` | :x: Fails |
 
### `@AsciiPrintable`
 
Checks if the String is printable (ASCII printable characters).

Behavior:

| Value | Result |
| --- | --- |
| `null` | :x: Fails |
| `""` | :white_check_mark: Passes |
| `" "` | :white_check_mark: Passes |
| `"\u0020"` | :white_check_mark: Passes |
| `"\u007e"` | :x: Fails |
| `"G\u00fclc\u00fc"` | :x: Fails |

### `@Blank`

Checks if the String is empty `""`, null or whitespace(s) `"  "` only.

Behavior:

| Value | Result |
| --- | --- |
| `null` | :white_check_mark: Passes |
| `""` | :white_check_mark: Passes |
| `" "` | :white_check_mark: Passes |
| `"abc"` | :x: Fails |
| `" abc "` | :x: Fails |


### `@CC`

Checks if the String is a valid credit card number. Supported types are defined in the `CreditCardType` enum: 

- AMEX: 
- DINERS;
- DISCOVER;
- MASTERCARD;
- VISA;
- VPAY;
- ALL.

Multiple credit card types can be supplied to the `@CC` annotation. 

#### Example

```java
@Data
class Account {
    @CC({ AMEX, VISA }) // AMEX or VISA
    private String ccNumber;
}
```

Multiple credit card types can be used.

### `@EndsWith`

Checks if the String `endsWith` a list of given suffix(es). If multiple suffixes are supplied, the relationship between them is `OR`(eg.: endsWith(prefix1) OR endsWith(prefix2) OR ...).

The annotation supports a second property `ignoreCase` that by default is `false`.

Behavior (`ignoreCase==false`):

| Value | Suffix | Result |
| --- | --- | --- |
| `null` | "abc" | :x: Fails |
| `"abcdef"` | `"def"` | :white_check_mark: Passes |
| `"ABCDEF"` | `"def"` | :x: Fails |
| `"ABCDEF"` | `""` | :white_check_mark: Passes |

Behavior (`ignoreCase==true`)

| Value | Suffix | Result |
| --- | --- | --- |
| `null` | "abc" | :x: Fails |
| `"abcdef"` | `"def"` | :white_check_mark: Passes |
| `"ABCDEF"` | `"def"` | :white_check_mark: Passes |
| `"ABCDEF"` | `""` | :white_check_mark: Passes |

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

This is implemented using `InetAddressValidator.class` from [Apache Common Validator](https://commons.apache.org/proper/commons-validator/).

### `@IPv6`

Checks if the given string is a valid IPv6 address.

This is implemented using `InetAddressValidator.class` from [Apache Common Validator](https://commons.apache.org/proper/commons-validator/).

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

Checks if the String contains only lowercase letters.

Behavior:

| Value | Result |
| --- | --- |
| `null` | :x: Fails |
| `""` | :x: Fails |
| `" "` | :x: Fails |
| `"abc"` | :white_check_mark: Passes |
| `"abC"` | :x: Fails |
| `"ab c"` | :x: Fails |
| `"ab1c"` | :x: Fails |
| `"ab-c"` | :x: Fails |

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

Checks if a String contains only Unicode digits. A decimal point is not an unicode digit and thus, the validation fails.

Behavior:

| Value | Result |
| --- | --- |
| `null` | :x: Fails |
| `""` | :x: Fails |
| `" "` | :x: Fails |
| `"123"` |  :white_check_mark: Passes | 
| `"\u0967\u0968\u0969"` | :white_check_mark: Passes |
| `"12 3"` | :x: Fails |
| `"12a3"` | :x: Fails |
| `"12-3"` | :x: Fails |

### `@Parseable`

Check if the String can be parsed to a number.

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
