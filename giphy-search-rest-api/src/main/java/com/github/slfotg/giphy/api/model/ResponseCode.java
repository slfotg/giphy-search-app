package com.github.slfotg.giphy.api.model;

public enum ResponseCode {

    OK(200), BAD_REQUEST(400), FORBIDDEN(403), NOT_FOUND(404), TOO_MANY_REQUESTS(429);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
