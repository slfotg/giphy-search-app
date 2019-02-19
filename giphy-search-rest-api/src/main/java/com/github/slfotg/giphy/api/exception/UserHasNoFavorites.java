package com.github.slfotg.giphy.api.exception;

public class UserHasNoFavorites extends MissingDataException {

    private static final long serialVersionUID = 1L;
    
    private final String username;

    public UserHasNoFavorites(String username) {
        super(String.format("%s has no favorites", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
