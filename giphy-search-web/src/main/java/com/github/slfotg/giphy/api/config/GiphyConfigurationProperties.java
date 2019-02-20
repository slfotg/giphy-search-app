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
    @Pattern(regexp = "^[a-zA-Z0-9]{32}$")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        if (logger.isInfoEnabled()) {
            logger.info("Setting apiKey to {}*******", apiKey.substring(0, 4));
        }
        this.apiKey = apiKey;
    }

}