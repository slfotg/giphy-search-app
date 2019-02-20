package com.github.slfotg.giphy.api.service;

import java.net.URI;
import java.util.Collection;

import com.github.slfotg.giphy.api.request.SearchRequest;
import com.github.slfotg.giphy.api.request.TrendingRequest;

public interface GiphyUriGenerator {

    URI generateSearchURI(SearchRequest request);

    URI generateTrendingURI(TrendingRequest request);

    URI generateRandomURI();

    URI generateGifByIdURI(String gifId);

    URI generateGifsByIdURI(Collection<String> gifIds);
}
