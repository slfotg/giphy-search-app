package com.github.slfotg.giphy.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.slfotg.giphy.domain.GiphyUser;
import com.github.slfotg.giphy.domain.GiphyUserFavorites;
import com.github.slfotg.giphy.domain.GiphyUserFavorites.GiphyUserFavoritesId;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@Transactional
@RunWith(SpringRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("/test_data/giphy_users.xml")
@SpringBootTest(classes = { TestConfig.class })
public class GiphyUserFavoritesRepositoryTest {

    @Autowired
    GiphyUserRepository userRepo;

    @Autowired
    GiphyUserFavoritesRepository favoritesRepo;

    @Test
    public void testFindByGiphyUser() throws Exception {
        GiphyUser user = userRepo.findByUsername("sam");
        assertThat(user, notNullValue());

        Collection<GiphyUserFavorites> favorites = favoritesRepo.findByIdGiphyUser(user);
        assertThat(favorites.size(), equalTo(10));
    }

    @Test
    public void testFindById() throws Exception {
        final String imageId = "aksdjakga;lja06";
        GiphyUser user = userRepo.findByUsername("sam");
        assertThat(user, notNullValue());

        GiphyUserFavoritesId id = new GiphyUserFavoritesId();
        id.setGiphyUser(user);
        id.setImageId(imageId);

        Optional<GiphyUserFavorites> fav = favoritesRepo.findById(id);
        assertTrue(fav.isPresent());
        assertThat(fav.get().getGiphyUser().getId(), equalTo(user.getId()));
        assertThat(fav.get().getImageId(), equalTo(imageId));
    }
}
