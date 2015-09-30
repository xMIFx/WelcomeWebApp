package com.gitHub.xMIFx.welcomeWebApp.server.util;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by Bukatin Vlad on 14.09.2015.
 */
public class PropertiesReader {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);

    private final String NAME_PROJECT_CONFIG_FILE;
    private List<WelcomeMessage> welcomeMessageList;


    public PropertiesReader(String propertiesName, Locale locale) throws IOException {
        this.NAME_PROJECT_CONFIG_FILE = propertiesName;
        init(locale);

    }

    private void init(Locale locale) throws IOException {
        LOG.info("start read from " + this.NAME_PROJECT_CONFIG_FILE);
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream in = loader.getResourceAsStream(this.NAME_PROJECT_CONFIG_FILE)) {
            prop.load(in);
            int numberOfWelcomeMessages = Integer.parseInt(prop.getProperty("numberOfWelcomeMessages"));
            LOG.info("number of different welcome messages: " + numberOfWelcomeMessages);
            welcomeMessageList = new ArrayList<>(numberOfWelcomeMessages);
            for (int i = 1; i <= numberOfWelcomeMessages; i++) {
                LOG.info("begin create " + i + " of " + numberOfWelcomeMessages + " different welcome messages");
                String propertyObjectName = "welcomeObj" + i;
                LocalTime from = getLocalTime(
                        prop.getProperty(propertyObjectName + ".from.hh")
                        , prop.getProperty(propertyObjectName + ".from.MM"));
                LocalTime to = getLocalTime(
                        prop.getProperty(propertyObjectName + ".to.hh")
                        , prop.getProperty(propertyObjectName + ".to.MM"));
                WelcomeMessage welcomeMessage = new WelcomeMessage(from, to);
                setStringMessageWithLocalization(welcomeMessage, propertyObjectName, locale);
                welcomeMessageList.add(welcomeMessage);
                LOG.info("finish create " + i + " of " + numberOfWelcomeMessages + " different welcome messages and add to list");
                if (LOG.isTraceEnabled()) {
                    LOG.trace(welcomeMessage.toString());
                }
            }
        }
        if (LOG.isTraceEnabled()) {
            LOG.trace("result of reading: " + welcomeMessageList.toString());
        }
        LOG.info("finish read from: " + this.NAME_PROJECT_CONFIG_FILE);
    }

    public List<WelcomeMessage> getWelcomeMessageList() {
        return welcomeMessageList;
    }

    private LocalTime getLocalTime(String hh, String mm) {
        return LocalTime.of(Integer.parseInt(hh), Integer.parseInt(mm));
    }

    public static void setStringMessageWithLocalization(WelcomeMessage welcomeMessage, String resourceObjName, Locale locale) {
        if (LOG.isTraceEnabled()) {
            LOG.trace("Start setting message in: " + resourceObjName);
        }
        //If there is no translate, then english
        Locale defLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);

        ResourceBundle bundle = ResourceBundle.getBundle("i18n/welcomeMessage", locale);
        String message = bundle.getString(resourceObjName + ".welcomeMessage");

        //return default locale after set english
        Locale.setDefault(defLocale);

        if (LOG.isTraceEnabled()) {
            LOG.trace("set the message :" + message + " to: " + resourceObjName);
        }
        welcomeMessage.setHelloMessage(message);
        if (LOG.isTraceEnabled()) {
            LOG.trace("Finish setting message in: " + resourceObjName);
        }
    }
}
