package com.github.slfotg.giphy.api.service;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.slfotg.giphy.api.config.GiphyConfigurationProperties;
import com.github.slfotg.giphy.api.model.MpaaRating;
import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.SearchRequest;

@Service
class DefaultGiphyApiService implements GiphyApiService {

    @Autowired
    private GiphyConfigurationProperties giphyConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SearchResults search(SearchRequest request) {
        URI searchURI = generateSearchURI(request);
        return restTemplate.getForEntity(searchURI, SearchResults.class).getBody();
    }

    @Override
    public SearchResults trending() {
        URI trendingURI = generateTrendingURI();
        return restTemplate.getForEntity(trendingURI, SearchResults.class).getBody();
    }

    @Override
    public SearchResults gifById(String gifId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResults gifsById(Collection<String> gifIds) {
        // TODO Auto-generated method stub
        return null;
    }

    protected URI generateSearchURI(SearchRequest request) {
        // @formatter:off
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(giphyConfig.getHost())
                .path(giphyConfig.getSearchEndpoint())
                .queryParam("api_key", giphyConfig.getApiKey())
                .queryParam("q", request.getQuery())
                .queryParam("limit", request.getLimit())
                .queryParam("offset", request.getOffset())
                .queryParam("rating", MpaaRating.G)
                .queryParam("lang", "en").build().encode().toUri();
        // @formatter:on
    }

    protected URI generateTrendingURI() {
        // @formatter:off
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(giphyConfig.getHost())
                .path(giphyConfig.getTrendingEndpoint())
                .queryParam("api_key", giphyConfig.getApiKey())
                .queryParam("rating", MpaaRating.G)
                .build().encode().toUri();
        // @formatter:on
    }

}
