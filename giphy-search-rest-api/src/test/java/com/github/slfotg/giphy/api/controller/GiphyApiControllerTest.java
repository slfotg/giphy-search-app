package com.github.slfotg.giphy.api.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.SearchRequest;
import com.github.slfotg.giphy.api.response.ErrorResponse;

// TODO - convert to unit test
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GiphyApiControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSearch() throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setQuery("sports");

        ResponseEntity<SearchResults> response = restTemplate.postForEntity("/api/search", searchRequest,
                SearchResults.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void testSearchWithNoQuery() throws Exception {
        SearchRequest searchRequest = new SearchRequest();

        ResponseEntity<ErrorResponse> response = restTemplate.postForEntity("/api/search", searchRequest,
                ErrorResponse.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void testTrending() throws Exception {
        ResponseEntity<SearchResults> response = restTemplate.getForEntity("/api/trending", SearchResults.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
