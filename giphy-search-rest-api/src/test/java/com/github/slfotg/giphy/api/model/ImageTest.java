package com.github.slfotg.giphy.api.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ImageTest {

    private ObjectMapper mapper;

    @Before
    public void initPagination() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testDeserialization() throws Exception {
        Resource resource = new ClassPathResource("image.json");
        Image deserializedImage = mapper.readValue(resource.getInputStream(), Image.class);

        assertThat(deserializedImage.getUrl(),
                equalTo(new URL("https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.gif")));
        assertThat(deserializedImage.getWidth(), equalTo("320"));
        assertThat(deserializedImage.getHeight(), equalTo("200"));
        assertThat(deserializedImage.getSize(), equalTo("32381"));
        assertThat(deserializedImage.getFrames(), equalTo("15"));
        assertThat(deserializedImage.getMp4(),
                equalTo(new URL("https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.mp4")));
        assertThat(deserializedImage.getMp4Size(), equalTo("25123"));
        assertThat(deserializedImage.getWebp(),
                equalTo(new URL("https://media1.giphy.com/media/cZ7rmKfFYOvYI/giphy.webp")));
        assertThat(deserializedImage.getWebpSize(), equalTo("12321"));
    }
}
