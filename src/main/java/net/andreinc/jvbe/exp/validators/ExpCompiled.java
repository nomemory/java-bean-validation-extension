package net.andreinc.jvbe.exp.validators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.script.CompiledScript;

/**
 * Class the models the associations between the:
 * - Compiled script
 * - Engine type used to compile the script
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpCompiled {

    private CompiledScript compiledScript;
    private ExpEngine engineType;
}
