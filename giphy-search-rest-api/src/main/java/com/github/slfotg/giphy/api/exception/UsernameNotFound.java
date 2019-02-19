package com.github.slfotg.giphy.api.exception;

public class UsernameNotFound extends MissingDataException {

    private static final long serialVersionUID = 1L;

    private final String username;

    public UsernameNotFound(String username) {
        super(String.format("%s not found", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
