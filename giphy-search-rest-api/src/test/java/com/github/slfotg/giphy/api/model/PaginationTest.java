package com.github.slfotg.giphy.api.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.slfotg.giphy.api.model.Pagination;

public class PaginationTest {

    private Pagination pagination;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void initPagination() {
        pagination = new Pagination();
        pagination.setCount(5);
        pagination.setOffset(54);
        pagination.setTotalCount(1023);
    }

    @Test
    public void testSerialization() throws Exception {
        String json = mapper.writeValueAsString(pagination);

        assertThat(json, containsString("offset"));
        assertThat(json, containsString("total_count"));
        assertThat(json, containsString("count"));
    }

    @Test
    public void testDeserialization() throws Exception {
        Resource resource = new ClassPathResource("pagination.json");
        Pagination deserializedPagination = mapper.readValue(resource.getInputStream(), Pagination.class);

        assertThat(deserializedPagination.getCount(), equalTo(pagination.getCount()));
        assertThat(deserializedPagination.getOffset(), equalTo(pagination.getOffset()));
        assertThat(deserializedPagination.getTotalCount(), equalTo(pagination.getTotalCount()));
    }
}
