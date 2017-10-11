package net.andreinc.jvbe.exp.validators;

import net.andreinc.jvbe.utils.TimeAction;
import net.andreinc.jvbe.utils.TimeActionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.*;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import static javax.script.ScriptContext.ENGINE_SCOPE;

public abstract class ExpValidator <T extends Annotation> implements ConstraintValidator<T, Object> {

    private final Logger LOG = LoggerFactory.getLogger(ExpValidator.class.getName());

    // Acts as a caching mechanism to compile every expression found in the annotation
    protected static Map<String, ExpCompiled> cachedExpressions = new HashMap<>();

    protected ExpEngine engineType;
    protected ScriptEngine engine;
    protected ScriptContext currentContext;
    protected T annotation;

    @Override
    public void initialize(T constraintAnnotation) {
        this.engine = new ScriptEngineManager().getEngineByName(engineType.getEngine());
        if (null == engine) {
            throw new IllegalStateException("Cannot found the following scripting engine: '" +  engineType.getEngine() +"'. Do the correct .jar files exist in the classpath ?");
        }
        this.currentContext = engine.getContext();
        this.annotation = constraintAnnotation;
    }

    public boolean isValid(String attributeName, Object value, String expression, ConstraintValidatorContext validatorContext) {

        ExpCompiled expCompiled = cachedExpressions
                                        .get(expression);

        if (null == expCompiled) {
            TimeActionResponse<CompiledScript> ret = TimeAction.recordTimeAndDo(() -> {
                try {
                    return ((Compilable) engine).compile(expression);
                } catch (ScriptException e) {
                    throw new IllegalArgumentException("Expression: ```" + expression + "``` is invalid. Pre-compilation failed.", e); }
                }
            );
            LOG.info("Script expression \"{}\" compiled in {} ms.", expression, ret.getTime());
            expCompiled = new ExpCompiled(ret.getResponse(), engineType);
            cachedExpressions.put(expression, expCompiled);
        }

        // The value is bind to engine context with the name 'value'
        currentContext
                .getBindings(ENGINE_SCOPE)
                .put(attributeName, value);

        try {
            // Evaluating the boolean expression included in the annotation.
            // Expression is validating the value.
            Object result = expCompiled
                                .getCompiledScript()
                                .eval(currentContext);

            if (result instanceof Boolean) {
                return (Boolean) result;
            }

            throw new IllegalArgumentException("Expression: ```" + expression + "``` is not a boolean expression.");

        } catch (ScriptException e) {
            throw new IllegalArgumentException("Expression: ```" + expression + "``` failed to eval.", e);
        }
    }
}
