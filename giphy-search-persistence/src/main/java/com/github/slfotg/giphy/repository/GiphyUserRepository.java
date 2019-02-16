package com.github.slfotg.giphy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.slfotg.giphy.domain.GiphyUser;

@Repository
public interface GiphyUserRepository extends JpaRepository<GiphyUser, Long> {

    GiphyUser findByUsername(String username);

}
