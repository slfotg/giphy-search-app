package com.github.slfotg.giphy.api.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MetadataTest {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testDeserialization() throws Exception {
        Resource resource = new ClassPathResource("meta.json");
        Metadata meta = mapper.readValue(resource.getInputStream(), Metadata.class);

        assertThat(meta.getMsg(), equalTo("OK"));
        assertThat(meta.getResponseId(), equalTo("57eea03c72381f86e05c35d2"));
        assertThat(meta.getStatus(), equalTo(200));
    }
}
