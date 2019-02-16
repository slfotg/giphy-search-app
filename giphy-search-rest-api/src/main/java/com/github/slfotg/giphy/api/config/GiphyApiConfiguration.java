package com.github.slfotg.giphy.api.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(GiphyConfigurationProperties.class)
public class GiphyApiConfiguration {

}