package com.github.slfotg.giphy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.github.slfotg.giphy.api.config.GiphyConfigurationProperties;

@EnableZuulProxy
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(GiphyConfigurationProperties.class)
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
