package net.andreinc.jvbe.exp.validators;

/**
 * Enum of supported ScriptEngines for that can be used with jvbe
 */
public enum ExpEngine {

    GROOVY("groovy"),
    JAVASCRIPT("nashorn");

    private String engine;

    ExpEngine(String engine) {
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }
}
