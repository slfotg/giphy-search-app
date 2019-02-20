package com.github.slfotg.giphy.api.service;

import java.util.Collection;

import com.github.slfotg.giphy.api.exception.MissingDataException;

public interface GiphyApiService {

    void saveImageToFavorites(String username, String gifId) throws MissingDataException;

    void saveImagesToFavorites(String username, Collection<String> gifIds) throws MissingDataException;

    void saveImagesToTag(String username, String tag, Collection<String> gifIds) throws MissingDataException;

    Collection<String> getFavorites(String username) throws MissingDataException;

    String createTag(String username, String tagName) throws MissingDataException;

    Collection<String> getTaggedImages(String username, String tag) throws MissingDataException;

    Collection<String> getUserTags(String username) throws MissingDataException;
}
