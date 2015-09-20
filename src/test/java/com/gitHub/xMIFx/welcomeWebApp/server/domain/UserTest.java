package com.gitHub.xMIFx.welcomeWebApp.server.domain;

import com.gitHub.xMIFx.welcomeWebApp.server.util.Cryptographer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by bukatinvv on 16.09.2015.
 */
public class UserTest {

    @Test
    public void testInstallHashPasswordHashWithPass() throws Exception {
        String expected = "password";
        User user = new User();

        user.installHashPassword(expected);

        String result = user.getPassword();

        assertThat(result, not(expected));
    }

    @Test
    public void testInstallHashPasswordHash() throws Exception {
        String password = "password";
        String expected = Cryptographer.getCryptString(password);
        User user = new User();

        user.installHashPassword(password);

        String result = user.getPassword();

        assertThat(result, is(expected));
    }

    @Test
    public void testInstallHashPasswordHashNotEqualsWithDifferentPass() throws Exception {
        String password1 = "password";
        String password2 = "pasword";
        User user1 = new User();
        User user2 = new User();

        user1.installHashPassword(password1);
        user2.installHashPassword(password2);
        String expected = user1.getPassword();
        String result = user2.getPassword();

        assertThat(result, not(expected));
    }
}