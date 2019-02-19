package com.github.slfotg.giphy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.slfotg.giphy.domain.GifCategory;
import com.github.slfotg.giphy.domain.GiphyUser;

@Repository
public interface GifCategoryRepository extends JpaRepository<GifCategory, Integer> {

    Optional<GifCategory> findOneByGiphyUserAndCategoryName(GiphyUser giphyUser, String categoryName);
}
