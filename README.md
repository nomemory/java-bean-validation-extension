# java-bean-validation-extension

A library that extends the [Java Bean Validation](http://beanvalidation.org) with additional @Annotations.

For the moment:
- `README.md` is not complete;
- The library has no test coverage;
- More @Annotations will be added in the future
(basically everything is work in progress)

## Additional supported annotations

### `@JsAssert` 

Tests if a Java Script expression is validating the target (class level, field level, method level). By default the validated value is can be accessed by the java script using `'_'`. 

*Note: The Java Script implementation uses nashorn that ships by default with Java. After the first run, all the expressions are pre-compiled and cached for improved performance.*

#### Example(s)

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsAssert("_.prop1.length > 4 && _.prop2.length <= 3") /* class level 'this' becomes '_' */
public class Bean01 {

    @JsAssert("_[0] === 'A'") /* field level - 'prop1' becomes '_' */
    private String prop1;
    private String prop2;
}
```
The example is performing two type of validations:
- Class level validation: validates if the `prop1` and `prop2` properties are having correct lengths (in the same time);
- Field level validation (getter needs to exist): validates if `prop1` always starts with the character `'A'`.

So the above code validates for `new Bean01("Abcde", "abc")`, but is not validating for `new Bean01("Bbcde", "abc")` because `prop1`  starts with `'B'` instead of `'A'`.
