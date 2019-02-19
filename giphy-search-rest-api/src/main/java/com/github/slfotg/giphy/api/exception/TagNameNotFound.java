package com.github.slfotg.giphy.api.exception;

public class TagNameNotFound extends MissingDataException {

    private static final long serialVersionUID = 1L;

    private final String username;
    private final String tagName;

    public TagNameNotFound(String username, String tagName) {
        super(String.format("%s tag not found for user %s", tagName, username));
        this.username = username;
        this.tagName = tagName;
    }

    public String getUsername() {
        return username;
    }

    public String getTagName() {
        return tagName;
    }
}
