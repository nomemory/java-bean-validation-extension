package net.andreinc.jbvext.annotations.exp.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.andreinc.jbvext.annotations.exp.JsAssert;
import net.andreinc.jbvext.utils.TimeActionResponse;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;
import org.graalvm.polyglot.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.*;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static javax.script.ScriptContext.ENGINE_SCOPE;
import static net.andreinc.jbvext.utils.TimeAction.recordTimeAndDo;

@NoArgsConstructor
@AllArgsConstructor
public class JsAssertValidator implements ConstraintValidator<JsAssert, Object> {

    private final Logger LOG = LoggerFactory.getLogger(JsAssertValidator.class.getName());

    // Acts as a caching mechanism to compile every expression found in the annotation
    protected static Map<String, Source> sources = new HashMap<>();

    protected Engine engine;
    protected Context context;
    protected JsAssert annotation;

    @Override
    public void initialize(JsAssert constraintAnnotation) {
        this.engine = Engine.create();
        this.annotation = constraintAnnotation;
        this.context = Context.newBuilder()
                                .allowAllAccess(true)
                                .engine(this.engine)
                              .build();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext validatorContext) {

        String attributeName = annotation.attributeName();
        String expression = annotation.value();

        Source source = sources.get(expression);

        if (null == source) {
            source = Source.create("js", expression);
            sources.put(expression, source);
        }

        context.getBindings("js")
               .putMember(attributeName, value);

        return context.eval(source).asBoolean();
    }
}
