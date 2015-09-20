package com.gitHub.xMIFx.welcomeWebApp.server.domain;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Vlad on 14.09.2015.
 */
public class WelcomeMessageTest {
    @Test
    public void testIsTimeBetweenFromToYesLastBoundary() throws Exception {
        boolean expected = true;
        LocalTime localTime = LocalTime.of(22, 59, 59);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(6, 0), LocalTime.of(23, 0));
        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);

        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToYesFirstBoundary() throws Exception {
        boolean expected = true;
        LocalTime localTime = LocalTime.of(6, 0);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(6, 0), LocalTime.of(23, 0));

        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);

        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToYes() throws Exception {
        boolean expected = true;
        LocalTime localTime = LocalTime.of(15, 0);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(6, 0), LocalTime.of(23, 0));

        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);

        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToNoAfterLastBoundary() throws Exception {
        boolean expected = false;
        LocalTime localTime = LocalTime.of(23, 1);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(6, 0), LocalTime.of(23, 0));

        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);
        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToNoBeforeFirstBoundary() throws Exception {
        boolean expected = false;
        LocalTime localTime = LocalTime.of(05, 59);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(6, 0), LocalTime.of(23, 0));

        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);
        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToYesLastBoundaryMidnightBreak() throws Exception {
        boolean expected = true;
        LocalTime localTime = LocalTime.of(9, 59, 59);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(19, 0), LocalTime.of(10, 0));
        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);

        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToYesFirstBoundaryMidnightBreak() throws Exception {
        boolean expected = true;
        LocalTime localTime = LocalTime.of(19, 0);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(19, 0), LocalTime.of(10, 0));
        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);

        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToYesBeforeMidnightBreak() throws Exception {
        boolean expected = true;
        LocalTime localTime = LocalTime.of(20, 0);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(19, 0), LocalTime.of(10, 0));
        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);

        assertThat(result, is(expected));
    }

    @Test
    public void testIsTimeBetweenFromToYesAfterMidnightBreak() throws Exception {
        boolean expected = true;
        LocalTime localTime = LocalTime.of(0, 1);
        WelcomeMessage welcomeMessage = new WelcomeMessage(LocalTime.of(19, 0), LocalTime.of(10, 0));
        boolean result = welcomeMessage.isTimeBetweenFromTo(localTime);

        assertThat(result, is(expected));
    }
}