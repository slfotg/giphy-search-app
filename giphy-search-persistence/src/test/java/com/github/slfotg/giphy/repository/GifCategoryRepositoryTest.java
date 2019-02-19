package com.github.slfotg.giphy.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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

import com.github.slfotg.giphy.domain.GifCategory;
import com.github.slfotg.giphy.domain.GiphyUser;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@Transactional
@RunWith(SpringRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("/test_data/giphy_users.xml")
@SpringBootTest(classes = { TestConfig.class })
public class GifCategoryRepositoryTest {

    @Autowired
    GifCategoryRepository repo;

    @Autowired
    GiphyUserRepository userRepo;

    @Test
    public void testCount() {
        assertThat(repo.count(), equalTo(3L));
    }

    @Test
    public void testSave() {
        final String newTag = "new tag";
        Optional<GiphyUser> user = userRepo.findById(1);
        assertTrue(user.isPresent());

        GifCategory category = new GifCategory(user.get(), newTag);
        category = repo.save(category);

        assertThat(repo.count(), equalTo(4L));
        Optional<GifCategory> newCategory = repo.findOneByGiphyUserAndCategoryName(user.get(), newTag);
        assertTrue(newCategory.isPresent());

        assertThat(newCategory.get(), equalTo(category));
    }

    @Test
    public void testFindOneByGiphyUserAndCategoryName() {
        Optional<GiphyUser> user = userRepo.findById(1);
        assertTrue(user.isPresent());

        Optional<GifCategory> category = repo.findOneByGiphyUserAndCategoryName(user.get(), "funny");
        assertTrue(category.isPresent());
        assertThat(category.get().getCategoryName(), equalTo("funny"));
        assertThat(category.get().getGiphyUser(), equalTo(user.get()));
        assertThat(category.get().getId(), equalTo(1));
    }
}
