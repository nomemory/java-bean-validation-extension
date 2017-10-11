package net.andreinc.jvbe.exp.validators;

import javax.script.CompiledScript;
import java.util.Objects;

/**
 * Class the models the associations between the:
 * - Compiled script
 * - Engine type used to compile the script
 */
public class ExpCompiled {

    private CompiledScript compiledScript;
    private ExpEngine engineType;

    public ExpCompiled(CompiledScript compiledScript, ExpEngine engineType) {
        this.compiledScript = compiledScript;
        this.engineType = engineType;
    }

    public CompiledScript getCompiledScript() {
        return compiledScript;
    }

    public ExpEngine getEngineType() {
        return engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpCompiled)) return false;
        ExpCompiled that = (ExpCompiled) o;
        return Objects.equals(compiledScript, that.compiledScript) &&
                engineType == that.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compiledScript, engineType);
    }
}
