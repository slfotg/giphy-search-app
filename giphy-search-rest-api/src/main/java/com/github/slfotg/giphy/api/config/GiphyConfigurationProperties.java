package com.github.slfotg.giphy.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("giphy.api")
public class GiphyConfigurationProperties {

    private final Logger logger = LoggerFactory.getLogger(GiphyConfigurationProperties.class);

    private String host;
    private String apiKey;
    private String searchEndpoint;
    private String trendingEndpoint;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        logger.trace("Setting host to {}", host);
        this.host = host;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        logger.info("Setting apiKey to {}", apiKey);
        this.apiKey = apiKey;
    }

    public String getSearchEndpoint() {
        return searchEndpoint;
    }

    public void setSearchEndpoint(String searchEndpoint) {
        this.searchEndpoint = searchEndpoint;
    }

    public String getTrendingEndpoint() {
        return trendingEndpoint;
    }

    public void setTrendingEndpoint(String trendingEndpoint) {
        this.trendingEndpoint = trendingEndpoint;
    }

}