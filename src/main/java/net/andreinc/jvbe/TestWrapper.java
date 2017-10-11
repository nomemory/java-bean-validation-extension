package net.andreinc.jvbe;

import net.andreinc.jvbe.exp.JsAssert;

import javax.validation.Valid;

public class TestWrapper {

    //@JsExp("value.expr === 'abc'")
    @Valid
    @JsAssert("_.expr === 'abc'")
    private Test test;

    private String alaBala;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getAlaBala() {
        return alaBala;
    }

    public void setAlaBala(String alaBala) {
        this.alaBala = alaBala;
    }
}
