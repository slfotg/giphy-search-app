package com.github.slfotg.giphy.api.response;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<ErrorMessage> errors = new LinkedList<>();

    public void addError(ErrorMessage error) {
        errors.add(error);
    }

    public List<ErrorMessage> getErrors() {
        return errors;
    }

    public static class ErrorMessage {
        private String objectName;
        private String message;

        public ErrorMessage(String objectName, String message) {
            this.objectName = objectName;
            this.message = message;
        }

        public String getObjectName() {
            return objectName;
        }

        public String getMessage() {
            return message;
        }
    }
}
