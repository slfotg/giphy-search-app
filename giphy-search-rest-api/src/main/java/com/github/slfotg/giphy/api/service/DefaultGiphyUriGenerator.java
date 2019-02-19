package com.github.slfotg.giphy.api.service;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.slfotg.giphy.api.config.GiphyConfigurationProperties;
import com.github.slfotg.giphy.api.model.MpaaRating;
import com.github.slfotg.giphy.api.request.SearchRequest;

@Service
public class DefaultGiphyUriGenerator implements GiphyUriGenerator {

    protected static final String SCHEME = "https";
    protected static final String API_KEY_PARAM = "api_key";
    protected static final String QUERY_PARAM = "q";
    protected static final String LIMIT_PARAM = "limit";
    protected static final String OFFSET_PARAM = "offset";
    protected static final String RATING_PARAM = "rating";
    protected static final String GIF_ID_PARAM = "{gif_id}";
    protected static final String IDS_PARAM = "ids";

    @Autowired
    private GiphyConfigurationProperties giphyConfig;

    @Override
    public URI generateSearchURI(SearchRequest request) {
        // @formatter:off
        return defaultBuilder()
                .path(giphyConfig.getSearchEndpoint())
                .queryParam(QUERY_PARAM, request.getQuery())
                .queryParam(LIMIT_PARAM, request.getLimit())
                .queryParam(OFFSET_PARAM, request.getOffset())
                .queryParam(RATING_PARAM, MpaaRating.G)
                .build().encode().toUri();
        // @formatter:on
    }

    @Override
    public URI generateTrendingURI() {
        // @formatter:off
        return defaultBuilder()
                .path(giphyConfig.getTrendingEndpoint())
                .queryParam(RATING_PARAM, MpaaRating.G)
                .build().encode().toUri();
        // @formatter:on
    }

    @Override
    public URI generateRandomURI() {
        // @formatter:off
        return defaultBuilder()
                .path(giphyConfig.getTrendingEndpoint())
                .queryParam(RATING_PARAM, MpaaRating.G)
                .build().encode().toUri();
        // @formatter:on
    }

    @Override
    public URI generateGifByIdURI(String gifId) {
        // @formatter:off
        return defaultBuilder()
                .path(giphyConfig.getGifByIdEndpoint().replace(GIF_ID_PARAM, gifId))
                .build().encode().toUri();
        // @formatter:on
    }

    @Override
    public URI generateGifsByIdURI(Collection<String> gifIds) {
     // @formatter:off
        return defaultBuilder()
                .path(giphyConfig.getGifsByIdEndpoint())
                .queryParam(IDS_PARAM, gifIds)
                .build().encode().toUri();
        // @formatter:on
    }

    protected UriComponentsBuilder defaultBuilder() {
        // @formatter:off
        return UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(giphyConfig.getHost())
                .queryParam(API_KEY_PARAM, giphyConfig.getApiKey());
        // @formatter:on
    }
}
