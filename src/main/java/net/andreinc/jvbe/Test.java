package net.andreinc.jvbe;

import net.andreinc.jvbe.exp.JsAssert;

@JsAssert("_.expr === 'abc'")
public class Test {

//    @AllBlank
    @JsAssert("_[0] === 'a'")
    @JsAssert("_.length === 3")
    String expr = "abc";

    @JsAssert("_[1] === 'b'")
    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }
}

