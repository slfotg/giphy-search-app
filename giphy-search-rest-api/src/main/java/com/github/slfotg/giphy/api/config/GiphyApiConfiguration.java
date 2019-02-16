package com.github.slfotg.giphy.api.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.slfotg.giphy.api.exception.GiphyResponseError;

@Configuration
@EnableConfigurationProperties(GiphyConfigurationProperties.class)
public class GiphyApiConfiguration {

    /**
     * Creates the RestTemplate used to interact with the Giphy API
     * 
     * @param errorHandler a custom ResponseErrorHandler to determine if a response
     *                     is an error or not
     * @return the RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(final ResponseErrorHandler errorHandler) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(errorHandler);
        return restTemplate;
    }

    /**
     * Custom ResponseErrorHandler to determine if a response is an error or not
     * 
     * @param validStatuses a set of HttpStatus codes that are consider ok
     * @return the ResponseErrorHandler
     */
    @Bean
    public ResponseErrorHandler errorHandler(final Set<HttpStatus> validStatuses) {
        return new ResponseErrorHandler() {

            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return !validStatuses.contains(response.getStatusCode());
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                throw new GiphyResponseError();
            }

        };
    }

    /**
     * An ObjectMapper used to serialize/deserialize JSON objects
     * 
     * @return the ObjectMapper
     */
    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }

    /**
     * A Set of HttpStatus codes that can still be converted to a SearchResults
     * object
     * 
     * @return the HttpStatus codes
     */
    @Bean
    public Set<HttpStatus> validStatuses() {
        return new HashSet<>(Arrays.asList(HttpStatus.OK, HttpStatus.BAD_REQUEST, HttpStatus.NOT_FOUND));
    }

}