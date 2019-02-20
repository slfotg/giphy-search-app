package com.github.slfotg.giphy.api.service;

import java.util.Collection;
import java.util.List;

import com.github.slfotg.giphy.api.exception.MissingDataException;
import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.SearchRequest;
import com.github.slfotg.giphy.api.request.TrendingRequest;

public interface GiphyApiService {

    SearchResults search(SearchRequest request);

    SearchResults trending(TrendingRequest request);

    SearchResults random();

    SearchResults gifById(String gifId);

    SearchResults gifsById(Collection<String> gifIds);

    void saveImageToFavorites(String username, String gifId) throws MissingDataException;

    void saveImagesToFavorites(String username, Collection<String> gifIds) throws MissingDataException;

    void saveImagesToTag(String username, String tag, Collection<String> gifIds) throws MissingDataException;

    SearchResults getFavorites(String username) throws MissingDataException;

    SearchResults getTaggedImages(String username, String tag) throws MissingDataException;

    List<String> getUserTags(String username) throws MissingDataException;
}
