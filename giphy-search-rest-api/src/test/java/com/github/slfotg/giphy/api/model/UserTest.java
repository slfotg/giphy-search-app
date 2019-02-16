package com.github.slfotg.giphy.api.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.slfotg.giphy.api.model.User;

public class UserTest {

    private User user;
    private ObjectMapper mapper;

    @Before
    public void initPagination() throws MalformedURLException {
        user = new User();
        user.setAvatarUrl(new URL("https://media1.giphy.com/avatars/election2016/XwYrZi5H87o6.gif"));
        user.setBannerUrl(new URL("https://media4.giphy.com/avatars/cheezburger/XkuejOhoGLE6.jpg"));
        user.setProfileUrl(new URL("https://giphy.com/cheezburger/"));
        user.setUsername("joecool4000");
        user.setDisplayName("JoeCool4000");
        user.setTwitter("@joecool4000");
        mapper = new ObjectMapper();
    }

    @Test
    public void testSerialization() throws Exception {
        String json = mapper.writeValueAsString(user);

        assertThat(json, containsString("avatar_url"));
        assertThat(json, containsString("banner_url"));
        assertThat(json, containsString("profile_url"));
        assertThat(json, containsString("username"));
        assertThat(json, containsString("display_name"));
        assertThat(json, containsString("twitter"));
    }

    @Test
    public void testDeserialization() throws Exception {
        Resource resource = new ClassPathResource("user.json");
        User deserializedUser = mapper.readValue(resource.getInputStream(), User.class);

        assertThat(deserializedUser.getAvatarUrl(), equalTo(user.getAvatarUrl()));
        assertThat(deserializedUser.getBannerUrl(), equalTo(user.getBannerUrl()));
        assertThat(deserializedUser.getProfileUrl(), equalTo(user.getProfileUrl()));
        assertThat(deserializedUser.getUsername(), equalTo(user.getUsername()));
        assertThat(deserializedUser.getDisplayName(), equalTo(user.getDisplayName()));
        assertThat(deserializedUser.getTwitter(), equalTo(user.getTwitter()));
    }
}
