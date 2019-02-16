package com.github.slfotg.giphy.api.config;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("giphy.api")
@Validated
public class GiphyConfigurationProperties {

    private final Logger logger = LoggerFactory.getLogger(GiphyConfigurationProperties.class);

    @NotNull
    @NotEmpty
    private String host;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{32}$")
    private String apiKey;

    @NotNull
    @NotEmpty
    private String searchEndpoint;

    @NotNull
    @NotEmpty
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
        logger.info("Setting apiKey to {}*******", apiKey.substring(0, 4));
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