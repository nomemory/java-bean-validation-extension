# java-bean-validation-extension

A library that extends the [Java Bean Validation](http://beanvalidation.org) with additional @Annotations.

## Additional supported annotations

### `@JsAssert` 

Tests if a Java Script expression is validating the target (class level, field level, method level).

*Note: The implementation uses nashorn that ships by default with Java. After the first run, all the expressions are pre-compiled and cached for improved performance.*

#### Example(s)

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsAssert("_.prop1.length > 4 && _.prop2.length <= 3")
public class Bean01 {

    @JsAssert("_[0] === 'A'")
    private String prop1;
    private String prop2;
}
```

The above code validates for `new Bean01("Abcde", "abc")`, but is not validating for `new Bean01("Bbcde", "abc")` because `prop1`  starts with `'B'` instead of `'A'`.