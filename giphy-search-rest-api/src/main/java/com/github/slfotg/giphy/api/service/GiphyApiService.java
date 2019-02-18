package com.github.slfotg.giphy.api.service;

import java.util.Collection;

import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.SearchRequest;

public interface GiphyApiService {

    SearchResults search(SearchRequest request);

    SearchResults trending();

    SearchResults gifById(String gifId);

    SearchResults gifsById(Collection<String> gifIds);
}
