package com.github.slfotg.giphy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.slfotg.giphy.domain.GiphyUser;

@Repository
public interface GiphyUserRepository extends JpaRepository<GiphyUser, Integer> {

    Optional<GiphyUser> findByUsername(String username);

    void deleteByUsername(String username);

}
