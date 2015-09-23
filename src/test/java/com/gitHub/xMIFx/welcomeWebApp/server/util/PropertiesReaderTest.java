package com.gitHub.xMIFx.welcomeWebApp.server.util;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.WelcomeMessage;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Vlad on 14.09.2015.
 */
public class PropertiesReaderTest {

    @Test
    public void testSetStringMessageWithLocalizationEn() throws Exception {
        String expected = "Good morning";
        WelcomeMessage welcomeMessage = new WelcomeMessage();

        PropertiesReader.setStringMessageWithLocalization(welcomeMessage, "welcomeObj1", Locale.ENGLISH);
        String result = welcomeMessage.getHelloMessage();

        assertThat(result, is(expected));

    }

    @Test
    public void testSetStringMessageWithLocalizationRu() throws Exception {
        String expected = "Доброе утро";
        WelcomeMessage welcomeMessage = new WelcomeMessage();

        PropertiesReader.setStringMessageWithLocalization(welcomeMessage, "welcomeObj1", new Locale("ru"));
        String result = welcomeMessage.getHelloMessage();

        assertThat(result, is(expected));

    }

    @Test
    public void testSetStringMessageWithLocalizationIfNoTranslation() throws Exception {
        String expected = "Good morning";
        WelcomeMessage welcomeMessage = new WelcomeMessage();

        PropertiesReader.setStringMessageWithLocalization(welcomeMessage, "welcomeObj1", Locale.CHINA);
        String result = welcomeMessage.getHelloMessage();

        assertThat(result, is(expected));

    }

    @Test
    public void testInit() throws IOException {

        List<WelcomeMessage> expected = new ArrayList<>(3);
        WelcomeMessage welcomeMessage1 = new WelcomeMessage(LocalTime.of(6, 0), LocalTime.of(12, 0));
        welcomeMessage1.setHelloMessage("Good morning");
        WelcomeMessage welcomeMessage2 = new WelcomeMessage(LocalTime.of(12, 0), LocalTime.of(19, 0));
        welcomeMessage2.setHelloMessage("Good day");
        WelcomeMessage welcomeMessage3 = new WelcomeMessage(LocalTime.of(19, 0), LocalTime.of(6, 0));
        welcomeMessage3.setHelloMessage("Good evening");
        expected.add(welcomeMessage1);
        expected.add(welcomeMessage2);
        expected.add(welcomeMessage3);

        PropertiesReader prop = new PropertiesReader("projectTest.properties", Locale.ENGLISH);
        List<WelcomeMessage> result = prop.getWelcomeMessageList();

        assertThat(result, is(expected));

    }
    @Test(expected = NullPointerException.class)
    public void testInitFalseName() throws IOException {
        PropertiesReader prop = new PropertiesReader("projectTest1.properties", Locale.ENGLISH);
        Assert.fail("expected NullPointerException");
    }

    @Test
    public void testInitFalse() throws IOException {

        List<WelcomeMessage> expected = new ArrayList<>(3);
        WelcomeMessage welcomeMessage1 = new WelcomeMessage(LocalTime.of(1, 0), LocalTime.of(12, 0));
        welcomeMessage1.setHelloMessage("Good morning");
        WelcomeMessage welcomeMessage2 = new WelcomeMessage(LocalTime.of(12, 0), LocalTime.of(19, 0));
        welcomeMessage2.setHelloMessage("Good day");
        WelcomeMessage welcomeMessage3 = new WelcomeMessage(LocalTime.of(19, 0), LocalTime.of(6, 0));
        welcomeMessage3.setHelloMessage("God evening");
        expected.add(welcomeMessage1);
        expected.add(welcomeMessage2);
        expected.add(welcomeMessage3);

        PropertiesReader prop = new PropertiesReader("projectTest.properties", Locale.ENGLISH);
        List<WelcomeMessage> result = prop.getWelcomeMessageList();

        assertThat(result, not(expected));

    }
}