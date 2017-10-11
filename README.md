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