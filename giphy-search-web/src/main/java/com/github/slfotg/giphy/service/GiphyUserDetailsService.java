package com.github.slfotg.giphy.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.slfotg.giphy.domain.GiphyUser;
import com.github.slfotg.giphy.repository.GiphyUserRepository;

@Service
public class GiphyUserDetailsService implements UserDetailsService {

    @Autowired
    private GiphyUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<GiphyUser> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new GiphyUserDetails(user.get());
    }

    public static class GiphyUserDetails implements UserDetails {

        private static final long serialVersionUID = 1L;

        private GiphyUser user;

        public GiphyUserDetails(GiphyUser user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Arrays.<GrantedAuthority>asList(new SimpleGrantedAuthority("user"));
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }

}
