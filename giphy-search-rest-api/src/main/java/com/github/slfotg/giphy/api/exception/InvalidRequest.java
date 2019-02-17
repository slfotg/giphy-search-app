package com.github.slfotg.giphy.api.exception;

import org.springframework.validation.Errors;

import com.github.slfotg.giphy.api.response.ErrorResponse;
import com.github.slfotg.giphy.api.response.ErrorResponse.ErrorMessage;

public class InvalidRequest extends Exception {

    private static final long serialVersionUID = 1L;

    private final ErrorResponse errorResponse;

    public InvalidRequest(Errors errors) {
        errorResponse = new ErrorResponse();
        errors.getAllErrors().forEach(
                error -> errorResponse.addError(new ErrorMessage(error.getObjectName(), error.getDefaultMessage())));
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

}
