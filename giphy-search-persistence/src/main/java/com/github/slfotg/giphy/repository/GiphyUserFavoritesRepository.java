package com.github.slfotg.giphy.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.slfotg.giphy.domain.GiphyUser;
import com.github.slfotg.giphy.domain.GiphyUserFavorites;
import com.github.slfotg.giphy.domain.GiphyUserFavorites.GiphyUserFavoritesId;

@Repository
public interface GiphyUserFavoritesRepository extends JpaRepository<GiphyUserFavorites, GiphyUserFavoritesId> {

    Collection<GiphyUserFavorites> findByIdGiphyUser(GiphyUser user);
}
