package com.github.slfotg.giphy.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.slfotg.giphy.domain.GiphyUser;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@Transactional
@RunWith(SpringRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("/test_data/giphy_users.xml")
@SpringBootTest(classes = { TestConfig.class })
public class GiphyUserRepositoryTest {

    @Autowired
    GiphyUserRepository repo;

    @Test
    public void testCount() throws Exception {
        assertThat(repo.count(), equalTo(1L));
    }

    @Test
    public void testFindByUsername() throws Exception {
        GiphyUser user = repo.findByUsername("sam");
        assertThat(user.getUsername(), equalTo("sam"));
        assertThat(user.getId(), equalTo(1));
        assertThat(user.getPassword(), equalTo("password"));
    }

    @Test
    public void testSaveUser() throws Exception {
        GiphyUser user = new GiphyUser();
        user.setUsername("slfotg");
        user.setPassword("password");
        user = repo.save(user);
        assertThat(user.getId(), notNullValue(Integer.class));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveExistingUser() throws Exception {
        GiphyUser user = new GiphyUser();
        user.setUsername("sam");
        user.setPassword("password");
        user = repo.save(user);
    }

    @Test
    public void testFindUserFavorites() throws Exception {
        GiphyUser user = repo.findByUsername("sam");
        assertThat(user.getFavorites().size(), equalTo(10));
    }

    @Test
    public void testFindCategories() throws Exception {
        GiphyUser user = repo.findByUsername("sam");
        assertThat(user.getCategories().size(), equalTo(3));
    }
}
