package net.andreinc.jbve.utils;

import lombok.Getter;
import lombok.Setter;

public class BeanValidationException extends RuntimeException {

    public BeanValidationException(String message) {
        super(message);
        this.message = message;
    }

    public BeanValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    @Getter
    @Setter
    private String message;
}
