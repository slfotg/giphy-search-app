package com.github.slfotg.giphy.service;

public interface GiphyUserService {

    void registerNewUser(String username, String password);

    boolean userExists(String username);
}
