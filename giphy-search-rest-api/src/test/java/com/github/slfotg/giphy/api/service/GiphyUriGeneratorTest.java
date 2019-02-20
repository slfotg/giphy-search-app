package com.github.slfotg.giphy.api.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.slfotg.giphy.api.config.GiphyConfigurationProperties;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { DefaultGiphyUriGenerator.class })
public class GiphyUriGeneratorTest {
    
    private static final String API_KEY = "myGiphyApiKey";
    private static final String HOST = "api.giphy.com";
    private static final String GIF_BY_ID_ENDPOINT = "/v1/gifs/{gif_id}";

    @Autowired
    GiphyUriGenerator uriGenerator;

    @MockBean
    GiphyConfigurationProperties properties;

    @Before
    public void init() {
        Mockito.when(properties.getApiKey()).thenReturn(API_KEY);
        Mockito.when(properties.getHost()).thenReturn(HOST);
        Mockito.when(properties.getGifByIdEndpoint()).thenReturn(GIF_BY_ID_ENDPOINT);
    }

    @Test
    public void testGenerateGifByIdURI() throws Exception {
        final String gifId = "ajaja0f9j2";
        URI uri = uriGenerator.generateGifByIdURI(gifId);
        URI expected = new URI(String.format("https://%s/v1/gifs/%s?api_key=%s", HOST, gifId, API_KEY));
        assertThat(uri, equalTo(expected));
    }
}
