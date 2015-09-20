package com.gitHub.xMIFx.welcomeWebApp.server.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by bukatinvv on 16.09.2015.
 */
public class CryptographerTest {

    @Test
    public void testGetCryptStringIsWorking() throws Exception {
        String expected = "somestring";

        String result = Cryptographer.getCryptString(expected);

        assertThat(result, not(expected));
    }

    @Test
    public void testGetCryptStringSameStringSameHash() throws Exception {
        String string = "somestring";
        String expected = Cryptographer.getCryptString(string);

        String result = Cryptographer.getCryptString(string);

        assertThat(result, is(expected));
    }

    @Test
    public void testGetCryptStringDifferentStringDifferentHash() throws Exception {
        String string1 = "somestring";
        String string2 = "string";
        String expected = Cryptographer.getCryptString(string1);

        String result = Cryptographer.getCryptString(string2);

        assertThat(result, not(expected));
    }
}