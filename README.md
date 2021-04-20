# java-bean-validation-extension (JBVExt)

*JBVE* (Java Bean Validation Extension) is a small utils library that extends the [Java Bean Validation Specification](http://beanvalidation.org) with additional @Annotations. 

If you are not familiar with JSR-380 (or the Java Bean Validation Specification) please follow [this nice tutorial](http://www.baeldung.com/javax-validation) first.

If you want to see *JVBExt* at work please:
- read this [blog article](http://andreinc.net/2017/10/02/writing-an-unified-validation-mechanism-for-rest-apis-using-spring-boot-and-jsr-380/);
- check out this [repository](https://github.com/nomemory/spring-boot-jbvext-example).

## Installing the library

For versions (`>=0.0.12`):

```xml
<dependency>
  <groupId>net.andreinc</groupId>
  <artifactId>jbve</artifactId>
  <version>0.0.12</version>
</dependency>
```
*Important note(s):*

In the runtime environment you will an existing JSR-380 implementation in the classpath. Spring Boot started web comes by default with [Hibernate Validator](http://hibernate.org/validator/).

If you are using the library in another environment that doesn't provide a JSR-380 implementation you will need to add the following as dependencies:

```groovy
compile group: 'org.hibernate', name: 'hibernate-validator', version: '6.0.2.Final'
compile group: 'org.glassfish', name: 'javax.el', version: '3.0.1-b08'
```

## Who is using jbvext ?

**Java Bean Validation Extension** was downloaded +/-450 times since October, 2017.

If you are using **jbvext** in your cool projects please send me a note so I can include you in this list.

## Additional supported annotations

| @Annotation | Supported Types | Description |
| --- | --- | --- |
| [`@After`](#after) | `Date` | Check if the Date is after the given date value, with date format as parameter. |
| [`@Alpha`](#alpha) | `String` | Checks if the String contains only unicode letters. |
| [`@Alphanumeric`](#alphanumeric) | `String` | Checks if the String contains unly unicode letters or digits |
| [`@AlphanumericSpace`](#alphanumericspace) | `String` | Checks if the String contains only unicode letters, digits, empty strings or spaces. |
| [`@AlphaSpace`](#alphaspace) | `String` | Checks if the String contains only Unicode letters and space `" "`. |
| [`@AsciiPrintable`](#asciiprintable) | `String` | Checks if the String contains only ASCII printable characters. |
| [`@Blank`](#blank) | `String` | Checks if the String is empty `""`, null or whitespace(s) `"  "` only. |
| [`@Before`](#before) | `Date` | Check if the Date is before the given date value, with date format as parameter. |
| [`@CC`](#cc) | `String` | Checks if the String is a valid credit card number. |
| [`@EndsWith`](#endswith) | `String` | Checks if the Strings ends with a specified suffix(es). |
| [`@InstanceOf`](#instanceof) | `Object` | Check if the Object is an `instanceof` of (at least one of) the supplied value(s). |
| [`@IPv4`](#ipv4) | `String` | Checks if the String is a valid IPv4 address. |
| [`@IPv6`](#ipv6) | `String` | Checks if the String is a valid IPv6 address. |
| [`@IsDate`](#isdate) | `String` | Check if the String is in a date format. |
| [`@LowerCase`](#lowercase) | `String` | Checks if the String contains only lowercase letters. |
| [`@MinDigits`](#mindigits) | `Double` | Checks whether the annotated value is higher than or equal to the specified minimum. |
| [`@MaxDigits`](#maxdigits) | `Double` | Checks whether the annotated value is less than or equal to the specified maximum. |
| [`@NotInstanceOf`](#notinstanceof) | `Object` | Check if the is not an `instanceof` of (all the) the supplied value(s). |  
| [`@Numeric`](#numeric) | `String` | Checks if the String contains only unicode digits. *Note: A decimal point is not considered a digit and the validation fails. Use `@Parseable` instead for more advanced validations*. |
| [`@OneOfChars`](#oneofchars) | `Character` | Checks if the Character is contained in a given array (`char[]`) of values. |
| [`@OneOfDoubles`](#oneofdoubles) | `Double` | Check if the Double is contained in a given array (`double[]`) of values. |
| [`@OneOfIntegers`](#oneofintegers) | `Integer` | Check if the Integer is contained in a given array (`int[]`) of values. |
| [`@OneOfLongs`](#oneoflongs) | `Long` | Check if the Long is contained in a given array (`long[]`) of values. |
| [`@OneOfStrings`](#oneofstrings) | `String` | Checks if the String is contained in a given array (`String[]`) of values. |
| [`@Parseable`](#parseable) | `String` | Checks if the String can be parsed to a number (`Short`, `Integer`, `Long`, `Double`, etc.). |
| [`@Password`](#password) | `String` | Checks if the String is a valid password. |
| [`@StartsWith`](#startswith) | `String` | Checks if the String starts with the specified prefix(es). |
| [`@UpperCase`](#uppercase) | `String` | Checks if the String contains only uppercase letters. |


*Note:* 

*All the examples are using [project's lombok](https://projectlombok.org) annotations like `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, etc.*
*Those annotations are used make the examples more compact, but their use is optional.*

### `@After`

Check if the Date is after the given date value. 

The annotation supports a second property format that by default is "yyyy-MM-dd'T'HH:mm:ss.SSSZ".

#### Example

```java
@Data
class AfterBean {
    @After(value = "2018-01-01", format = "yyyy-MM-dd")
    private Date isAfter = new Date(1522399999911L); // Passes // Date = 2018-03-30
}
```

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


### `@Before`

Check if the Date is before the given date value. 

The annotation supports a second property format that by default is "yyyy-MM-dd'T'HH:mm:ss.SSSZ".

#### Example

```java
@Data
class BeforeBean {
    @Before(value = "2018-12-01", format = "yyyy-MM-dd")
    private Date isBefore = new Date(1522399999911L); // Passes // Date = 2018-03-30
}
```

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

### `@IsDate`

Checks if the given string is formatted as a date.

#### Example

```java
@Data
class IsDateBean {
    @IsDate("yyyy-MM-dd")
    private String isDate = "2018-12-01"; // Passes
}
```

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

### `@MinDigits`

Checks whether the annotated value is higher than or equal to the specified minimum.

#### Example

```java
@Data
class MinDigitsDoubleBean {
    @MinDigits(value = "10.5")
    private Double isOk = new Double(11.0); // Passes

    @MinDigits(value = "10.5")
    private Double isKo = new Double(10.0); // Do not Pass
}

```

#### Supported data types

`Double`

TODO Add support for more types


### `@MaxDigits`

Checks whether the annotated value is less than or equal to the specified maximum.

#### Example

```java
@Data
class MaxDigitsDoubleBean {
    @MaxDigits(value = "10.5")
    private Double isKo = new Double(11.0); // Do not Pass

    @MaxDigits(value = "10.5")
    private Double isOk = new Double(10.0); // Passes
}

```

#### Supported data types

`Double`

TODO Add support for more types

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

Check if the String can be parsed to a number. The annotations accepts the type of parsing you want to perform as an input parameter.

For example if you want to parse it `Integer`, @Parseable(TO_INT) should be used.

All the possible parsing strategies accepted are described in the enum `ParseableType`. It currently supports:

- `TO_SHORT` 
- `TO_INT`
- `TO_LONG`
- `TO_FLOAT`
- `TO_DOUBLE`

### `@Password`

Check if a `String` is a valid password - matching a set of constraints.


- `containsUpperCase() default true` - Needs to contain at least an Uppercase letter;
- `boolean containsLowerCase() default true` - Needs to contain at least a Lowercase letter;
- `boolean containsSpecialChar() default true` - Needs to contain at least one special character;
- `boolean containsDigits() default true` - Needs to contain at least one digit;
- `boolean allowSpace() default false` - Password can contain spaces;
- `int minSize() default 8` - The min size of the password;
- `int maxSize() default 32` - The maximum size of the password;

### `@OneOfChars`

Checks if the `Character` is contained in a given array (`char[]`) of values.

#### Example

In the following example we test if the field `aOrBOrC` is either `'a'`, `'b'` or `'c'`.

```java
@Data
class {
    @OneOfChars({'a', 'b', 'c'})
    private Character aOrBOrC;
}
```

### `@OneOfDoubles`

Check if the Double is contained in a given array (`double[]`) of values.

#### Example

In the following example we test if the field `value` is either `1.0` or `2.0`.
 
```java
@Data
class {
    @OneOfDoubles({1.0, 2.0})
    private Double value;
}
```

### `@OneOfIntegers`

Check if the Integer is contained in a given array (`int[]`) of values.

#### Example

In the following example we test if the field `value` is either `1` or `2`.

```java
@Data
class {
    @OneOfIntegers({1, 2})
    private Integer value;
}
```

### `@OneOfLongs`

Check if the Long is contained in a given array (`long[]`) of values.

### `@OneOfStrings`

Checks if the String is contained in a given array (`String[]`) of values.

#### Example

In the following example we check if the value returned by the `getValue()` getter is either `"A"`, `"B"` or `"C"`.

```java
class Test {
    @OneOfStrings({ "A" , "B", "C"})
    private String getValue() { return /***/ }
}
```

### `@StartsWith`

Checks if a String starts with the specified prefix(es).

The annotation supports a second property `ignoreCase` that by default is `false`.

Behavior (`ignoreCase==false`):

| Value | Prefix | Result |
| --- | --- | --- |
| `null` | "abc" | :x: Fails |
| `"abcdef"` | `"abc"` | :white_check_mark: Passes |
| `"ABCDEF"` | `"abc"` | :x: Fails |
| `"ABCDEF"` | `""` | :white_check_mark: Passes |

Behavior (`ignoreCase==true`):

| Value | Prefix | Result |
| --- | --- | --- |
| `null` | "abc" | :x: Fails |
| `"abcdef"` | `"abc"` | :white_check_mark: Passes |
| `"ABCDEF"` | `"abc"` | :white_check_mark: Passes |
| `"ABCDEF"` | `""` | :white_check_mark: Passes |


#### Example

```java
@Data
class Starters {
    private List< @StartsWith("1", "2") String> starts;
} 
```

### `@UpperCase`

Checks if the String contains only uppercase letters.

Behavior:

| Value | Result |
| --- | --- |
| `null` | :x: Fails |
| `""` | :x: Fails |
| `" "` | :x: Fails |
| `"ABC"` |  :white_check_mark: Passes |
| `"aBC"` | :x: Fails |
| `"A C"` | :x: Fails |
| `"1AB"` | :x: Fails |
| `"A-C"` | :x: Fails |

