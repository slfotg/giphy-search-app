package com.github.slfotg.giphy.repository;

import static org.hamcrest.CoreMatchers.equalTo;
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
        Optional<GiphyUser> user = userRepo.findByUsername("sam");
        assertTrue(user.isPresent());

        Collection<GiphyUserFavorites> favorites = favoritesRepo.findByIdGiphyUser(user.get());
        assertThat(favorites.size(), equalTo(10));
    }

    @Test
    public void testFindById() throws Exception {
        final String imageId = "aksdjakga;lja06";
        Optional<GiphyUser> user = userRepo.findByUsername("sam");
        assertTrue(user.isPresent());

        GiphyUserFavoritesId id = new GiphyUserFavoritesId();
        id.setGiphyUser(user.get());
        id.setImageId(imageId);

        Optional<GiphyUserFavorites> fav = favoritesRepo.findById(id);
        assertTrue(fav.isPresent());
        assertThat(fav.get().getGiphyUser().getId(), equalTo(user.get().getId()));
        assertThat(fav.get().getImageId(), equalTo(imageId));
    }

    @Test
    public void testDelete() throws Exception {
        favoritesRepo.deleteAll();

        assertThat(favoritesRepo.count(), equalTo(0L));
        assertThat(userRepo.count(), equalTo(2L));
    }
}
