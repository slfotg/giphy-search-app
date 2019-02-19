package com.github.slfotg.giphy.api.service;

import java.net.URI;
import java.util.Collection;

import com.github.slfotg.giphy.api.request.SearchRequest;

public interface GiphyUriGenerator {

    URI generateSearchURI(SearchRequest request);

    URI generateTrendingURI();

    URI generateRandomURI();

    URI generateGifByIdURI(String gifId);

    URI generateGifsByIdURI(Collection<String> gifIds);
}
