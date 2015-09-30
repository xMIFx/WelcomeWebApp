package com.gitHub.xMIFx.welcomeWebApp.server.services;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.TestConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by bukatinvv on 16.09.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = TestConfiguration.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private SessionFactory factory;

    @Test
    public void testGetByLoginPassword() throws Exception {
        User expected = new User("login", "name");
        String password = "password";
        expected.installHashPassword(password);
        try (Session session = factory.openSession()) {
            session.save(expected);
        }

        User result = userService.getByLoginPassword(expected.getLogin(), password);

        assertThat(result, is(expected));

    }

}