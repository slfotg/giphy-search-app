package com.github.slfotg.giphy.api.service;

import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.SearchRequest;

public interface GiphyApiService {

    SearchResults search(SearchRequest request);
}
