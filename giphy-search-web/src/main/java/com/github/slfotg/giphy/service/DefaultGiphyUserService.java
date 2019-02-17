package com.github.slfotg.giphy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.slfotg.giphy.domain.GiphyUser;
import com.github.slfotg.giphy.repository.GiphyUserRepository;

@Service
public class DefaultGiphyUserService implements GiphyUserService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private GiphyUserRepository userRepository;

    @Override
    public void registerNewUser(String username, String password) {
        GiphyUser user = new GiphyUser();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        userRepository.saveAndFlush(user);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

}
