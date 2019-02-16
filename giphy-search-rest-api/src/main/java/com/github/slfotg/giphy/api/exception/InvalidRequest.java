package com.github.slfotg.giphy.api.exception;

import org.springframework.validation.Errors;

public class InvalidRequest extends Exception {

    private static final long serialVersionUID = 1L;

    private final Errors errors;

    public InvalidRequest(Errors errors) {
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

}
