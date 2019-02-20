package com.github.slfotg.giphy.api.model;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GifByIdResultsTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testDeserialization() throws Exception {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Resource resource = new ClassPathResource("imageByIdResponse.json");
        mapper.readValue(resource.getInputStream(), GifByIdResults.class);
    }
}
